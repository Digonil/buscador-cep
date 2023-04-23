package br.com.niles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException, InterruptedException {

        Locale.setDefault(Locale.US);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o numero do cep a ser pesquisado: ");
        String cep = scanner.nextLine();

        String endereco = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco)).build();

        HttpResponse<String> response = cliente
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        CepDTO pesquisaCep = gson.fromJson(json, CepDTO.class);

        FileWriter escrita = new FileWriter("cep.json");
        escrita.write(gson.toJson(pesquisaCep));
        escrita.close();

        System.out.println(json);
    }
}
