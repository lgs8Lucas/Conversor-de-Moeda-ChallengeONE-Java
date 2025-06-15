package br.com.alura.conversor_de_moeda;
import br.com.alura.conversor_de_moeda.models.Currency;
import br.com.alura.conversor_de_moeda.services.ExchangeRateAPIRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ExchangeRateAPIRequest api = new ExchangeRateAPIRequest();
        Scanner sc = new Scanner(System.in);
        Currency[] currencies = {
                new Currency("Dólar americano", "USD"),
                new Currency("Peso argentino", "ARS"),
                new Currency("Real brasileiro", "BRL"),
                new Currency("Peso colombiano", "COP"),
                new Currency("Euro", "EUR")
        };
        int from, to;
        double val;

        for (int i = 0; i < currencies.length; i++) {
            try {
                currencies[i].setConversionRates(api.GetExchangeRate(currencies[i].getCode()));
            } catch (IOException | InterruptedException e){
                System.out.println("Erro ao coletar dados "+currencies[i].getName()+", removido da lista");
                currencies[i] =  null;
            }
        }



        while (true) {
            System.out.println("***************************************");
            System.out.println("Conversor de Moeda");

            System.out.println("Escolha a sua moeda atual (ou nenhuma opção para sair): ");
            for (int i = 0; i < currencies.length; i++) {
                System.out.println(i+1+") "+currencies[i].getName());
            }

            System.out.print("Digite sua escolha: ");

            from = sc.nextInt()-1;

            if (from >= currencies.length || from < 0 || currencies[from] == null) {
                break;
            }

            System.out.print("Digite o valor que você possui: ");
            val = sc.nextDouble();

            System.out.println("Escolha a moeda que você deseja ter (ou nenhuma opção para voltar): ");
            for (int i = 0; i < currencies.length; i++) {
                System.out.println(i+1+") "+currencies[i].getName());
            }

            System.out.print("Digite sua escolha: ");

            to = sc.nextInt()-1;

            if (to >= currencies.length || to < 0 || currencies[to] == null) {
                continue;
            }

            System.out.printf("\nCom: %.2f (%s), convertendo para %s, você terá %.2f %s ",
                    val,
                    currencies[from].getCode(),
                    currencies[to].getName(),
                    currencies[from].convert(currencies[to].getCode(), val),
                    currencies[to].getCode()
            );
            System.out.println("Pressione ENTER para continuar");
            sc.nextLine();
            sc.nextLine();
            System.out.println("\n\n\n");
        }
    }
}