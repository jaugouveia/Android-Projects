package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {



    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPrecoAlcool = findViewById(R.id.editPreçoAlcool);
        editPrecoGasolina = findViewById(R.id.editPreçoGasolina);
        textResultado = findViewById(R.id.textoResultado);

    }

    public void calcularPreco(View view){
        String precoAlcool      = editPrecoAlcool.getText().toString();
        String precoGasolina    = editPrecoGasolina.getText().toString();
        if (validar(precoAlcool, precoGasolina)){
            double valorAlcool   = Double.parseDouble(precoAlcool);
            double valorGasolina = Double.parseDouble(precoGasolina);
            if ((valorAlcool/valorGasolina)>=0.7){
                textResultado.setText("A melhor opção é usar a Gasolina");
            }
            else{
                textResultado.setText("A melhor opção é usar o Álcool");
            }
        }
        else{
            textResultado.setText("Algum Campo Não Foi Preenchido!");
        }
    }

    public boolean validar(String pAlcool, String pGasolina){
        Boolean validarCampos = true;
        if ((pAlcool == null || pAlcool.equals("")) || (pGasolina == null || pGasolina.equals("") )){
            validarCampos = false;
        }
        return validarCampos;

    }

}
