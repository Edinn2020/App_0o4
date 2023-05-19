package com.maki.app_0o4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editextName;
    private EditText editextCode;
    private EditText editextPhone;
    private EditText editextEmail;
    private EditText editextLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editextCode = findViewById(R.id.editTextCodigo);
        editextName = findViewById(R.id.editTextName);
        editextLastName = findViewById(R.id.editTextLastName);
        editextPhone = findViewById(R.id.editTextPhone);
        editextEmail = findViewById(R.id.editTextEmail);

    }

    public void onClicButtonInsert(View view){
        DataBaseAdmin dataBaseAdmin = new DataBaseAdmin(this,"SEXTODB",null,1);
        SQLiteDatabase sql = dataBaseAdmin.getWritableDatabase();

        String name =editextName.getText().toString();
        String lastname =editextLastName.getText().toString();
        String phone =editextPhone.getText().toString();
        String email =editextEmail.getText().toString();

        //sql.execSQL("INSERT INTO Clients (Name, LastNamce, Phone, Email)"+
        //          "VALUES ('David','Pilla','0918829340','davidpl@ti.lan')");

        ContentValues values = new ContentValues();
        values.put("Nombre", name);
        values.put("Apellido", lastname);
        values.put("Telefono", phone);
        values.put("Email", email);

        long count = sql.insert("Clients ",null, values);
        sql.close();

        Toast.makeText(this, "Insertado", Toast.LENGTH_SHORT).show();
        clearTexts();
    }

    private void clearTexts() {
        editextName.setText("");
        editextLastName.setText("");
        editextPhone.setText("");
        editextEmail.setText("");
    }

    public void onClicButtonSearch(View view){
        DataBaseAdmin dataBaseAdmin = new DataBaseAdmin(this,"SEXTODB",null,1);
        SQLiteDatabase sql = dataBaseAdmin.getWritableDatabase();

        String code = editextCode.getText().toString();

        //es mejor porque no utiliza el motor
        final String  SELECT = "SELECT Nombre, Apellido, Telefono, Email " +
                            "FROM Clients " +
                            "WHERE Codigo = " + code;

        Cursor cursor = sql.rawQuery(SELECT, null);
        if(cursor.moveToFirst()){
            editextName.setText(cursor.getString(0));
            editextLastName.setText(cursor.getString(1));
            editextPhone.setText(cursor.getString(2));
            editextEmail.setText(cursor.getString(3));
        }else {
            Toast.makeText(this, "No hay registro que mostrar", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClicButtonDelete(View view){
        DataBaseAdmin dataBaseAdmin = new DataBaseAdmin(this,"SEXTODB",null,1);
        SQLiteDatabase sql = dataBaseAdmin.getWritableDatabase();
    }

    public void onClicButtonUpdate(View view){
        DataBaseAdmin dataBaseAdmin = new DataBaseAdmin(this,"SEXTODB",null,1);
        SQLiteDatabase sql = dataBaseAdmin.getWritableDatabase();
    }





}