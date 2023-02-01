package com.example.mibasededatos.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.mibasededatos.entidades.CorreoDto;
import com.example.mibasededatos.openHelperDb.DbHelper;
import com.example.mibasededatos.querys.DbQuerysCorreo;

public class DaoCorreoImp extends DbHelper implements IDaoCorreo {
    private Context context;
    public DaoCorreoImp(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public long registrarNuevoCorreo(CorreoDto correoDto) {
        long id = 0;
        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("correo_cliente", correoDto.getCorreo());
            values.put("id_cliente",correoDto.getIdCLiente());
            id = db.insert(DbQuerysCorreo.TABLE_CORREOS_NAME,null,values);

        }catch (Exception ex){
            Toast.makeText(context.getApplicationContext(), ex.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return id;
    }
}
