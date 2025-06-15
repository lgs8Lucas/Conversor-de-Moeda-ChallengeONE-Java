package br.com.alura.conversor_de_moeda.models;

import br.com.alura.conversor_de_moeda.services.ExchangeRateAPIRequest;

import java.io.IOException;
import java.util.stream.IntStream;

public class CurrencyBank {
    private Currency[] currencies;

    public CurrencyBank(Currency[] currencies) {
        this.currencies = currencies;
        ExchangeRateAPIRequest api = new ExchangeRateAPIRequest();
        for (int i = 0; i < currencies.length; i++) {
            try {
                currencies[i].setConversionRates(api.GetExchangeRate(currencies[i].getCode()));
            } catch (IOException | InterruptedException e){
                System.out.println("Erro ao coletar dados, "+currencies[i].getName()+", removido da lista");
                currencies[i] =  null;
            }
        }
    }

    @Override
    public String toString() {
        return IntStream.range(0, currencies.length)
            .filter(i -> currencies[i] != null) // Ignora nulos
            .mapToObj(i -> String.format("%d) %s", i + 1, currencies[i].getName()))
            .reduce((a, b) -> a + "\n" + b)
            .orElse("");
    }

    public Boolean isInValidCurrency(int i){
        return i >= currencies.length || i < 0 || currencies[i] == null;
    }

    public void printConversion(int from, int to, double val){
        System.out.printf("\nCom: %.2f (%s), convertendo para %s, você terá %.2f %s \n",
                val,
                currencies[from].getCode(),
                currencies[to].getName(),
                currencies[from].convert(currencies[to].getCode(), val),
                currencies[to].getCode()
        );
    }
}
