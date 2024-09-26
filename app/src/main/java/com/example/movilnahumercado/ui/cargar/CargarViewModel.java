package com.example.movilnahumercado.ui.cargar;

import androidx.lifecycle.ViewModel;
import com.example.movilnahumercado.MainActivity;
import com.example.movilnahumercado.model.Inmueble;

public class CargarViewModel extends ViewModel {

    public boolean agregarInmueble(Inmueble inmueble) {
        for (Inmueble i : MainActivity.listaInmuebles) {
            if (i.getCodigo().equals(inmueble.getCodigo())) {
                return false;
            }
        }
        MainActivity.listaInmuebles.add(inmueble);
        return true;
    }
}
