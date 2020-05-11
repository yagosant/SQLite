package com.yago.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class CodAntigo {

   /* private void codigoSQLantigo() {
        try {
            criando o BD
            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase("banco", MODE_PRIVATE, null);

            //criando a tabela
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cadastro(nome VARCHAR,idade INT(3))");

            //adicionando os valores
            sqLiteDatabase.execSQL("INSERT INTO cadastro (nome, idade) values ('Yago Santos', 26)");
            sqLiteDatabase.execSQL("INSERT INTO cadastro (nome, idade) values ('Marcia Santos', 48)");
            sqLiteDatabase.execSQL("INSERT INTO cadastro (nome, idade) values ('Ygor Santos', 26)");
            sqLiteDatabase.execSQL("INSERT INTO cadastro (nome, idade) values ('Bruno Santos', 24)");
            sqLiteDatabase.execSQL("INSERT INTO cadastro (nome, idade) values ('Altair Santos', 52)");

            //objeto que vai acessar o BD
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT nome, idade FROM cadastro", null);

            //exibe o que o cursor pegou
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            //vai para a primeira linha
            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("resul BD", "" + cursor.getString(indiceNome));
                Log.i("resul BD", "" + cursor.getString(indiceIdade));
                //exibe os proximos
                cursor.moveToNext();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */


}
