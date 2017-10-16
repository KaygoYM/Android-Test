package com.example.login;

import android.app.Instrumentation;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.os.Bundle;
	public class TitleLayout extends LinearLayout{

	      public TitleLayout(Context context, AttributeSet attrs){
	            super(context,attrs);
	            LayoutInflater.from(context).inflate(R.layout.title2,this);
	      
	     
	      Button btn_back = (Button)findViewById(R.id.title_back);
	      Button btn_edit = (Button)findViewById(R.id.title_edit);

	      btn_back.setOnClickListener(new OnClickListener() {
	            @Override
	            public void onClick(View v) {
	            	simulateKey(KeyEvent.KEYCODE_BACK); 
	            }
	      });

	      btn_edit.setOnClickListener(new OnClickListener(){
	            @Override
	            public void onClick(View v) {
	                  Toast.makeText(getContext(), "这是一个摆设按钮",Toast.LENGTH_SHORT).show();
	            }
	      });
	}

	      public static void simulateKey(final int KeyCode) {
	    	  new Thread() {
	    	  public void run() {
	    	  try {
	    	  Instrumentation inst = new Instrumentation();
	    	  inst.sendKeyDownUpSync(KeyCode);
	    	  } catch (Exception e) {
	    	  Log.e("Exception when sendKeyDownUpSync", e.toString());
	    	  }
	    	  }
	    	  }.start();
	    	  }


	
	}
	
	


