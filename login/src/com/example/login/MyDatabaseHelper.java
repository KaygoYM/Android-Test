package com.example.login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper{

    public static final String CREATE_BOOK="create table Book ("+"id integer primary key autoincrement, " + "pages text, "+"name text)";
    private Context myContext;

    public MyDatabaseHelper(Context context, String name, CursorFactory factory, int version){
        super(context, name, factory, version);
        myContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        Toast.makeText(myContext, "创建成功", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}

