package com.yago.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.yago.sqlite.db.TabelaConfig;
import com.yago.sqlite.db.TabelaHelper;

public class MainActivity extends AppCompatActivity {

    //intancia o objeto
    TabelaHelper meuHelper;
    SQLiteDatabase meuBanco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meuHelper = new TabelaHelper(this);
        //abre o banco
        meuBanco = meuHelper.getWritableDatabase();

        adicionaItem();
        lerBanco();
        apagaDado("Yago");
    }

    private void apagaDado(String dado) {
        //""DELETE FROM tabela WHERE titulo = ''"
        String minhaquery = String.format("DELETE FROM %s WHERE %s = '%s'",
                TabelaConfig.TABELA, TabelaConfig.Columns.NOME, dado);
        meuBanco.execSQL(minhaquery);
        lerBanco();
    }

    private void lerBanco() {

        //argunmentos da query
        Cursor cursor = meuBanco.query(TabelaConfig.TABELA,
                new String[]{TabelaConfig.Columns.NOME, TabelaConfig.Columns.IDADE},
                null,null,null,null,null);

        //obter os indices
        int colunaNome = cursor.getColumnIndex(TabelaConfig.Columns.NOME);
        int colunaIdade = cursor.getColumnIndex(TabelaConfig.Columns.IDADE);

        if (cursor != null){
            cursor.moveToFirst();

            //varre o cursor e imprime
            while (!cursor.isAfterLast()){

                //cursor.getString(colunaNome);
                //cursor.getString(colunaIdade);
                Log.i("meuLog", ""+ cursor.getString(colunaNome));
                Log.i("meuLog", ""+ cursor.getString(colunaIdade) + "\n\n");
                cursor.moveToNext();
            }
        }
    }

    private void adicionaItem() {

        ContentValues values = new ContentValues();

        //limpa os valores
        values.clear();
        //inserindo os valores
        values.put(TabelaConfig.Columns.IDADE,"Yago Santos");
        values.put(TabelaConfig.Columns.IDADE,26);
        meuBanco.insertWithOnConflict(TabelaConfig.TABELA, null, values, SQLiteDatabase.CONFLICT_IGNORE);
    }



}


