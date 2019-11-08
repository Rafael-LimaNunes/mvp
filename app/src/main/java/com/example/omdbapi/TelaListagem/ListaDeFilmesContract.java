package com.example.omdbapi.TelaListagem;

import java.util.List;

public class ListaDeFilmesContract{

    interface View{
        void mostrarFilmes(List<Filme> filmes);

    }

    interface Presenter{
        void carregarFilmes(String titulo, ListaDeFilmesCallBack listaDeFilmesCallBack);

    }

}
