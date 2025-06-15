package br.com.alura.conversor_de_moeda.services;

import br.com.alura.conversor_de_moeda.models.CurrenciExchangeRateAPI;
import br.com.alura.conversor_de_moeda.properties.Properties;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ExchangeRateAPIRequest {
    HttpClient httpClient;
    String uriBase = "https://v6.exchangerate-api.com/v6/"+ Properties.apikey +"/latest/";
    Gson gson = new Gson();

    public ExchangeRateAPIRequest() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public CurrenciExchangeRateAPI GetExchangeRate(String base_code) throws IOException, InterruptedException {
        String uri = uriBase + base_code + "/";
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return gson.fromJson(response.body().toString(), CurrenciExchangeRateAPI.class);
    }
}
