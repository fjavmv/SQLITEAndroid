package com.example.mibasededatos.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mibasededatos.R;
import com.example.mibasededatos.entidades.ClienteDto;

import java.util.ArrayList;

public class AdapterClientesRecycler extends RecyclerView.Adapter<AdapterClientesRecycler.ViewHolderDatosClientes> implements View.OnClickListener {
    private ArrayList<ClienteDto> listaCLientes;
    private View.OnClickListener listener;
    public AdapterClientesRecycler(ArrayList<ClienteDto> listaCLientes){
        this.listaCLientes = listaCLientes;
    }

    @NonNull
    @Override
    public AdapterClientesRecycler.ViewHolderDatosClientes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item,null,false);
        view.setOnClickListener(this);
        return new ViewHolderDatosClientes(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClientesRecycler.ViewHolderDatosClientes holder, int position) {
        //Establece la comunicación entre el adaptador y ViewHolderDatos
        holder.asignarDatos(listaCLientes.get(position));
    }

    @Override
    public int getItemCount() {
        return listaCLientes.size();
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderDatosClientes extends RecyclerView.ViewHolder {
        private TextView dataCLientes;
        public ViewHolderDatosClientes(@NonNull View itemView) {
            super(itemView);
            dataCLientes = itemView.findViewById(R.id.txtNombres);
        }
        public void asignarDatos(ClienteDto datos){
            dataCLientes.setText(datos.toString());
        }
    }
}
