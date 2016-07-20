package com.example.loginpage;

import com.example.loginpage.MainActivity.myClient;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Fourth extends ActionBarActivity {
	WebView wv;
	String id="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_fourth);
		id=getIntent().getStringExtra("tid");
		wv=(WebView)findViewById(R.id.webView1);
		WebSettings webSettings = wv.getSettings();
	        webSettings.setJavaScriptEnabled(true);
	       webSettings.setLoadWithOverviewMode(true);
		
		wv.setWebViewClient(new myClient());
		
		wv.loadUrl("http://115.112.241.148:9090/fleetvigil/jsp/maps/Vehicle_Locator.jsp?cid=SKDGROUP&vehicle="+id);

	}
	public class myClient extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView v, String url){
			v.loadUrl(url);
			return true;
		}
	}

	}
