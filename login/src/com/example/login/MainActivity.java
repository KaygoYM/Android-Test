package com.example.login;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	 private Button button,button2,button_zc;
	 private String aname="admin";
	 private String apassword="admin";
	 private MyDatabaseHelper dbHelper;
private EditText edittext_name,edittext_pw;
	 
	 @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        button_zc=(Button)findViewById(R.id.button_zc);
        edittext_name=(EditText)findViewById(R.id.edit_text_name);
        edittext_pw=(EditText)findViewById(R.id.edit_text_password);        
        dbHelper = new MyDatabaseHelper(this, "Books.db", null, 1);
button.setOnClickListener(new OnClickListener(){
public void onClick(View v){
	String inputtext_n=edittext_name.getText().toString();
	String inputtext_p=edittext_pw.getText().toString(); 
           	 if (judge(inputtext_n,inputtext_p)){
           		 Intent intent_u = new Intent();
 	                                     intent_u.setClass(MainActivity.this,ThirdActivity.class);
 	                                     intent_u.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
 	                                     intent_u.putExtra("edittext_name",inputtext_n);
 	                                     startActivity(intent_u);}  
  	      else{Toast.makeText(MainActivity.this,"�û������������", Toast.LENGTH_SHORT).show();}
           	//edittext_name.setText(null);
           	edittext_pw.setText(null);
}
  	    });


button2.setOnClickListener(new OnClickListener(){   
public void onClick(View v)   
  	{String inputtext_n=edittext_name.getText().toString();
	String inputtext_p=edittext_pw.getText().toString(); 
 if (!(inputtext_n.equals(aname)&&(inputtext_p.equals(apassword))))
  			  {AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity.this);
  			  alertdialog.setTitle("��Ǹ!");
  			  alertdialog.setMessage("����Ա�û��������벻��ȷ!");
  			  alertdialog.setCancelable(false);
  			  alertdialog.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
  			        public void onClick(DialogInterface alertdialog, int which) {}
  			  });
  			  alertdialog.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
			        public void onClick(DialogInterface alertdialog, int which) {}
			  });
  			  alertdialog.show();
  			  }
   
 else { Intent intent = new Intent();
	intent.setClass(MainActivity.this,SecondActivity.class);
	intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
	startActivity(intent);}	
 edittext_name.setText(null);
	edittext_pw.setText(null);	
        	} });
	 
	 
button_zc.setOnClickListener(new OnClickListener(){  
	public void onClick(View v)  {
	Intent in_r = new Intent();
	in_r.setClass(MainActivity.this,register.class);
	startActivity(in_r);
	}
}); 
	 
	 	 
	 }
  

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    

public boolean judge(String a,String b){
	  SQLiteDatabase db = dbHelper.getWritableDatabase();
	  Cursor cursor = db.query("Book",null, null, null, null, null, null);
    if(cursor.moveToFirst()){    //�����ݵ�ָ���Ƶ���ѯ���ĵ�һ�����ݡ�
  	    
  	  	  do{   //����Cursor����ȡ������Toast����ʾ������
          String playerp = cursor.getString(cursor.getColumnIndex("pages")); //ͨ��Cursor��getColumnIndex()�ķ�������ȡ��ĳһ���ڱ��ж�Ӧλ�õ�������
          String playern = cursor.getString(cursor.getColumnIndex("name"));
          if(b.equals(playerp)&&a.equals(playern)){ return true; 	}
           }while(cursor.moveToNext());
       }
return false;

}



}




