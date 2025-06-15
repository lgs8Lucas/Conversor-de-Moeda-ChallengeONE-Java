package br.com.alura.conversor_de_moeda;
import br.com.alura.conversor_de_moeda.models.Currency;
import br.com.alura.conversor_de_moeda.models.CurrencyBank;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int from, to;
        double val;
        Scanner sc = new Scanner(System.in);
        System.out.println("***************************************");
        System.out.println("Iniciando Conversor de Moeda...");
        System.out.println("***************************************");
        CurrencyBank currencyBank = new CurrencyBank(new Currency[]{
                new Currency("Dólar americano", "USD"),
                new Currency("Dólar australiano", "AUD"),
                new Currency("Peso argentino", "ARS"),
                new Currency("Real brasileiro", "BRL"),
                new Currency("Peso colombiano", "COP"),
                new Currency("Euro", "EUR"),
                new Currency("Iene Japonês", "JPY"),
        });
        System.out.println("Valores atuais coletados da API!");
        System.out.println("Pressione ENTER para continuar");
        sc.nextLine();
        System.out.println("\n".repeat(50));

        while (true) {
            System.out.println("\n".repeat(50));
            System.out.println("***************************************");
            System.out.println("Conversor de Moeda");
            System.out.println("***************************************");

            System.out.println("Escolha a sua moeda atual (0 ou nenhuma opção para sair): ");
            System.out.println(currencyBank);
            System.out.print("Digite sua escolha: ");
            from = sc.nextInt()-1;

            if (currencyBank.isInValidCurrency(from)) break;

            System.out.print("Digite o valor que você possui: ");
            val = sc.nextDouble();

            System.out.println("Escolha a moeda que você deseja ter (0 ou nenhuma opção para voltar): ");
            System.out.println(currencyBank);
            System.out.print("Digite sua escolha: ");
            to = sc.nextInt()-1;

            if (currencyBank.isInValidCurrency(to)){
                continue;
            };

            currencyBank.printConversion(from, to, val);

            System.out.println("Pressione ENTER para continuar");
            sc.nextLine();
            sc.nextLine();
        }
        System.out.println("\nPrograma finalizado!");
    }
}