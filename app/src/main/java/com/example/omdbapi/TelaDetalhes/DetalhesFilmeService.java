package com.example.omdbapi.TelaDetalhes;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class DetalhesFilmeService extends AsyncTask<Void,Void, DetalhesFilme> {


    private String imdbID;

    public DetalhesFilmeService(String imdbID) {
        this.imdbID = imdbID;
    }

    @Override
    protected DetalhesFilme doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();

        if (!imdbID.isEmpty()) {
            try {
                URL url = new URL("https://www.omdbapi.com/?i=" + imdbID + "&apikey=e2a2df13");
                HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                conexao.setRequestMethod("GET");
                conexao.setRequestProperty("Content-type", "application/json");
                conexao.setRequestProperty("Accept", "application/json");
                conexao.setConnectTimeout(5000);
                conexao.connect();
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNextLine()){
                    resposta.append(scanner.nextLine());
                }
            }
                 catch(ProtocolException e){
                    e.printStackTrace();
                } catch(MalformedURLException e){
                    e.printStackTrace();
                } catch(IOException e){
                    e.printStackTrace();
                }

        }
        return new Gson().fromJson(resposta.toString(), DetalhesFilme.class);
    }

}


