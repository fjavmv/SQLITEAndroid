package com.example.mibasededatos.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.mibasededatos.entidades.AdeudoDto;
import com.example.mibasededatos.entidades.ConsultaClienteAdeudoDto;
import com.example.mibasededatos.openHelperDb.DbHelper;
import com.example.mibasededatos.querys.DbQueryAdeudoClientes;
import com.example.mibasededatos.querys.DbQuerysAdeudo;

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
                        cursor.getLong(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getInt(5),
                        cursor.getString(6));
                consultaClienteAdeudoDtos.add(consultaClienteAdeudoDto);
            }
            cursor.close();
        }catch(Exception ex) {
                Toast.makeText(context.getApplicationContext(),ex.getMessage(),Toast.LENGTH_SHORT).show();
        }
            return consultaClienteAdeudoDtos;
        }

    @Override
    public int actualizarEstadoDeAdeudo(ConsultaClienteAdeudoDto consultaClienteAdeudoDto) {
        int fila = 0;
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db =  dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        String selection = "id_adeudo = ?";
        String[] selectionArgs = {String.valueOf(consultaClienteAdeudoDto.getIdAdeudo())};
        try{
            values.put("estado_adeudo",consultaClienteAdeudoDto.getEstadoAdeudo());
            values.put("update_at",consultaClienteAdeudoDto.getUpdateAt());
            db.update(DbQuerysAdeudo.TABLE_NAME_ADEUDOS,values,selection,selectionArgs);

        }catch (Exception ex){
            Toast.makeText(context.getApplicationContext(),ex.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return fila;

    }
}