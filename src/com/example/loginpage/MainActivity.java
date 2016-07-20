package com.example.loginpage;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements android.view.View.OnClickListener {
WebView wv;
Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		wv=(WebView)findViewById(R.id.webView1);
		b=(Button)findViewById(R.id.button1);
		 b.setOnClickListener(this);
		WebSettings webSettings = wv.getSettings();
	        webSettings.setJavaScriptEnabled(true);
	      
		wv.setWebViewClient(new myClient());
		
		wv.loadUrl("file:///android_asset/fleet.htm");
Toast.makeText(getApplicationContext(), "Welcome to Fleet Vigil", Toast.LENGTH_SHORT).show();
	        }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public class myClient extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView v, String url){
			v.loadUrl(url);
			return true;
		}
	}
	

	@Override
	public void onClick(View arg0) {
		Intent intent = new Intent(getApplicationContext(), Maink.class);
		startActivity(intent);	// TODO Auto-generated method stub
		
	}

}
