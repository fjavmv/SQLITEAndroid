package com.example.mibasededatos.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.mibasededatos.R;
import com.example.mibasededatos.adapter.AdapterConsultaClienteAdeudo;
import com.example.mibasededatos.daos.DaoConsultaClienteAdeudo;
import com.example.mibasededatos.daos.IDaoConsultaClienteAdeudo;
import com.example.mibasededatos.entidades.ConsultaClienteAdeudoDto;

import java.util.ArrayList;

public class ConsultarActivity extends AppCompatActivity implements IConsultarActivity {

    private RecyclerView recyclerView;
    private ArrayList<ConsultaClienteAdeudoDto> listaClienteAdeudo;
    private AdapterConsultaClienteAdeudo adapterDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);
        recyclerView = findViewById(R.id.rViewConsulta);
        construirRecyclerElementos();
        deslizar();

    }


    @Override
    public ArrayList<ConsultaClienteAdeudoDto> consultarAdeudosClientes() {
        IDaoConsultaClienteAdeudo iDaoConsultaClienteAdeudo = new DaoConsultaClienteAdeudo(this);
        return iDaoConsultaClienteAdeudo.consultarAdeudosClientes();
    }

    @Override
    public void construirRecyclerElementos() {
        listaClienteAdeudo = new ArrayList<>();
        listaClienteAdeudo = consultarAdeudosClientes();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapterDatos = new AdapterConsultaClienteAdeudo(listaClienteAdeudo);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           //     id = listaCLiente.get(recyclerViewCLientes.getChildAdapterPosition(view)).getIdCliente() ;
             //   editTextNombreCLiente.setText(listaCLiente.get((int)id-1).toString());
               // mostrarToast("id:"+ id);
            }
        });
        recyclerView.setAdapter(adapterDatos);
    }

    public void deslizar(){
        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                listaClienteAdeudo.remove(viewHolder.getAdapterPosition());
                adapterDatos.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

}