package com.example.omdbapi.TelaDetalhes;

public class DetalhesFilmeContract {


    interface View{
        void mostrarDetalhesFilme(DetalhesFilme filme);
    }

    interface Presenter{
        void carregarDetalheFilmes(String imdbID, DetalhesFilmesCallBack detalhesFilmeCallBack);
    }
}
