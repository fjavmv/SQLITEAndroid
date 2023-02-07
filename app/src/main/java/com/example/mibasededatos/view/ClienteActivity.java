package com.example.mibasededatos.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.mibasededatos.R;
import com.example.mibasededatos.daos.DaoClienteImp;
import com.example.mibasededatos.daos.DaoCorreoImp;
import com.example.mibasededatos.daos.DaoTelefonoImp;
import com.example.mibasededatos.daos.IDaoCliente;
import com.example.mibasededatos.daos.IDaoCorreo;
import com.example.mibasededatos.daos.IDaoTelefono;
import com.example.mibasededatos.entidades.ClienteDto;
import com.example.mibasededatos.entidades.CorreoDto;
import com.example.mibasededatos.entidades.TelefonoDto;

public class ClienteActivity extends AppCompatActivity implements IClienteActivityView {

    private EditText nombre;
    private EditText apellidoP;
    private EditText apellidoM;
    private EditText numeroTel;
    private EditText email;
    private Button buttonGuardar;
    private Button buttonCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        inicializarControles();
        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClienteDto cliente = new ClienteDto(nombre.getText().toString(),apellidoP.getText().toString(),apellidoM.getText().toString());
                long id = registrarNuevoCLiente(cliente);
                cliente.setIdCliente(id);
                TelefonoDto telefonoDto = new TelefonoDto(numeroTel.getText().toString(),cliente.getIdCliente());
                long id_tel = registrarNuevoTelefono(telefonoDto);
                CorreoDto correoDto = new CorreoDto(email.getText().toString(),cliente.getIdCliente());
                long id_email = registrarNuevoCorreo(correoDto);
                if(id > 0 && id_tel > 0 && id_email > 0 ){
                    mostrarToast("Registro almacenado de manera correcta");
                }else {
                    mostrarToast("Error al guardar los registros");
                }
                limpiarCampos();
            }
        });
    }

    private void inicializarControles(){
        nombre = findViewById(R.id.edt_nombre_cliente);
        apellidoP = findViewById(R.id.edt_apellido_paterno_cliente);
        apellidoM = findViewById(R.id.edt_apellido_materno_cliente);
        buttonGuardar = findViewById(R.id.btn_guardar);
        email = findViewById(R.id.edt_correo_cliente);
        numeroTel = findViewById(R.id.edt_numero_telefono_cliente);
    }

    @Override
    public long registrarNuevoCLiente(ClienteDto cliente) {
        IDaoCliente iDaoCliente = new DaoClienteImp(ClienteActivity.this);
        return iDaoCliente.registrarNuevoCLiente(cliente);
    }

    @Override
    public long registrarNuevoCorreo(CorreoDto correoDto) {
        IDaoCorreo iDaoCorreo = new DaoCorreoImp(ClienteActivity.this);
        return iDaoCorreo.registrarNuevoCorreo(correoDto);
    }

    @Override
    public long registrarNuevoTelefono(TelefonoDto telefonoDto) {
        IDaoTelefono iDaoTelefono = new DaoTelefonoImp(ClienteActivity.this);
        return iDaoTelefono.registrarNuevoTelefono(telefonoDto);
    }

    private void limpiarCampos(){
        nombre.setText("");
        apellidoP.setText("");
        apellidoM.setText("");
        numeroTel.setText("");
        email.setText("");
    }

    private void mostrarToast(String mensaje){
        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
    }
}