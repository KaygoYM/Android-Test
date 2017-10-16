package com.example.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends Activity {
	private TextView textview_name;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.third_activity);
        textview_name=(TextView)findViewById(R.id.textView_name);
        Intent intent =getIntent(); 
        String first = intent.getStringExtra("edittext_name"); 
        textview_name.setText("Ç×°®µÄÍæ¼Ò"+first+",ÄúºÃ");
        Button bsl=(Button)findViewById(R.id.button_sl);
	    bsl.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent intent = new Intent();
        		intent.setClass(ThirdActivity.this,LoadingActivity.class);
        		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
        		startActivity(intent);	
        	
        	}
            });
	
	
	}
}