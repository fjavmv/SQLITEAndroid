package com.example.mibasededatos.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.mibasededatos.entidades.ClienteDto;
import com.example.mibasededatos.openHelperDb.DbHelper;
import com.example.mibasededatos.querys.DbQuerysCliente;

import java.util.ArrayList;

public class DaoClienteImp extends DbHelper implements IDaoCliente {
    private Context context;

    public DaoClienteImp(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public long registrarNuevoCLiente(ClienteDto cliente) {
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nombre_cliente", cliente.getNombre());
            values.put("apellido_paterno", cliente.getApellidoPaterno());
            values.put("apellido_materno", cliente.getApellidoMaterno());
            id = db.insert(DbQuerysCliente.TABLE_CLIENTES_NAME, null, values);
        } catch (Exception ex) {
            Toast.makeText(context.getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return id;
    }

    @Override
    public ArrayList<ClienteDto> consultarCLientes() {
        ArrayList<ClienteDto> listaClienteDtos = new ArrayList<>();
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ClienteDto clienteDto;
        Cursor cursorClientes;
        cursorClientes = db.rawQuery(DbQuerysCliente.CONSULTAR_CLIENTES, null);
        // if (cursorClientes.moveToFirst()){}
        while (cursorClientes.moveToNext()) {
            clienteDto = new ClienteDto(
                    cursorClientes.getInt(0),
                    cursorClientes.getString(1),
                    cursorClientes.getString(2),
                    cursorClientes.getString(3));
            listaClienteDtos.add(clienteDto);
        }
        return listaClienteDtos;
    }

}