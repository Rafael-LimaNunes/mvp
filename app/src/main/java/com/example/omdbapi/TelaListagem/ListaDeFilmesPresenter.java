package com.example.omdbapi.TelaListagem;

import java.util.concurrent.ExecutionException;

class ListaDeFilmesPresenter implements ListaDeFilmesContract.Presenter {

    private ListaDeFilmes repositorio;

    ListaDeFilmesPresenter(ListaDeFilmesContract.View view) {

    }

    @Override
    public void carregarFilmes(String titulo, ListaDeFilmesCallBack listaDeFilmesCallBack) {
        try{
             repositorio = new ListaDeFilmesService(titulo).execute().get();
             if(repositorio != null) {
                 if (repositorio.resposta) {
                     listaDeFilmesCallBack.Carregado(repositorio.filmes);
                 } else {
                     listaDeFilmesCallBack.Erro("Filme não encotrado");
                 }
             }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

