package com.example.omdbapi.TelaListagem;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class ListaDeFilmes {
    @SerializedName("Search") List<Filme> filmes;
    @SerializedName("totalResults") int total;
    @SerializedName("Response") boolean resposta = false;


}
