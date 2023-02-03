package com.example.mibasededatos.touchHelper;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mibasededatos.adapter.AdapterConsultaClienteAdeudo;
import com.example.mibasededatos.entidades.ConsultaClienteAdeudoDto;

import java.util.ArrayList;

public class RecyclerTouchHelper extends ItemTouchHelper.SimpleCallback {
    private ArrayList<ConsultaClienteAdeudoDto> lista;
    private AdapterConsultaClienteAdeudo adapterConsultaClienteAdeudo;

    public RecyclerTouchHelper(int dragDirs, int swipeDirs, ArrayList<ConsultaClienteAdeudoDto> lista) {
        super(dragDirs, swipeDirs);
        this.lista = lista;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        lista.remove(viewHolder.getAdapterPosition());
        adapterConsultaClienteAdeudo.notifyItemRemoved(viewHolder.getAdapterPosition());
    }

}
