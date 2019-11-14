package com.example.omdbapi.TelaListagem;

import android.graphics.Movie;

import java.util.List;
import java.util.concurrent.ExecutionException;

class ListaDeFilmesPresenter implements ListaDeFilmesContract.Presenter {
    static int page = 1;
    private ListaDeFilmes repositorio;

   /* ListaDeFilmesService service = new ListaDeFilmesService();
    service.getMovieList(_title, PAGE.toString(), object : MovieServiceApi.MovieCallback<List<Movie>> {
        override fun onLoaded(result: List<Movie>, totalItems: Int) {
            if (PAGE == 1) {
                view.displayMovies(result)
            }
            else{
                view.getAdapter().updateItems(result)
                view.getAdapter().notifyDataSetChanged()
            }
            PAGE += 1
        }*/
    ListaDeFilmesPresenter(ListaDeFilmesContract.View view) {
    }



    @Override
    public void carregarFilmes(String titulo,int pagina, ListaDeFilmesCallBack listaDeFilmesCallBack) {
        try{
             repositorio = new ListaDeFilmesService(titulo,pagina).execute().get();
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

