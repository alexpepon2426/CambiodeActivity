package com.ariofrio.cambiodeactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btEnviar;
    EditText txtNombre;
    static String mensa = ".";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btEnviar=findViewById(R.id.btn);
        txtNombre=findViewById(R.id.e1);

        //Lógica del botón
        btEnviar.setOnClickListener(v->enviarMsg());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void enviarMsg(){
        Intent intent = new Intent(this, Activity2.class);
        String nombrecito = txtNombre.getText().toString();
        intent.putExtra(mensa,"Hola "+nombrecito+" ,Muerete");
        startActivity(intent);

    }
}