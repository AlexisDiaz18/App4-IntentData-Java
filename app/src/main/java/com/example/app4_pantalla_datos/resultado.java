package com.example.app4_pantalla_datos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class resultado extends AppCompatActivity {
    private Intent intent = null;
    private TextView txtNombre = null;
    private TextView txtCarrera = null;
    private TextView txtGrupo = null;
    private Button btnRegreso = null;
    String nombre = null;
    String carrera = null;
    String grupo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resultado);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        intent = getIntent();

        nombre = intent.getStringExtra("nombre");
        carrera = intent.getStringExtra("carrera");
        grupo = intent.getStringExtra("grupo");

        Log.d("resultado","Nombre" + nombre + "\r Carrera" + carrera + "\r Grupo" + grupo);

        txtNombre = findViewById(R.id.act2TxtNombre);
        txtCarrera = findViewById(R.id.act2TxtCarrera);
        txtGrupo = findViewById(R.id.act2TxtGrupo);

        txtNombre.setText(nombre);
        txtCarrera.setText(carrera);
        txtGrupo.setText(grupo);

        btnRegreso = findViewById(R.id.act2BtnRegresar);

        btnRegreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre += " Regreso";
                carrera += " Regreso";
                grupo += " Regreso";
                intent = new Intent();
                intent.putExtra("nombre",nombre);
                intent.putExtra("carrera",carrera);
                intent.putExtra("grupo",grupo);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}