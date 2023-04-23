package br.com.niles;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException, InterruptedException {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o numero do CEP a ser pesquisado: ");
        String cep = scanner.nextLine();

        ConsultaCEP consulta = new ConsultaCEP();
        GeradorDeArquivo gerador = new GeradorDeArquivo();
        CepDTO endereco = consulta.criarConsulta(cep);
        gerador.criarArquivo(endereco);

        System.out.println(endereco);

    }
}
