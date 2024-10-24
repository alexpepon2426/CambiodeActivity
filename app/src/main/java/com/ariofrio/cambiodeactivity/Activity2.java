package com.ariofrio.cambiodeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {
    Button volver;
    TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);
        texto=findViewById(R.id.tv1);
        volver=findViewById(R.id.btn2);

        Intent intent = getIntent();

        String mensajito=intent.getStringExtra(MainActivity.mensa);
        texto.setText(mensajito);

        //logica de boton
        volver.setOnClickListener(v ->{volver();});


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    protected void volver(){
        Intent intendos = new Intent(this, MainActivity.class);
        startActivity(intendos);
    }
}