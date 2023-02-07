package com.example.mibasededatos.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mibasededatos.R;
import com.example.mibasededatos.adapter.AdapterConsultaClienteAdeudo;
import com.example.mibasededatos.daos.DaoConsultaClienteAdeudo;
import com.example.mibasededatos.daos.IDaoConsultaClienteAdeudo;
import com.example.mibasededatos.entidades.AdeudoDto;
import com.example.mibasededatos.entidades.ConsultaClienteAdeudoDto;
import com.example.mibasededatos.view.dialog.DatePickerFragment;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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
    public long actualizarEstadoDeAdeudo(ConsultaClienteAdeudoDto consultaClienteAdeudoDto) {
        long fila= 0;
        IDaoConsultaClienteAdeudo daoConsultaClienteAdeudo = new DaoConsultaClienteAdeudo(ConsultarActivity.this);
        daoConsultaClienteAdeudo.actualizarEstadoDeAdeudo(consultaClienteAdeudoDto);
        return fila;
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
        int size = listaClienteAdeudo.size();
        if (size == 0){
            Toast.makeText(getApplicationContext(),"No hay elementos para mostrar...",Toast.LENGTH_SHORT).show();
        }
        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int pos = viewHolder.getAdapterPosition();
                Toast.makeText(getApplicationContext(),"Position: "+ pos,Toast.LENGTH_SHORT).show();
                if (pos >= 0 && pos <= (size-1))
                {
                    getId(pos);
                    listaClienteAdeudo.remove(viewHolder.getAdapterPosition());
                }
                adapterDatos.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private void getId(int pos){
        Toast.makeText(getApplicationContext(),"Elemento: "+ listaClienteAdeudo.get(pos).getIdAdeudo(),Toast.LENGTH_SHORT).show();
        long response = actualizarEstadoDeAdeudo(setData(listaClienteAdeudo.get(pos).getIdAdeudo()));
        if (response!= 0){
            Toast.makeText(getApplicationContext(),"No se realizo la operación..",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Operación  exitosa",Toast.LENGTH_SHORT).show();
        }
    }

    public ConsultaClienteAdeudoDto setData(long id){
        String estadoDePago = "Pagado";
        String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        return new ConsultaClienteAdeudoDto(id,estadoDePago,date);
    }



}