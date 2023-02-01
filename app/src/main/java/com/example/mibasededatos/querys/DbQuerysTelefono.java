package com.example.mibasededatos.querys;

public class DbQuerysTelefono {
    public static final String TABLE_NUMEROS_TELEFONO_CLIENTES = "CREATE TABLE \"numeros_de_telefono_clientes\" (\n" +
            "\t\"id_numero\"\tINTEGER NOT NULL UNIQUE,\n" +
            "\t\"numero_telefono\"\tTEXT UNIQUE,\n" +
            "\t\"id_cliente\"\tINTEGER NOT NULL,\n" +
            "\tFOREIGN KEY(\"id_cliente\") REFERENCES \"clientes\"(\"id_cliente\"),\n" +
            "\tCONSTRAINT \"pk_id_numero\" PRIMARY KEY(\"id_numero\" AUTOINCREMENT)\n" +
            ");";
    public static String ELIMINAR_TABLA_TELEFONOS = "DROP TABLE numeros_de_telefono_clientes;";
    public static String TABLE_TELEFONO_NAME = "numeros_de_telefono_clientes";


}
