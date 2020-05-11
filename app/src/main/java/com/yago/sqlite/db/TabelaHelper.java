package com.yago.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//devolve o Banco
public class TabelaHelper extends SQLiteOpenHelper {

    public TabelaHelper(@Nullable Context context) {
        super(context, TabelaConfig.NOME, null, TabelaConfig.VERSAO);
    }

    //cria a tabela
    @Override
    public void onCreate(SQLiteDatabase db) {

        //sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cadastro(nome VARCHAR,idade INT(3))");

        String minhaQuery = String.format("CREATE TABLE IF NOT EXISTS %s(%s VARCHAR, %s INT(3)",
                TabelaConfig.TABELA, TabelaConfig.Columns.NOME, TabelaConfig.Columns.IDADE);

        //executa o comando SQL
        db.execSQL(minhaQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //apaga a tabela
        db.execSQL("DROP TABLE IF EXISTS " + TabelaConfig.TABELA);

    }
}
