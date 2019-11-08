package com.example.omdbapi.TelaListagem;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.omdbapi.R;
import com.example.omdbapi.TelaDetalhes.DetalhesFilmeActivity;
import com.squareup.picasso.Picasso;

import java.util.List;



class ListaDeFilmesAdapter extends RecyclerView.Adapter<ListaDeFilmesAdapter.ViewHolder> {

    private List<Filme> filmes;
    private Context context;


    ListaDeFilmesAdapter(Context context, List<Filme> filmes) {
        this.filmes = filmes;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.filme_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Filme filme = filmes.get(position);
        final String id = filme.id;


        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent detailsIntent = new Intent(context, DetalhesFilmeActivity.class);
                detailsIntent.putExtra("imdbID", id);
                context.startActivity(detailsIntent);
            }
        });

        holder.titulo.setText(filme.titulo);
        holder.tipo.setText(filme.tipo);
        holder.ano.setText(filme.ano);
        holder.posterUri = Uri.parse(filme.poster);
       /* ImagemService service = new ImagemService();
        service.baixarImagem(filme.poster, holder.poster);*/


        Picasso.get()
                .load(holder.posterUri)
                .fit().centerCrop()
                .into(holder.poster);

    }


    @Override
    public int getItemCount() {
      return filmes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titulo;
        private TextView tipo;
        private TextView ano;
        private ImageView poster;
        private Uri posterUri;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.txtTitulo);
            tipo = itemView.findViewById(R.id.txtTipo);
            ano = itemView.findViewById(R.id.txtAno);
            poster = itemView.findViewById(R.id.imgPoster);
        }
    }
}
