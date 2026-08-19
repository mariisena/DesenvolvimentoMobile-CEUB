package com.example.faixaetaria;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView tvFaixaEtaria;
    Button btnClassificarFaixaEtaria;
    EditText edtIdade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvFaixaEtaria = (TextView) findViewById(R.id.lblFaixaEtaria);
        edtIdade = (EditText) findViewById(R.id.txtIdade);
        btnClassificarFaixaEtaria = (Button) findViewById(R.id.cmdClassificarFaixaEtaria);
        btnClassificarFaixaEtaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer idade = Integer.parseInt(edtIdade.getText().toString());
                if((idade > 0)&&(idade <= 12 )) {
                    tvFaixaEtaria.setText("Classificação: Criança");
                } else if ((idade > 12)&&(idade <= 17)) {
                    tvFaixaEtaria.setText("Classificação: Adolescente");
                } else {
                    tvFaixaEtaria.setText("Classificação: Adulto");
                }

            }
        });
    }
}