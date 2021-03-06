package com.example.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.RecyclerItemClickListener;
import com.example.recyclerview.activity.adapter.Adapter;
import com.example.recyclerview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Filme> listaFilmes = new ArrayList<>(); //Cria Array do Tipo Filmes (Objeto)
    private RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = findViewById(R.id.recyclerView);
        //Lista os Filmes
        this.criarFilmes();
        // Configura dados do Adapter
        Adapter adapter = new Adapter(listaFilmes);

        // RecyclerView Configurar
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext()); // Define Layout Manager como LinearLayoutM..
        recyclerview.setLayoutManager(layoutManager); //Define o layout Manager definido acima
        recyclerview.setHasFixedSize(true); //Define o tamanho do recyclerView como fixo
        recyclerview.setAdapter(adapter); //Pega os dados da classe 'adapter' e monta uma visualização (view)
        recyclerview.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        // Evento de Click
        recyclerview.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerview,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Toast.makeText(
                                    getApplicationContext(),
                                    listaFilmes.get(position).getTitulo(),
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Toast.makeText(
                                    getApplicationContext(),
                                    listaFilmes.get(position).getGenero(),
                                    Toast.LENGTH_LONG
                            ).show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }
            )
        );


    }
    public void criarFilmes(){

        Filme filme = new Filme("Aves de Rapina", "Ação/Aventura", "2020");
        this.listaFilmes.add(filme);

        filme = new Filme("Parasita", "Thriller/Comédia", "2019");
        this.listaFilmes.add(filme);

        filme = new Filme("Coringa", "Filme policial/Drama", "2019");
        this.listaFilmes.add(filme);

        filme = new Filme("Corra!", "Terror/Thriller", "2017");
        this.listaFilmes.add(filme);

        filme = new Filme("Infiltrado na Klan", "Biography, Crime, Drama", "2018");
        this.listaFilmes.add(filme);

        filme = new Filme("Pulp Fiction: Tempo de Violência", "Terror/Thriller", "1994");
        this.listaFilmes.add(filme);

        filme = new Filme("O Poderoso Chefão", "Crime/Drama", "1972");
        this.listaFilmes.add(filme);

        filme = new Filme("Batman: O Cavaleiro das Trevas", "Action, Crime, Drama", "2008");
        this.listaFilmes.add(filme);

        filme = new Filme("Interestelar", "Adventure, Drama, Sci-F", "2014");
        this.listaFilmes.add(filme);

        filme = new Filme("O Rei Leão", "Animation, Adventure, Drama", "1994");
        this.listaFilmes.add(filme);

        filme = new Filme("WALL·E", "Animation, Adventure, Family", "2008");
        this.listaFilmes.add(filme);



    }

}
