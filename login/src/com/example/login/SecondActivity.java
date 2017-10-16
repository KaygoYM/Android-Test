package com.example.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
public class SecondActivity extends Activity {
	
	private List<Letter> letterlist = new ArrayList<Letter>();
	private MyDatabaseHelper dbHelper;
	private LetterAdapter adapter;
	private ListView listview;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          requestWindowFeature(Window.FEATURE_NO_TITLE);
          setContentView(R.layout.second_activity);
          dbHelper = new MyDatabaseHelper(this, "Books.db", null, 1);
          initLetter();     
          adapter = new LetterAdapter(SecondActivity.this, R.layout.letter_item, letterlist);
          listview = (ListView)findViewById(R.id.list_view);
          listview.setAdapter(adapter);
          listview.setOnItemClickListener(new OnItemClickListener(){
              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Letter letter = letterlist.get(position);
                    Toast.makeText(SecondActivity.this, "���û�����Ϊ"+letter.getPassword(), Toast.LENGTH_SHORT).show();
              }
        });

     
      Button create_db = (Button) findViewById(R.id.c_db);
      create_db.setOnClickListener(new OnClickListener(){
                public void onClick(View v){
                      dbHelper.getWritableDatabase();}
          });
          
      Button delete_db = (Button) findViewById(R.id.button_de);
      delete_db.setOnClickListener(new OnClickListener(){
    	  EditText edittext_de=(EditText)findViewById(R.id.editText_de);
    	  public void onClick(View v){
    		  boolean isdelet=false;
                	SQLiteDatabase db = dbHelper.getWritableDatabase();
                	Cursor cursor = db.query("Book",new String[]{"name","pages"}, null, null, null, null, null);
                    if(cursor.moveToFirst()){    //�����ݵ�ָ���Ƶ���ѯ���ĵ�һ�����ݡ�
                        do{   //����Cursor����ȡ������Toast����ʾ������
                        	String temps = cursor.getString(cursor.getColumnIndex("name"));
                        	if(temps.equals(edittext_de.getText().toString()))
                        	{db.delete("Book","name=?", new String[]{temps});isdelet=true;
                        	Toast.makeText(SecondActivity.this, "ɾ���ɹ���", Toast.LENGTH_SHORT).show();}
                        	}while(cursor.moveToNext());refresh();
                        }
                   if(!isdelet) Toast.makeText(SecondActivity.this, "�����ڸ��û���", Toast.LENGTH_SHORT).show();

    	  }});
	
}

public void refresh(){initLetter();     
adapter = new LetterAdapter(SecondActivity.this, R.layout.letter_item, letterlist);
listview = (ListView)findViewById(R.id.list_view);

listview.setAdapter(adapter);
listview.setOnItemClickListener(new OnItemClickListener(){
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
          Letter letter = letterlist.get(position);
          Toast.makeText(SecondActivity.this, "���û�����Ϊ"+letter.getPassword(), Toast.LENGTH_SHORT).show();
    }
});
}
	
private void initLetter() {
		// TODO Auto-generated method stub 
	letterlist.clear();
		SQLiteDatabase db = dbHelper.getWritableDatabase();
         Cursor cursor = db.query("Book",new String[]{"name","pages"}, null, null, null, null, null);
         if(cursor.moveToFirst()){    //�����ݵ�ָ���Ƶ���ѯ���ĵ�һ�����ݡ�
             do{   //����Cursor����ȡ������Toast����ʾ������
                 String bookname = cursor.getString(cursor.getColumnIndex("name")); //ͨ��Cursor��getColumnIndex()�ķ�������ȡ��ĳһ���ڱ��ж�Ӧλ�õ�������
                 String password = cursor.getString(cursor.getColumnIndex("pages"));
                 Letter a = new Letter(bookname, R.drawable.a);
                 letterlist.add(a);    
             a.setPassword(password);
             }while(cursor.moveToNext());
          }
          cursor.close();
          }

public MyDatabaseHelper getdb(){return dbHelper;}

}



