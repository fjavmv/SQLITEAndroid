package com.example.mibasededatos.openHelperDb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mibasededatos.querys.DbQuerysAdeudo;
import com.example.mibasededatos.querys.DbQuerysCliente;
import com.example.mibasededatos.querys.DbQuerysCorreo;
import com.example.mibasededatos.querys.DbQuerysTelefono;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context,DbQuerysCliente.DATABASE_NAME, null, DbQuerysCliente.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DbQuerysCliente.TABLE_CLIENTES);
        sqLiteDatabase.execSQL(DbQuerysCorreo.TABLE_CORREOS_CLIENTES);
        sqLiteDatabase.execSQL(DbQuerysTelefono.TABLE_NUMEROS_TELEFONO_CLIENTES);
        sqLiteDatabase.execSQL(DbQuerysAdeudo.TABLE_ADEUDOS_CLIENTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DbQuerysCliente.ELIMINAR_TABLA_CLIENTES);
        sqLiteDatabase.execSQL(DbQuerysCorreo.ELIMINAR_TABLA_CORREOS);
        sqLiteDatabase.execSQL(DbQuerysTelefono.ELIMINAR_TABLA_TELEFONOS);
        sqLiteDatabase.execSQL(DbQuerysAdeudo.ELIMINAR_TABLA_ADEUDOS);
    }
}
