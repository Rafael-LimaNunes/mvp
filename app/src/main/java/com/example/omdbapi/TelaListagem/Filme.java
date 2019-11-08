package com.example.omdbapi.TelaListagem;

import com.google.gson.annotations.SerializedName;

class Filme {
    @SerializedName("Title") String titulo;
    @SerializedName("Year") String ano;
    @SerializedName("imdbID") String id;
    @SerializedName("Type") String tipo;
    @SerializedName("Poster") String poster;
}
