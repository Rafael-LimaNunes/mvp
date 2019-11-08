package com.example.omdbapi.TelaDetalhes;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetalhesFilme {
    @SerializedName("Title")  String titulo;
    @SerializedName("Year") String ano;
    @SerializedName("Rated") String rated;
    @SerializedName("Released")  String lancado;
    @SerializedName("Runtime") String duracao;
    @SerializedName("Genre")  String genero;
    @SerializedName("Director") String diretor;
    @SerializedName("Writer")  String escritor;
    @SerializedName("Actors") String atores;
    @SerializedName("Plot")  String enredo;
    @SerializedName("Language") String idioma;
    @SerializedName("Country")String pais;
    @SerializedName("Awards")  String premios;
    @SerializedName("Poster") String poster;
    @SerializedName("Ratings") List<Ratings> rating;
    @SerializedName("Metascore")String metascore;
    @SerializedName("imdbRating") Double imRating;
    @SerializedName("imdbVotes") String votos;
    @SerializedName("imdbID")  String imdbID;
    @SerializedName("Type")  String tipo;
    @SerializedName("DVD")String dvd;
    @SerializedName("BoxOffice") String boxoffice;
    @SerializedName("Production") String producao;
    @SerializedName("Website") String website;
    @SerializedName("Response")Boolean resposta;
}
