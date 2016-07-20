package com.example.loginpage;

import com.example.loginpage.MainActivity.myClient;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Maink extends ActionBarActivity implements OnClickListener {
WebView wv;
EditText uname,pwd;
Button login;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_maink);
		uname =(EditText)findViewById(R.id.username);
		pwd =(EditText)findViewById(R.id.password);
		login =(Button)findViewById(R.id.login);
		login.setOnClickListener(this);
	}
	@Override
	public void onBackPressed() {
	    // Do Here what ever you want do on back press;
	}
	@Override
	public void onClick(View arg0) {
		
		if(uname.getText().toString().equalsIgnoreCase("skdgroup"))
		 { 
			 if(pwd.getText().toString().equalsIgnoreCase("skd321"))
					 {
				 Intent intent = new Intent(getApplicationContext(),Third.class);
				 startActivity(intent);
					 }
			 else{pwd.setText("");
				 //Toast.makeText(getApplicationContext(), "Wrong Password..!!\nTry Again", Toast.LENGTH_SHORT).show();
			 	 }
			 }
		 else 
		 {uname.setText("");
		 Toast.makeText(getApplicationContext(), "Incorrect Username..!!\nTry Again", Toast.LENGTH_SHORT).show();
		 }
		 }
		
	}
		  
		  

	

	
	