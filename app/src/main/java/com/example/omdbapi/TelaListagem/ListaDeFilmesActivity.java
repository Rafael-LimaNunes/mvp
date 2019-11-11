package com.example.omdbapi.TelaListagem;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.omdbapi.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class ListaDeFilmesActivity extends AppCompatActivity implements ListaDeFilmesContract.View{

    private EditText pesquisa;
    private RecyclerView recyclerView;
    private Button btnBuscar;
    private ListaDeFilmesAdapter adaptador;
    private ListaDeFilmesPresenter presenter;
    private SearchView pesquisa2;
    private TextInputLayout pesquisaTitulo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = findViewById(R.id.toolbar);*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Filmes OMDB");     //Titulo para ser exibido na sua Action Bar em frente à seta
        presenter = new ListaDeFilmesPresenter(this);
        pesquisa = findViewById(R.id.etTitulo);
        btnBuscar  = findViewById(R.id.btnBuscar);
        recyclerView = findViewById(R.id.recyclerView);
//        pesquisaTitulo = findViewById(R.id.filmeTituloLayout);
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
                View contextView = findViewById(R.id.btnBuscar);
                

                Snackbar.make(contextView, R.string.filme_nao_encontrado, Snackbar.LENGTH_LONG)
                        .show();
            }
        });


            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

    @Override
    public void mostrarFilmes(List<Filme> filmes) {
        recyclerView.setVisibility(View.VISIBLE);
        adaptador = new ListaDeFilmesAdapter(this, filmes);

        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
}
