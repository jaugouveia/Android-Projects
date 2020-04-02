package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listlocais;
    private String[] itens = {
            "Porto de Galinhas","Recife","França",
            "Rio de Janeiro", "Boa Viagem",
            "Bonito", "Caribe", "Tokyo", "xangai",
            "Santiago","Zurique", "Buenos Aires",
            "Itamaraca", "Santo André", "Capibaribe",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listlocais = findViewById(R.id.listlocais);

        //Criar adaptador Lista
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1, //Define tipo de layout (Que pode ser personalizavel através de arquivo xml)
                android.R.id.text1,
                itens
        );

        //Adicionar adaptador para a lista
        listlocais.setAdapter(adaptador);
        listlocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });



    }
}
