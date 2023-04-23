package br.com.niles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {

    private CepDTO pesquisaCEP;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public void criarArquivo(CepDTO pesquisaCep) throws IOException {

        FileWriter escrita = new FileWriter("cep.json");
        escrita.write(gson.toJson(pesquisaCep));
        escrita.close();
    }
}
