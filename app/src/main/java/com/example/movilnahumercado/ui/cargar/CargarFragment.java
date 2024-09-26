package com.example.movilnahumercado.ui.cargar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.movilnahumercado.MainActivity;
import com.example.movilnahumercado.R;
import com.example.movilnahumercado.model.Inmueble;

public class CargarFragment extends Fragment {

    private CargarViewModel cargarViewModel;
    private EditText etCodigo, etDescripcion, etCantidadAmbientes, etDireccion, etPrecio;
    private Button btnCargar;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cargar, container, false);
        cargarViewModel = new ViewModelProvider(this).get(CargarViewModel.class);

        etCodigo = root.findViewById(R.id.etCodigo);
        etDescripcion = root.findViewById(R.id.etDescripcion);
        etCantidadAmbientes = root.findViewById(R.id.etCantidadAmbientes);
        etDireccion = root.findViewById(R.id.etDireccion);
        etPrecio = root.findViewById(R.id.etPrecio);
        btnCargar = root.findViewById(R.id.btnCargar);

        btnCargar.setOnClickListener(v -> {
            if (validarCampos()) {
                Inmueble inmueble = new Inmueble(
                        etCodigo.getText().toString(),
                        etDescripcion.getText().toString(),
                        Integer.parseInt(etCantidadAmbientes.getText().toString()),
                        etDireccion.getText().toString(),
                        Double.parseDouble(etPrecio.getText().toString())
                );

                if (cargarViewModel.agregarInmueble(inmueble)) {
                    Toast.makeText(getContext(), "Inmueble agregado", Toast.LENGTH_SHORT).show();
                    limpiarCampos();
                } else {
                    Toast.makeText(getContext(), "El inmueble ya existe", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }

    private boolean validarCampos() {
        if (TextUtils.isEmpty(etCodigo.getText())) {
            etCodigo.setError("Ingrese el código");
            return false;
        }
        if (TextUtils.isEmpty(etDescripcion.getText())) {
            etDescripcion.setError("Ingrese la descripción");
            return false;
        }
        if (TextUtils.isEmpty(etCantidadAmbientes.getText())) {
            etCantidadAmbientes.setError("Ingrese la cantidad de ambientes");
            return false;
        }
        if (TextUtils.isEmpty(etDireccion.getText())) {
            etDireccion.setError("Ingrese la dirección");
            return false;
        }
        if (TextUtils.isEmpty(etPrecio.getText())) {
            etPrecio.setError("Ingrese el precio");
            return false;
        }
        return true;
    }

    private void limpiarCampos() {
        etCodigo.setText("");
        etDescripcion.setText("");
        etCantidadAmbientes.setText("");
        etDireccion.setText("");
        etPrecio.setText("");
    }
}
