package com.example.login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class LoadingActivity extends Activity {  
private ProgressDialog dialog;  
 @Override  
protected void onCreate(Bundle savedInstanceState) {  

super.onCreate(savedInstanceState);  
dialog = ProgressDialog.show(this, "加載中...", "正在登陆。。。。，請稍後！");  
Thread thread = new Thread(new Runnable() {  
public void run() {  
Message message = new Message();  
message.what = 0;  
mHandler.sendMessage(message);  
 }  
 });  
thread.start(); }  

private Handler mHandler = new Handler() {
@Override
	public void handleMessage(Message msg) {  

Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.example.mine");  
startActivity(LaunchIntent);  
 
 
 if (msg.what == 0) {  
 dialog.dismiss();  
              }  
          }  
  };  
}  
