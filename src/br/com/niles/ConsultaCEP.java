package br.com.niles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCEP {

    private String Cep;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public CepDTO criarConsulta(String cep) throws IOException, InterruptedException {

        String endereco = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco)).build();

        HttpResponse<String> response = cliente
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        CepDTO pesquisaCep = gson.fromJson(json, CepDTO.class);

        return pesquisaCep;
    }

    public FileWriter criarArquivo(CepDTO pesquisaCep) throws IOException {

        FileWriter escrita = new FileWriter("cep.json");
        escrita.write(gson.toJson(pesquisaCep));
        escrita.close();

        return escrita;
    }


}
