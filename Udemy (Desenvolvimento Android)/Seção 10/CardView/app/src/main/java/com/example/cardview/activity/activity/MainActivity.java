package com.example.cardview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.cardview.R;
import com.example.cardview.activity.adapter.PostagemAdapter;
import com.example.cardview.activity.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens = new ArrayList<>();


    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerView);

        //Definir Layout
       LinearLayoutManager layoutManager = new LinearLayoutManager(this);
       layoutManager.setOrientation(LinearLayout.VERTICAL);
       // (GridLayout) RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);

        recyclerPostagem.setLayoutManager(layoutManager);

        //Definir Adapter
        this.prepararPostagens();
        PostagemAdapter adapter = new PostagemAdapter(postagens);
        recyclerPostagem.setAdapter(adapter);
    }

    public void prepararPostagens(){

        Postagem p = new Postagem("Jonas Amargo", "Fugindo para Blangadesh",R.drawable.imagem1);
        this.postagens.add(p);

        p = new Postagem("Rodrigo Maia", "Crise em SC",R.drawable.vr);
        this.postagens.add(p);

        p = new Postagem("Eduardo Bolsonaro", "#MELHORDIA",R.drawable.imagem2);
        this.postagens.add(p);

        p = new Postagem("Capity Arago", "Sonho",R.drawable.imagem3);
        this.postagens.add(p);

        p = new Postagem("Calaida", "O último momento com ela",R.drawable.imagem4);
        this.postagens.add(p);

    }

}
