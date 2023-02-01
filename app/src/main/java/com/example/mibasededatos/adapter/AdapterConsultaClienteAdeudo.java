package com.example.mibasededatos.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mibasededatos.R;
import com.example.mibasededatos.entidades.ConsultaClienteAdeudoDto;


import java.util.ArrayList;

public class AdapterConsultaClienteAdeudo extends RecyclerView.Adapter<AdapterConsultaClienteAdeudo.ViewHolderDatosConsulta> {

    ArrayList<ConsultaClienteAdeudoDto> consultaClienteAdeudoDtos;
    public AdapterConsultaClienteAdeudo(ArrayList<ConsultaClienteAdeudoDto> consultaClienteAdeudoDtos){
        this.consultaClienteAdeudoDtos = consultaClienteAdeudoDtos;
    }

    @NonNull
    @Override
    public AdapterConsultaClienteAdeudo.ViewHolderDatosConsulta onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_consulta_adeudos,null,false);
        return  new AdapterConsultaClienteAdeudo.ViewHolderDatosConsulta(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterConsultaClienteAdeudo.ViewHolderDatosConsulta holder, int position) {
        //Establece la comunicación entre el adaptador y ViewHolderDatosHome
        holder.asignarDatos(consultaClienteAdeudoDtos.get(position));
    }

    @Override
    public int getItemCount() {
        return consultaClienteAdeudoDtos.size();
    }

    public class ViewHolderDatosConsulta extends RecyclerView.ViewHolder {
        TextView textViewNombreCLiente;
        TextView textViewTipoAdeudo;
        TextView textVieMonto;
        TextView textVieFechaAdeudo;
        CardView mCardViewListenerConsulta;

        public ViewHolderDatosConsulta(@NonNull View itemView) {
            super(itemView);
            inicializaComponentes(itemView);

            mCardViewListenerConsulta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // Context context = view.getContext();
                   // Intent intent = new Intent(view.getContext(), MainActivity.class);
                   // context.startActivity(intent);
                    Toast.makeText(view.getContext(),"Selecionado",Toast.LENGTH_SHORT).show();
                }
            });

        }

        public void inicializaComponentes(View itemView){
            textViewNombreCLiente = itemView.findViewById(R.id.txtNombreCLiente);
            textViewTipoAdeudo = itemView.findViewById(R.id.txtTipoAdeudo);
            textVieMonto = itemView.findViewById(R.id.txtPrecio);
            textVieFechaAdeudo = itemView.findViewById(R.id.txtFechaAdeudo);
            mCardViewListenerConsulta = itemView.findViewById(R.id.cardViewListenerConsulta);
        }


        public void asignarDatos(ConsultaClienteAdeudoDto consultaClienteAdeudoDto) {
            final String nombreCompleto = consultaClienteAdeudoDto.getNombreCLiente() + " " + consultaClienteAdeudoDto.getApellidoP() + " " + consultaClienteAdeudoDto.getApellidoM();
            final String precio = "$ " + consultaClienteAdeudoDto.getPrecio();
            textViewNombreCLiente.setText(nombreCompleto);
            textViewTipoAdeudo.setText(consultaClienteAdeudoDto.getTipoDeAdeudo());
            textVieMonto.setText(precio);
            textVieFechaAdeudo.setText(consultaClienteAdeudoDto.getFecha());
        }

    }



}
