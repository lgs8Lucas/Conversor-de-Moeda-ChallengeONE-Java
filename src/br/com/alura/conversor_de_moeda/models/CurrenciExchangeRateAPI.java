package br.com.alura.conversor_de_moeda.models;

import java.util.Map;

public record CurrenciExchangeRateAPI(String result, String base_code, Map<String, Double> conversion_rates) {

}
