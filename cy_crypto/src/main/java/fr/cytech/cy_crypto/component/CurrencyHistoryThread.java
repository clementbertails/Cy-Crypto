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

import fr.cytech.cy_crypto.modele.ClassicCurrency;
import fr.cytech.cy_crypto.modele.CurrencyHistoryModel;
import fr.cytech.cy_crypto.modele.CurrencyModel;
import fr.cytech.cy_crypto.services.CurrencyService;

@Component
public class CurrencyHistoryThread extends Thread {

	private String GET_URL;

    private String API_KEY;

    @Autowired
    CurrencyService currencyService;
    
    private CurrencyHistoryThread(){
        this.GET_URL = "https://min-api.cryptocompare.com/data/v2/histoday?";
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

    @Scheduled(cron = "0 0 0 * * *")
    private void apiCalls() {
        System.out.println("History api calls...");
        List<CurrencyModel> currencies = currencyService.findAll();
        if (!currencies.isEmpty()) {
            for (CurrencyModel currency : currencies) {
                for (ClassicCurrency classicCurrency : ClassicCurrency.values()) {
                    try {
                        sendGET(currency.getSymbol(), classicCurrency.toString());
                    } catch (IOException e) {
                        System.err.println("Error while sending GET request: " + e.getMessage());
                    }
                }
            }
        } else {
            System.err.println("No currency in database.");
        }
        System.out.println("History api calls done.");
    }

	private void sendGET(String cryptoCurrency, String toConvertCurrency) throws IOException {
		URL url = new URL(GET_URL+"fsym=" + cryptoCurrency + "&tsym=" + toConvertCurrency + API_KEY);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		int responseCode = connection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
            JSONParser parser = new JSONParser();
            try {
                List<CurrencyHistoryModel> currencyHistoryModels = new ArrayList<>();
                JSONObject jsonObj = (JSONObject) parser.parse(new InputStreamReader(connection.getInputStream()));
                JSONObject data = (JSONObject) jsonObj.get("Data");
                JSONArray history = (JSONArray) data.get("Data");
                for (Object object : history) {
                    try {
                        CurrencyHistoryModel currencyHistoryModel = new CurrencyHistoryModel();
                        JSONObject historyObject = (JSONObject) object;
                        currencyHistoryModel.setConvertedTo(ClassicCurrency.valueOf(toConvertCurrency));
                        currencyHistoryModel.setTime((Long) historyObject.get("time"));
                        currencyHistoryModel.setHigh((Double) historyObject.get("high"));
                        currencyHistoryModel.setLow((Double) historyObject.get("low"));
                        currencyHistoryModel.setOpen((Double) historyObject.get("open"));
                        currencyHistoryModel.setVolumefrom((Double) historyObject.get("volumefrom"));
                        currencyHistoryModel.setVolumeto((Double) historyObject.get("volumeto"));
                        currencyHistoryModel.setClose((Double) historyObject.get("close"));
                        currencyHistoryModels.add(currencyHistoryModel);
                    } catch (Exception e) {
                        System.err.println("Error while parsing JSON: " + e.getMessage());
                    }
                    
                }
                CurrencyModel currencyModel = currencyService.findBySymbol(cryptoCurrency);
                currencyModel.setHistory(currencyHistoryModels);
                currencyService.save(currencyModel);
            } catch (ParseException e) {
                System.err.println("Error while parsing JSON: " + e.getMessage());
            }

		} else {
			System.err.println("GET request about history for " + cryptoCurrency+ "/"+ toConvertCurrency + " did not work.");
		}
        connection.disconnect();
	}
}
