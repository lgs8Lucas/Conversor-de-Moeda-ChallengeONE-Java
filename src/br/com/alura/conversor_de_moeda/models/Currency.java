package br.com.alura.conversor_de_moeda.models;

import java.util.Map;

public class Currency {
    private String name;
    private String code;
    private Map<String, Double> conversionRates;

    public Currency(String name, CurrenciExchangeRateAPI api) {
        this.name = name;
        this.code = api.base_code();
        this.conversionRates = api.conversion_rates();
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double convert(String to, double val) {
        return conversionRates.get(to)*val;
    }
}
