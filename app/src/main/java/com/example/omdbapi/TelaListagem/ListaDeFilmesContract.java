package com.example.omdbapi.TelaListagem;

import java.util.List;

public class ListaDeFilmesContract{



    interface View{
        void mostrarFilmes(List<Filme> filmes);
/*        ListaDeFilmesAdapter getAdapter();*/



    }

    interface Presenter{
        void carregarFilmes(String titulo,int pagina, ListaDeFilmesCallBack listaDeFilmesCallBack);

    }

}
