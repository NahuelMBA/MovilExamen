package com.example.movilnahumercado.ui.eliminar;

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
import com.example.movilnahumercado.R;
import com.example.movilnahumercado.model.Inmueble;

public class EliminarFragment extends Fragment {

    private EliminarViewModel eliminarViewModel;
    private EditText etCodigoEliminar, etDescripcionEliminar, etCantidadAmbientesEliminar, etDireccionEliminar, etPrecioEliminar;
    private Button btnBuscar, btnEliminar;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_eliminar, container, false);
        eliminarViewModel = new ViewModelProvider(this).get(EliminarViewModel.class);

        etCodigoEliminar = root.findViewById(R.id.etCodigoEliminar);
        etDescripcionEliminar = root.findViewById(R.id.etDescripcionEliminar);
        etCantidadAmbientesEliminar = root.findViewById(R.id.etCantidadAmbientesEliminar);
        etDireccionEliminar = root.findViewById(R.id.etDireccionEliminar);
        etPrecioEliminar = root.findViewById(R.id.etPrecioEliminar);
        btnBuscar = root.findViewById(R.id.btnBuscar);
        btnEliminar = root.findViewById(R.id.btnEliminar);

        btnBuscar.setOnClickListener(v -> {
            String codigo = etCodigoEliminar.getText().toString();
            if (TextUtils.isEmpty(codigo)) {
                Toast.makeText(getContext(), "Ingrese un código", Toast.LENGTH_SHORT).show();
                return;
            }

            Inmueble inmueble = eliminarViewModel.buscarInmueble(codigo);
            if (inmueble != null) {
                mostrarDatosInmueble(inmueble);
                btnEliminar.setEnabled(true);
            } else {
                Toast.makeText(getContext(), "Inmueble no encontrado", Toast.LENGTH_SHORT).show();
                limpiarCampos();
                btnEliminar.setEnabled(false);
            }
        });

        btnEliminar.setOnClickListener(v -> {
            String codigo = etCodigoEliminar.getText().toString();
            if (eliminarViewModel.eliminarInmueble(codigo)) {
                Toast.makeText(getContext(), "Inmueble eliminado", Toast.LENGTH_SHORT).show();
                limpiarCampos();
                btnEliminar.setEnabled(false);
            } else {
                Toast.makeText(getContext(), "Error al eliminar inmueble", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    private void mostrarDatosInmueble(Inmueble inmueble) {
        etDescripcionEliminar.setText(inmueble.getDescripcion());
        etCantidadAmbientesEliminar.setText(String.valueOf(inmueble.getCantidadAmbientes()));
        etDireccionEliminar.setText(inmueble.getDireccion());
        etPrecioEliminar.setText(String.valueOf(inmueble.getPrecio()));
    }

    private void limpiarCampos() {
        etCodigoEliminar.setText("");
        etDescripcionEliminar.setText("");
        etCantidadAmbientesEliminar.setText("");
        etDireccionEliminar.setText("");
        etPrecioEliminar.setText("");
    }
}
