package com.example.omdbapi.TelaListagem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.omdbapi.R;

import java.util.List;

public class ListaDeFilmesActivity extends AppCompatActivity implements ListaDeFilmesContract.View{

    private EditText pesquisa;
    private RecyclerView recyclerView;
    private Button btnBuscar;
    private ListaDeFilmesAdapter adaptador;
    private ListaDeFilmesPresenter presenter;
    private SearchView pesquisa2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        presenter = new ListaDeFilmesPresenter(this);
        pesquisa = findViewById(R.id.etTitulo);
        btnBuscar  = findViewById(R.id.btnBuscar);
        recyclerView = findViewById(R.id.recyclerView);


        btnBuscar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

        presenter.carregarFilmes(pesquisa.getText().toString(), new ListaDeFilmesCallBack() {
            @Override
            public void Carregado(List<Filme> resultado) {
              mostrarFilmes(resultado);
            }

            @Override
            public void Erro(String erro) {
                Toast.makeText(getApplicationContext(),erro,Toast.LENGTH_LONG).show();
            }
        });


            }
        });

    }

    @Override
    public void mostrarFilmes(List<Filme> filmes) {
        recyclerView.setVisibility(View.VISIBLE);
        adaptador = new ListaDeFilmesAdapter(this, filmes);

        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
}
