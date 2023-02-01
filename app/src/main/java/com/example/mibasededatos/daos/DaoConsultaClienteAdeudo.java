package com.example.mibasededatos.daos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.mibasededatos.entidades.ConsultaClienteAdeudoDto;
import com.example.mibasededatos.openHelperDb.DbHelper;
import com.example.mibasededatos.querys.DbQueryAdeudoClientes;

import java.util.ArrayList;

public class DaoConsultaClienteAdeudo extends DbHelper implements IDaoConsultaClienteAdeudo {
    private Context context;
    public DaoConsultaClienteAdeudo(@Nullable Context context) {
        super(context);
        this.context = context;
    }


    @Override
    public ArrayList<ConsultaClienteAdeudoDto> consultarAdeudosClientes() {
        ArrayList<ConsultaClienteAdeudoDto> consultaClienteAdeudoDtos = new ArrayList<>();
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            ConsultaClienteAdeudoDto consultaClienteAdeudoDto;
            Cursor cursor;
            cursor = db.rawQuery(DbQueryAdeudoClientes.CONSULTA_ADEUDO_CLIENTES, null);
            while (cursor.moveToNext()) {
                consultaClienteAdeudoDto = new ConsultaClienteAdeudoDto(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4),
                        cursor.getString(5));
                consultaClienteAdeudoDtos.add(consultaClienteAdeudoDto);
            }
        }catch(Exception ex) {
                Toast.makeText(context.getApplicationContext(),ex.getMessage(),Toast.LENGTH_SHORT).show();
        }
            return consultaClienteAdeudoDtos;
        }
    }