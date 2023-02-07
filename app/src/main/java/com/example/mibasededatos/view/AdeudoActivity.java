package com.example.mibasededatos.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mibasededatos.R;
import com.example.mibasededatos.adapter.AdapterClientesRecycler;
import com.example.mibasededatos.daos.DaoAdeudoImp;
import com.example.mibasededatos.daos.DaoClienteImp;
import com.example.mibasededatos.daos.DaoConsultaClienteAdeudo;
import com.example.mibasededatos.daos.IDaoAdeudo;
import com.example.mibasededatos.daos.IDaoCliente;
import com.example.mibasededatos.daos.IDaoConsultaClienteAdeudo;
import com.example.mibasededatos.entidades.AdeudoDto;
import com.example.mibasededatos.entidades.ClienteDto;
import com.example.mibasededatos.view.dialog.DatePickerFragment;

import java.util.ArrayList;
import java.util.Calendar;


public class AdeudoActivity extends AppCompatActivity implements IAdeudoActivityVIew{
        //implements DatePickerDialog.OnDateSetListener, IAdeudoActivityVIew {

    //private Spinner spinnerCLiente;
   // private Spinner spinnerTipoAdeudo;
    private EditText editTextTipoDeAdeudo;
    private EditText editTextNombreCLiente;
    private Spinner spinnerEstadoDePago;
    private EditText editTextMontoDeAdeudo;
    private EditText editTextFecha;
    private EditText editTextDescripcion;
    private Button buttonGuardar;
    private RecyclerView recyclerViewCLientes;
    private ArrayList<ClienteDto> listaCLiente;
  //  private ArrayAdapter<ClienteDto> adapterClientes;
    private ArrayAdapter<String> adapterEstadoPago;
    //private ArrayAdapter<String> adapterTipo;
     private String [] estadoPago;
    //private String [] tipoAdeudo;
   //private final String [] tipoAdeudo = new String[] {"Comida", "Renta"};
   // private final String [] estadoAdeudo = {"Pediente de pago", "Pagado"};
    private long id;
    private String estadoAdeudo;
    private String fechaActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adeudo);
        inicializarControles();
        lanzarDatePicker();
        //adapterCLientesDb();
       // adapterTipoAdeudo();
        construirRecyclerElementos();
        adapterEstadoAdeudo();
        getEstadoAdeudo();
        clickGUardar();
        //getClientesId();

    }

    private void inicializarControles(){
      //  spinnerCLiente = findViewById(R.id.spinner_nombre_clientes);
      //  spinnerTipoAdeudo = findViewById(R.id.spinner_tipo_adeudo);
        editTextMontoDeAdeudo = findViewById(R.id.edt_monto_adeudo);
        editTextNombreCLiente = findViewById(R.id.edt_nombre_cliente_adeudo);
        editTextTipoDeAdeudo = findViewById(R.id.edt_tipo_adeudo);
        recyclerViewCLientes = findViewById(R.id.recyclerNombresCLientes);
        spinnerEstadoDePago = findViewById(R.id.spinner_estado_adeudo);
        editTextFecha = findViewById(R.id.edt_fecha_adeudo);
        editTextDescripcion = findViewById(R.id.edt_descripcion);
        buttonGuardar = findViewById(R.id.btn_guardarAdeudo);
    }

    public void lanzarDatePicker(){
        editTextFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mostrarCalendario();
                showDatePickerDialog();

            }
        });
    }

   /* private void adapterCLientesDb(){
        listaCLiente = consultarCLientes();
        adapterClientes = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, listaCLiente);
        adapterClientes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCLiente.setAdapter(adapterClientes);
    }
    private void adapterTipoAdeudo(){
      //  tipoAdeudo = getResources().getStringArray(R.array.tipo_de_adeudo);
        adapterTipo = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,tipoAdeudo);
        adapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoAdeudo.setAdapter(adapterTipo);
    }*/


    private void adapterEstadoAdeudo(){
        estadoPago = getResources().getStringArray(R.array.estado);
        adapterEstadoPago = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,estadoPago);
        adapterEstadoPago.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEstadoDePago.setAdapter(adapterEstadoPago);
    }

    private void getEstadoAdeudo(){
        spinnerEstadoDePago.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                estadoAdeudo = spinnerEstadoDePago.getSelectedItem().toString();
                mostrarToast(estadoAdeudo);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

  /*  private void getClientesId(){
        spinnerCLiente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                id = listaCLiente.get(position).getIdCliente() ;

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }*/

    private void clickGUardar() {

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fechaActual = twoDigits(DatePickerFragment.day) + "-" + twoDigits(DatePickerFragment.month + 1) + "-" + DatePickerFragment.year;
                AdeudoDto adeudoDto = new AdeudoDto(id, editTextTipoDeAdeudo.getText().toString(),
                        Double.parseDouble(editTextMontoDeAdeudo.getText().toString()), editTextFecha.getText().toString(),
                        estadoAdeudo, editTextDescripcion.getText().toString(),fechaActual);
               // mostrarToast(adeudoDto.toString());
                long idAdeudo = registrarNuevoAdeudo(adeudoDto);
                if (idAdeudo > 0) {
                    mostrarToast("El registro ha sido correcto.");
                } else {
                    mostrarToast("Ha ocurrido algun error, verifique no insertar datos repetidos.");
                }
            }
        });
        limpiarCampos();
    }

  /*  private void mostrarCalendario(){
        DatePickerDialog  datePickerDialog = new DatePickerDialog(this,R.style.DatePickerStyle, this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        String date = dayOfMonth +"-"+ month + 1 + "-" + year;
        editTextFecha.setText(date);
    }*/

    private String twoDigits(int n) {
        return (n<=9) ? ("0"+n) : String.valueOf(n);
    }

    private void showDatePickerDialog(){
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                final  String diaSeleccionado = twoDigits(dayOfMonth) + "-" + twoDigits(month + 1) + "-" + year;
                editTextFecha.setText(diaSeleccionado);
            }
        });
        newFragment.show(this.getSupportFragmentManager(),"datePicker");
    }



    @Override
    public long registrarNuevoAdeudo(AdeudoDto adeudoDto) {
        IDaoAdeudo iDaoAdeudo = new DaoAdeudoImp(AdeudoActivity.this);
        return iDaoAdeudo.registrarNuevoAdeudo(adeudoDto);
    }

    @Override
    public ArrayList<ClienteDto> consultarCLientes() {
        ArrayList<ClienteDto> listClientes;
        IDaoCliente iDaoCliente = new DaoClienteImp(AdeudoActivity.this);
        listClientes = iDaoCliente.consultarCLientes();
        return listClientes;
    }

    @Override
    public void construirRecyclerElementos() {
        listaCLiente = new ArrayList<>();
        listaCLiente = consultarCLientes();
        recyclerViewCLientes.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        AdapterClientesRecycler adapterDatos = new AdapterClientesRecycler(listaCLiente);

        adapterDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = listaCLiente.get(recyclerViewCLientes.getChildAdapterPosition(view)).getIdCliente() ;
                editTextNombreCLiente.setText(listaCLiente.get((int)id-1).toString());
                mostrarToast("id:"+ id);
            }
        });
        recyclerViewCLientes.setAdapter(adapterDatos);
    }


    private void limpiarCampos(){
        editTextNombreCLiente.setText("");
        editTextMontoDeAdeudo.setText("");
        editTextFecha.setText("");
        editTextDescripcion.setText("");
    }
    private void mostrarToast(String mensaje){
        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
    }

}