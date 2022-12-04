package fr.cytech.cy_crypto.component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
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
        while (true) {
            apiCalls();
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + e.getMessage());
            }
        }
    }

    private void apiCalls() {
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
                // parseResponse(response);
            }
        } else {
            System.err.println("No currency in database.");
        }
        
    }

    private CurrencyHistoryModel parseResponse(){
        

        return null;
    }

	private void sendGET(String cryptoCurrency, String toConvertCurrency) throws IOException {
		URL obj = new URL(GET_URL+"fsym=" + cryptoCurrency + "&tsym=" + toConvertCurrency + API_KEY);
		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		connection.setRequestMethod("GET");
		int responseCode = connection.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			// BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			// String inputLine;
			// StringBuffer response = new StringBuffer();

			// while ((inputLine = in.readLine()) != null) {
			// 	response.append(inputLine);
			// }
			// in.close();
			// // print result
			// System.out.println(response.toString());

		} else {
			System.err.println("GET request about history for " + cryptoCurrency+ "/"+ toConvertCurrency + " did not work.");
		}
        connection.disconnect();
	}
}
