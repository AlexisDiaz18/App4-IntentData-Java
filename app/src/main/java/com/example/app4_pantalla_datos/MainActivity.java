package com.example.app4_pantalla_datos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private Intent intent = null;
    private EditText txtNombre = null;
    private EditText txtCarrera = null;
    private EditText txtGrupo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtNombre = findViewById(R.id.txtEditNombre);
        txtCarrera = findViewById(R.id.txtEditCarrera);
        txtGrupo = findViewById(R.id.txtEditGrupo);
        Button btnEnviar = findViewById(R.id.btnEnviar);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = txtNombre.getText().toString();
                String carrera = txtCarrera.getText().toString();
                String grupo = txtGrupo.getText().toString();

                intent = new Intent(MainActivity.this, resultado.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("carrera",carrera);
                intent.putExtra("grupo",grupo);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String nombre = data.getStringExtra("nombre");
            String carrera = data.getStringExtra("carrera");
            String grupo = data.getStringExtra("grupo");

            txtNombre.setText(nombre);
            txtCarrera.setText(carrera);
            txtGrupo.setText(grupo);

            Log.d("MainActivity", "Nombre: " + nombre);
            Log.d("MainActivity", "Carrera: " + carrera);
            Log.d("MainActivity", "Grupo: " + grupo);
        }
    }
}