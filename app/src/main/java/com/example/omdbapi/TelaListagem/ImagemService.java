package com.example.omdbapi.TelaListagem;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class ImagemService {

    private Bitmap imagem;
    private Handler handler = new Handler();

    public void baixarImagem(final String poster, final ImageView view){
         new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL(poster);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    connection.connect();
                    InputStream inputStream = connection.getInputStream();
                     imagem = BitmapFactory.decodeStream(inputStream);
                    Log.i("Livro", "Baixou imagem");

                    handler.post( new Runnable(){
                        public void run(){
                          view.setImageBitmap(imagem);
                        }
                    });


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();
        return;
    }
}
