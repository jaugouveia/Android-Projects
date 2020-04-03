package com.example.recyclerview.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.model.Filme;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listaFilmes;
    public Adapter(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //Cria as Views (Interface)

       View itemLista = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.adapter_lista, parent, false);   //Converte um XML em uma View
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) { //Possibilida a visualização das views

        Filme filme = listaFilmes.get(position);
        holder.titulo.setText(filme.getTitulo());
        holder.ano.setText(filme.getAno());
        holder.genero.setText(filme.getGenero());

    }

    @Override
    public int getItemCount() { //Quantidade de itens a serem exibidos
        return listaFilmes.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{ //Usada apenas para exibir dados dentro de cada elemento de lista

        TextView titulo, ano, genero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }


}
