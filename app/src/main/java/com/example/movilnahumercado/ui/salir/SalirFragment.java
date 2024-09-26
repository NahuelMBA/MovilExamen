package com.example.movilnahumercado.ui.salir;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.movilnahumercado.R;

public class SalirFragment extends Fragment {

    private Button btnSalir;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_salir, container, false);

        btnSalir = root.findViewById(R.id.btnSalir);

        btnSalir.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Salir");
            builder.setMessage("¿Estás realmente seguro de que deseas salir?");
            builder.setPositiveButton("Sí", (dialog, which) -> getActivity().finish());
            builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());
            builder.show();
        });

        return root;
    }
}
