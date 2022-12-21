package fr.cytech.cy_crypto.component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import fr.cytech.cy_crypto.model.ClassicCurrency;
import fr.cytech.cy_crypto.model.CryptoCurrency;
import fr.cytech.cy_crypto.model.CurrencyHistory;
import fr.cytech.cy_crypto.model.CurrencyInformation;
import fr.cytech.cy_crypto.services.CurrencyService;

@Component
public class CurrencyApiThread extends Thread {

	private String GET_HISTORY_URL;

    private String GET_INFORMATION_URL;

    private String API_KEY;

    @Autowired
    CurrencyService currencyService;
    
    private CurrencyApiThread(){
        this.GET_HISTORY_URL = "https://min-api.cryptocompare.com/data/v2/histoday?";
        this.GET_INFORMATION_URL = "https://min-api.cryptocompare.com/data/pricemultifull?";
        this.API_KEY = "&api_key=2737b83931da2d3c1736bbaa5dfc89553b493edc734c32be3b333933cc36e9ee";
    }

    @PostConstruct
    private void init() {
        this.start();
    }

    @Override
    public void run() {
        apiCalls();
    }

    private void apiCalls() {
        historyCalls();
    }

    @Scheduled(cron = "30 0 0 * * *")
    private void historyCalls() {
        System.out.println("History api calls...");
        List<CryptoCurrency> currencies = currencyService.findAll();
        if (!currencies.isEmpty()) {
            for (CryptoCurrency currency : currencies) {
                for (ClassicCurrency classicCurrency : ClassicCurrency.values()) {
                    try {
                        sendGETHistory(currency.getSymbol(), classicCurrency.toString());
                    } catch (IOException e) {
                        System.err.println("History Thread : Error while sending GET request: " + e.getMessage());
                    }
                }
            }
        } else {
            System.err.println("History Thread : No currency in database.");
        }
        System.out.println("History api calls done.");
    }

	private void sendGETHistory(String cryptoCurrency, String toConvertCurrency) throws IOException {
		URL url = new URL(GET_HISTORY_URL+"fsym=" + cryptoCurrency + "&tsym=" + toConvertCurrency + API_KEY);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		int responseCode = connection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
            JSONParser parser = new JSONParser();
            try {
                System.err.println("Parsing history for " + cryptoCurrency + "/" + toConvertCurrency);
                List<CurrencyHistory> currencyHistoryModels = new ArrayList<>();
                JSONObject jsonObj = (JSONObject) parser.parse(new InputStreamReader(connection.getInputStream()));
                JSONObject data = (JSONObject) jsonObj.get("Data");
                JSONArray history = (JSONArray) data.get("Data");
                for (Object object : history) {
                    try {
                        CurrencyHistory currencyHistoryModel = new CurrencyHistory();
                        JSONObject historyObject = (JSONObject) object;
                        currencyHistoryModel.setConvertedTo(ClassicCurrency.valueOf(toConvertCurrency));
                        currencyHistoryModel.setTime(Long.parseLong(historyObject.get("time").toString()));
                        currencyHistoryModel.setHigh(Double.parseDouble(historyObject.get("high").toString()));
                        currencyHistoryModel.setLow(Double.parseDouble(historyObject.get("low").toString()));
                        currencyHistoryModel.setOpen(Double.parseDouble(historyObject.get("open").toString()));
                        currencyHistoryModel.setVolumefrom(Double.parseDouble(historyObject.get("volumefrom").toString()));
                        currencyHistoryModel.setVolumeto(Double.parseDouble(historyObject.get("volumeto").toString()));
                        currencyHistoryModel.setClose(Double.parseDouble(historyObject.get("close").toString()));
                        currencyHistoryModels.add(currencyHistoryModel);
                    } catch (Exception e) {
                        System.err.println("History Thread : Error while parsing history for " + cryptoCurrency + "/" + toConvertCurrency + " : " + e.getMessage());
                    }
                    
                }
                CryptoCurrency currencyModel = currencyService.find(cryptoCurrency);
                currencyModel.setHistory(currencyHistoryModels);
                currencyService.save(currencyModel);
            } catch (ParseException e) {
                System.err.println("History Thread : Error while parsing JSON: " + e.getMessage());
            }

		} else {
			System.err.println("GET request about history for " + cryptoCurrency+ "/"+ toConvertCurrency + " did not work.");
		}
        connection.disconnect();
	}

    @Scheduled(cron = "0 * * * * *")
    private void informationsCall() {
        System.out.println("Information api call...");
        List<CryptoCurrency> currencies = currencyService.findAll();
        if (!currencies.isEmpty()) {
            String currencyString = "";
            for (CryptoCurrency currency : currencies) {
                if (currencyString.length() > 0) {
                    currencyString += ",";
                }
                currencyString += currency.getSymbol();
            }
            String toConvertCurrencyString = "";
            for (ClassicCurrency classicCurrency : ClassicCurrency.values()) {
                if (toConvertCurrencyString.length() > 0) {
                    toConvertCurrencyString += ",";
                }
                toConvertCurrencyString += classicCurrency.toString();
            }
            try {
                sendGET(currencyString, toConvertCurrencyString);
            } catch (Exception e) {
                System.err.println("Information Thread : Error while sending GET request for: " + e.getMessage());
            }
        } else {
            System.err.println("Information Thread : No currency in database.");
        }
        System.out.println("Information api call done.");
    }

	private void sendGET(String currencyString, String toConvertCurrencyString) throws IOException {
		URL url = new URL(GET_INFORMATION_URL+"fsyms=" + currencyString + "&tsyms=" + toConvertCurrencyString + API_KEY);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		int responseCode = connection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
            JSONParser parser = new JSONParser();
            try {
                JSONObject jsonObj = (JSONObject) parser.parse(new InputStreamReader(connection.getInputStream()));
                JSONObject data = (JSONObject) jsonObj.get("RAW");
                for (String currency : currencyString.split(",")) {
                    JSONObject currencyInformationObject = (JSONObject) data.get(currency);
                    List<CurrencyInformation> currencyInformationModels = new ArrayList<>();
                    for (String classicCurrency : toConvertCurrencyString.split(",")) {
                        JSONObject currencyInformationObject2 = (JSONObject) currencyInformationObject.get(classicCurrency);
                        CurrencyInformation currencyInformationModel = new CurrencyInformation();
                        currencyInformationModel.setConvertedTo(ClassicCurrency.valueOf(classicCurrency));
                        currencyInformationModel.setPrice(Double.parseDouble(currencyInformationObject2.get("PRICE").toString()));
                        currencyInformationModel.setMedian(Double.parseDouble(currencyInformationObject2.get("MEDIAN").toString()));
                        currencyInformationModel.setVolumeDay(Double.parseDouble(currencyInformationObject2.get("VOLUMEDAY").toString()));
                        currencyInformationModel.setVolumeDayTo(Double.parseDouble(currencyInformationObject2.get("VOLUMEDAYTO").toString()));
                        currencyInformationModel.setVolume24hour(Double.parseDouble(currencyInformationObject2.get("VOLUME24HOUR").toString()));
                        currencyInformationModel.setVolume24hourTo(Double.parseDouble(currencyInformationObject2.get("VOLUME24HOURTO").toString()));
                        currencyInformationModel.setOpenDay(Double.parseDouble(currencyInformationObject2.get("OPENDAY").toString()));
                        currencyInformationModel.setHighDay(Double.parseDouble(currencyInformationObject2.get("HIGHDAY").toString()));
                        currencyInformationModel.setLowDay(Double.parseDouble(currencyInformationObject2.get("LOWDAY").toString()));
                        currencyInformationModel.setVolumeHour(Double.parseDouble(currencyInformationObject2.get("VOLUMEHOUR").toString()));
                        currencyInformationModel.setVolumeHourTo(Double.parseDouble(currencyInformationObject2.get("VOLUMEHOURTO").toString()));
                        currencyInformationModel.setOpenHour(Double.parseDouble(currencyInformationObject2.get("OPENHOUR").toString()));
                        currencyInformationModel.setHighHour(Double.parseDouble(currencyInformationObject2.get("HIGHHOUR").toString()));
                        currencyInformationModel.setLowHour(Double.parseDouble(currencyInformationObject2.get("LOWHOUR").toString()));
                        currencyInformationModels.add(currencyInformationModel);
                    }
                    CryptoCurrency currencyModel = currencyService.find(currency);
                    currencyModel.setInformation(currencyInformationModels);
                    currencyService.save(currencyModel);
                }
            } catch (ParseException e) {
                System.err.println("Information Thread : Error while parsing JSON: " + e.getMessage());
            }

		} else {
			System.err.println("GET request about informations did not work.");
		}
        connection.disconnect();
	}
}
