package com.example.omdbapi.TelaListagem;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class ListaDeFilmesService extends AsyncTask<Void,Void,ListaDeFilmes> {

    private String titulo;
    private static int page = 1;

    public ListaDeFilmesService() {}

    public ListaDeFilmesService(String titulo, int page) {
        this.titulo = titulo;
        this.page = page;
    }

    public Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com/?s=$title&apikey=e43f18834")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    protected ListaDeFilmes doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();
        try {
            URL url = new URL("https://www.omdbapi.com/?s="+titulo+"&apikey=e2a2df13&page="+page);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept","application/json");
            connection.setConnectTimeout(5000);
            connection.connect();
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNextLine()){
                resposta.append(scanner.nextLine());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Gson().fromJson(resposta.toString(), ListaDeFilmes.class);
    }


}
