package com.example.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class register extends Activity {
	   EditText add_bookname,add_bookpage;  
	   private MyDatabaseHelper dbHelper= new MyDatabaseHelper(this, "Books.db", null, 1);  
	   protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         requestWindowFeature(Window.FEATURE_NO_TITLE);
         setContentView(R.layout.register);
           Button button_a=(Button)findViewById(R.id.a_db);
           add_bookname=(EditText)findViewById(R.id.add_bookname);
    	   add_bookpage=(EditText)findViewById(R.id.add_bookpage);       
           button_a.setOnClickListener(new OnClickListener(){
        	   public void onClick(View v){
                	  	SQLiteDatabase db = dbHelper.getWritableDatabase();
                	    ContentValues inputvalue = new ContentValues();
                	    String bookname = add_bookname.getText().toString();
                	    String bookpage = add_bookpage.getText().toString();
                	    
              Cursor cursor = db.query("Book",new String[]{"name"}, null, null, null, null, null);
                        if(cursor.moveToFirst()){    //�����ݵ�ָ���Ƶ���ѯ���ĵ�һ�����ݡ�
                            do{   //����Cursor����ȡ������Toast����ʾ������
                                String playername = cursor.getString(cursor.getColumnIndex("name")); //ͨ��Cursor��getColumnIndex()�ķ�������ȡ��ĳһ���ڱ��ж�Ӧλ�õ�������
                                if(playername.equals(bookname)) {Toast.makeText(register.this,"�û��Ѵ��ڣ�����������", Toast.LENGTH_SHORT).show();
                                add_bookname.setText(null);
                                add_bookpage.setText(null);return;
                                }
                            }while(cursor.moveToNext());
                            }
                        inputvalue.put("name", bookname);
                        inputvalue.put("pages", bookpage);
                        Toast.makeText(register.this,"ע��ɹ���", Toast.LENGTH_SHORT).show();
                        db.insert("Book", null, inputvalue);
                        
                        inputvalue.clear();
                        add_bookname.setText(null);
                        add_bookpage.setText(null);
                                }
              	    });
   	     }
}