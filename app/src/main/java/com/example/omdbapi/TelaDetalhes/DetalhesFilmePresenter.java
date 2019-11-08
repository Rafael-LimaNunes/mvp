package com.example.omdbapi.TelaDetalhes;

import java.util.concurrent.ExecutionException;

class DetalhesFilmePresenter implements DetalhesFilmeContract.Presenter {


    public DetalhesFilmePresenter(DetalhesFilmeContract.View view) {
    }

    @Override
    public void carregarDetalheFilmes(String imdbID, DetalhesFilmesCallBack detalhesFilmeCallBack) {
        DetalhesFilme repositorio = null;
        try {
            repositorio = new DetalhesFilmeService(imdbID).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (repositorio.resposta){
            detalhesFilmeCallBack.carregado(repositorio);
        }else{
            detalhesFilmeCallBack.erro("Náo foi possivel carregar os detalhes do filme");
        }

    }
}
