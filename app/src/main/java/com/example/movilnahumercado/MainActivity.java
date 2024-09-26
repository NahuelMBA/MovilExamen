package com.example.movilnahumercado;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

import com.example.movilnahumercado.model.Inmueble;
import com.example.movilnahumercado.ui.cargar.CargarFragment;
import com.example.movilnahumercado.ui.eliminar.EliminarFragment;
import com.example.movilnahumercado.ui.salir.SalirFragment;

public class MainActivity extends FragmentActivity {

    public static ArrayList<Inmueble> listaInmuebles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCargar = findViewById(R.id.btnCargar);
        Button btnEliminar = findViewById(R.id.btnEliminar);
        Button btnSalir = findViewById(R.id.btnSalir);

        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarFragmento(new CargarFragment());
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarFragmento(new EliminarFragment());
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarFragmento(new SalirFragment());
            }
        });

        cargarFragmento(new CargarFragment());
    }

    public void cargarFragmento(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
