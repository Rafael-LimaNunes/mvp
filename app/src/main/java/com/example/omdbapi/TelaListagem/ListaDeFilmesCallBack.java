package com.example.omdbapi.TelaListagem;

import java.util.List;

public interface ListaDeFilmesCallBack {
    void Carregado(List<Filme> resultado);
    void Erro(String erro);
}
