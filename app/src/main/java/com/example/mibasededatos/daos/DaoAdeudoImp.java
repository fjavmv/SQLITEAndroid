package com.example.mibasededatos.daos;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.mibasededatos.entidades.AdeudoDto;
import com.example.mibasededatos.openHelperDb.DbHelper;
import com.example.mibasededatos.querys.DbQuerysAdeudo;

public class DaoAdeudoImp extends DbHelper implements IDaoAdeudo {
    Context context;
    public DaoAdeudoImp(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public long registrarNuevoAdeudo(AdeudoDto adeudoDto) {
        long id = 0;
        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db =  dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("id_cliente",adeudoDto.getIdCLiente());
            values.put("tipo_adeudo",adeudoDto.getTipoAdeudo());
            values.put("monto_adeudo",adeudoDto.getMontoAdeudo());
            values.put("fecha_adeudo",adeudoDto.getFechaAdeudo());
            values.put("estado_adeudo",adeudoDto.getEstadoAdeudo());
            values.put("descripcion",adeudoDto.getDescripcion());
            values.put("update_at",adeudoDto.getUpdateAt());
            id = db.insert(DbQuerysAdeudo.TABLE_NAME_ADEUDOS,null,values);
        }catch (Exception ex){
            Toast.makeText(context.getApplicationContext(),ex.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return id;
    }
}
