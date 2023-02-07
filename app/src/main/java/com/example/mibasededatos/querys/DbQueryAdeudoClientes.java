package com.example.mibasededatos.querys;

import android.database.sqlite.SQLiteDatabase;

public class DbQueryAdeudoClientes {
    public static String CONSULTA_ADEUDO_CLIENTES = "SELECT \n" +
            "\tid_adeudo,\n" +
            "nombre_cliente,\n" +
            "apellido_paterno,\n" +
            "\tapellido_materno,\n" +
            "\ttipo_adeudo,\n" +
            "\tmonto_adeudo,\n" +
            "\tfecha_adeudo\n" +
            "FROM \n" +
            "    clientes\n" +
            "INNER JOIN adeudos_de_clientes USING(id_cliente) WHERE estado_adeudo = 'Pendiente de pago';";

}



