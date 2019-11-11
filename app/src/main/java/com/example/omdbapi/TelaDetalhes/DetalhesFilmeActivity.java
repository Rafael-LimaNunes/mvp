package com.example.omdbapi.TelaDetalhes;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.omdbapi.R;
import com.squareup.picasso.Picasso;

public class DetalhesFilmeActivity extends AppCompatActivity implements DetalhesFilmeContract.View {

    private String imdbID;
    private DetalhesFilme retorno;
    private TextView titulo;
    private DetalhesFilmePresenter presenter;
    private TextView txtTitulo;
    private TextView txtAno;
    private TextView txtDuracao;
    private RatingBar txtAvaliacao;
    private TextView txtGenero;
    private TextView txtEnredo;
    private TextView txtDiretor;
    private TextView txtEscritores;
    private TextView txtAtores;
    private ImageView imgPoster;
    private Uri posterUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_filme);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Detalhes");     //Titulo para ser exibido na sua Action Bar em fren
        imdbID = getIntent().getStringExtra("imdbID");
        presenter = new DetalhesFilmePresenter(this);

        txtTitulo = findViewById(R.id.titulo2);
        txtAno = findViewById(R.id.txtAno2);
        txtDuracao = findViewById(R.id.duracao);
        txtAvaliacao = findViewById(R.id.avaliacao);
        txtGenero = findViewById(R.id.genero);
        txtEnredo = findViewById(R.id.txtEnredo);
        txtDiretor = findViewById(R.id.nomeDiretor);
        txtEscritores = findViewById(R.id.escritorres);
        txtAtores = findViewById(R.id.atores);
        imgPoster = findViewById(R.id.imgPoster);

 presenter.carregarDetalheFilmes(imdbID, new DetalhesFilmesCallBack() {
     @Override
     public void carregado(DetalhesFilme resultado) {
         mostrarDetalhesFilme(resultado);
     }

     @Override
     public void erro(String erro) {
         Toast.makeText(getApplicationContext(),erro,Toast.LENGTH_LONG).show();
     }
 });

    }

    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                onBackPressed();
        }
        return true;
    }

    @Override
    public void mostrarDetalhesFilme(DetalhesFilme filme) {
        txtTitulo.setText(filme.titulo);
        txtAno.setText(filme.ano);
        txtDuracao.setText(filme.duracao);
        txtEnredo.setText(filme.enredo);
        txtAvaliacao.setRating((float) (filme.imRating/2));
        txtGenero.setText(filme.genero);
        txtDiretor.setText(filme.diretor);
        txtEscritores.setText(filme.escritor);
        txtAtores.setText(filme.atores);
         posterUri = Uri.parse(filme.poster);
        Picasso.get().load(posterUri).into(imgPoster);



    }
}
