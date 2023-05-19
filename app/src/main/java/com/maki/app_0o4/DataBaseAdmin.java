package com.maki.app_0o4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseAdmin  extends SQLiteOpenHelper{
    private static final  String  TABLE_CLIENTES = " CREATE TABLE Clients (Codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Nombre TEXT, Apellido TEXT, Telefono TEXT, Email TEXT)";

    private static final  String DROP_TABLE = "DROP TABLE IF EXISTS Clients";
    public DataBaseAdmin(@Nullable Context context,
                         @Nullable String name,
                         @Nullable SQLiteDatabase.CursorFactory factory,
                         int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    //CREACIOM DE LAS ESTRUCTURAS DE LAS TABLAS
        db.execSQL(TABLE_CLIENTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    // los comandos requeridos cuando hay cambios en las estructuras
        //de las tablas
        sqLiteDatabase.execSQL(DROP_TABLE);
        sqLiteDatabase.execSQL(TABLE_CLIENTES);

    }
}
