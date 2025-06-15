package br.com.alura.conversor_de_moeda;

import br.com.alura.conversor_de_moeda.services.ExchangeRateAPIRequest;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        ExchangeRateAPIRequest api = new ExchangeRateAPIRequest();
        try {
            System.out.println(api.GetExchangeRate("USD"));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}