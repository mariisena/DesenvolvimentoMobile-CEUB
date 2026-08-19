package com.example.calculadoraimc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView tvImc, tvClassificacaoImc;
    EditText edtPeso, edtAltura;
    Button btnClassificarImc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        try{
            tvImc = (TextView) findViewById(R.id.lblImc);
            tvClassificacaoImc = (TextView) findViewById(R.id.lblClassificacaoImc);
            edtPeso = (EditText) findViewById(R.id.txtPeso);
            edtAltura = (EditText) findViewById(R.id.txtAltura);
            btnClassificarImc = (Button) findViewById(R.id.cmdClassificarIMC);
            btnClassificarImc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double peso, altura, imc;
                    String classificacaoImc;
                    peso = Double.parseDouble(edtPeso.getText().toString());
                    altura = Double.parseDouble(edtAltura.getText().toString());
                    imc = peso/(Math.pow(altura, 2));

                    if (imc < 18.5) {
                        classificacaoImc = "Abaixo do peso normal";
                    } else if ((imc >= 18.5) && (imc <= 24.9)) {
                        classificacaoImc = "Peso normal";
                    } else if ((imc > 25) && (imc <= 29.9)) {
                        classificacaoImc = "Excesso de peso";
                    } else if ((imc > 30) && (imc <= 34.9)) {
                        classificacaoImc = "Obesidade classe I";
                    } else if ((imc > 35) && (imc <= 39.9)) {
                        classificacaoImc = "Obsedidade classe II";
                    } else {
                        classificacaoImc = "Obsedidade classe III";
                    }
                    tvImc.setText(String.format(Locale.getDefault(), "%.2f", imc));
                    tvClassificacaoImc.setText(classificacaoImc);
                }
            });
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}