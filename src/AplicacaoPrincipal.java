import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AplicacaoPrincipal {
    public static void main(String[] args) {
        String apiKey = "5e61937db8787fb96696c712";

        ConsultaCambio cambio = new ConsultaCambio(apiKey);
        ConversorDeMoeda conversor = new ConversorDeMoeda();
        GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
        Scanner input = new Scanner(System.in);
        TaxasDeCambio taxa;

        try {
            System.out.printf("Buscado taxas de câmbio...\n");
            taxa = cambio.buscarTaxas("USD");
            System.out.printf("Taxas atualizadas com sucesso!\n");
        } catch (RuntimeException e) {
            System.out.printf("Erro ao iniciar a aplicação: " + e.getMessage());
            return;
        }
        while (true) {
            System.out.printf("\n**************************************************\n");
            System.out.printf("Seja bem-vindo ao Conversor de Moedas\n");
            System.out.printf("1. Dólar (USD) => Real (BRL)\n");
            System.out.printf("2. Real (BRL) => Dólar (USD)\n");
            System.out.printf("3. Euro (EUR) => Dólar (USD)\n");
            System.out.printf("4. Dólar (USD) => Euro (EUR)\n");
            System.out.printf("5. Peso argentino (ARS) => Dólar (USD)\n");
            System.out.printf("6. Dólar (USD) => Peso argentino (ARS)\n");
            System.out.printf("7. Sair\n");
            System.out.printf("**************************************************\n");
            System.out.printf("Digite uma opção: ");

            try {
                int opcao = input.nextInt();

                if (opcao == 7) {
                    System.out.println("Obrigado por usar o programa Conversor de Moedas! Saindo...");
                    break;
                }
                if (opcao < 1 || opcao > 6) {
                    System.out.printf("Opção inválida! Por favor, tente novamente.");
                    continue;
                }

                System.out.printf("Digite o valor que deseja converter: ");
                double valor = input.nextDouble();

                String moedaOrigem = "";
                String moedaDestino = "";

                switch (opcao) {
                    case 1:
                        moedaOrigem = "USD";
                        moedaDestino = "BRL";
                        break;
                    case 2:
                        moedaOrigem = "BRL";
                        moedaDestino = "USD";
                        break;
                    case 3:
                        moedaOrigem = "EUR";
                        moedaDestino = "USD";
                        break;
                    case 4:
                        moedaOrigem = "USD";
                        moedaDestino = "EUR";
                        break;
                    case 5:
                        moedaOrigem = "ARS";
                        moedaDestino = "USD";
                        break;
                    case 6:
                        moedaOrigem = "USD";
                        moedaDestino = "ARS";
                        break;
                }

                double valorConvertido = conversor.converter(valor, moedaOrigem, moedaDestino, taxa);
                System.out.printf("--------------------------------------------------\n");
                System.out.printf("O valor de %.2f [%s] corresponde a %.2f [%s]", valor, moedaOrigem, valorConvertido, moedaDestino);
                System.out.printf("\n--------------------------------------------------\n");

                String registro = String.format("O valor de %.2f [%s] corresponde a %.2f [%s]", valor, moedaOrigem, valorConvertido, moedaDestino);
                geradorDeArquivo.registrarConversao(registro);

            } catch (InputMismatchException e) {
                System.out.printf("Erro: Por favor, digite um número válido para a opção e para o valor.");
                input.next();
            } catch (Exception e) {
                System.out.printf("Ocorreu um erro inesperado: ", e.getMessage());
            }
        }
        input.close();
    }
}
