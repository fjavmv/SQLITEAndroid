package com.example.mibasededatos.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.mibasededatos.entidades.TelefonoDto;
import com.example.mibasededatos.openHelperDb.DbHelper;
import com.example.mibasededatos.querys.DbQuerysTelefono;

public class DaoTelefonoImp extends DbHelper implements IDaoTelefono {
    private Context context;

    public DaoTelefonoImp(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public long registrarNuevoTelefono(TelefonoDto telefonoDto) {
        long id = 0;
        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("numero_telefono", telefonoDto.getTelefono());
            values.put("id_cliente", telefonoDto.getIdCliente());
            id = db.insert(DbQuerysTelefono.TABLE_TELEFONO_NAME,null,values);
        }catch (Exception ex){
            Toast.makeText(context.getApplicationContext(),ex.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return id;
    }
}
