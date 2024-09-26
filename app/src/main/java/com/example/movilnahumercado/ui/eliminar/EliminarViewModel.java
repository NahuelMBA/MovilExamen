package com.example.movilnahumercado.ui.eliminar;

import androidx.lifecycle.ViewModel;
import com.example.movilnahumercado.MainActivity;
import com.example.movilnahumercado.model.Inmueble;

public class EliminarViewModel extends ViewModel {

    public Inmueble buscarInmueble(String codigo) {
        for (Inmueble i : MainActivity.listaInmuebles) {
            if (i.getCodigo().equals(codigo)) {
                return i;
            }
        }
        return null;
    }

    public boolean eliminarInmueble(String codigo) {
        Inmueble inmueble = buscarInmueble(codigo);
        if (inmueble != null) {
            MainActivity.listaInmuebles.remove(inmueble);
            return true;
        }
        return false;
    }
}
