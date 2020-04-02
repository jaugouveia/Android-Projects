package com.example.gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextView textGorjeta, textTotal, textPorcentagem;
    private TextInputEditText editValor;
    private SeekBar seekBar;
    private double porcentagem = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textGorjeta         = findViewById(R.id.textGorjeta);
        textTotal           = findViewById(R.id.textTotal);
        textPorcentagem     = findViewById(R.id.textPorcentagem);
        editValor           = findViewById(R.id.editValor);
        seekBar             = findViewById(R.id.seekBar);



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {  // Cria um listener para a seekBar
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textPorcentagem.setText(porcentagem+"%");
                calculo();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calculo(){
        String total = editValor.getText().toString();
        if (total.equals("") || total == null){
            Toast.makeText(getApplicationContext(),
                    "Digite um Valor",
                    Toast.LENGTH_SHORT).show();
        }

        else {
            double valor = Double.parseDouble(total);

            double gorjeta = valor * (porcentagem/100);
            textGorjeta.setText("R$" + gorjeta);
            textTotal.setText("R$" + (gorjeta+valor));
        }
    }



}
