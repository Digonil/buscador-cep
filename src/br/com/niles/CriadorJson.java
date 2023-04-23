package br.com.niles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CriadorJson {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
}
