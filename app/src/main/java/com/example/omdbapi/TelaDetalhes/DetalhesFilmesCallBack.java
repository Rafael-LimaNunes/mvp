package com.example.omdbapi.TelaDetalhes;

interface DetalhesFilmesCallBack {
    void carregado(DetalhesFilme resultado);
    void erro(String erro);

}
