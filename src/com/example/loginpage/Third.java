package com.example.loginpage;


import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
@SuppressLint("NewApi")
public class Third extends ActionBarActivity implements  OnClickListener  {
	WebView wv;
	Button b1;
	String tr[],a[]=new String[17],b[]=new String[17],d[]=new String[17];
	ProgressDialog progressBar;
	private int progressBarStatus = 0;
	private Handler progressBarHandler = new Handler();
	private long fileSize = 0;

	@Override
	public void onBackPressed() {
	    // Do Here what ever you want do on back press;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_third);
				wv=(WebView)findViewById(R.id.webView1);
		b1=(Button)findViewById(R.id.button1);
		 b1.setOnClickListener(this);
		WebSettings webSettings = wv.getSettings();
	        webSettings.setJavaScriptEnabled(true);
	        webSettings.setLoadWithOverviewMode(true);
			
		wv.setWebViewClient(new myClient());
		
		wv.loadUrl("file:///android_asset/fleetvigil.html");
		wv.addJavascriptInterface(new MyJavaScriptInterface(this), "HtmlViewer");
		progressBar = new ProgressDialog(this);
		progressBar.setCancelable(true);
		progressBar.setMessage("Loading ...");
		progressBar.setProgress(0);
		progressBar.setMax(100);
		progressBar.show();

		//reset progress bar and filesize status
		progressBarStatus = 0;
			fileSize = 0;

		new Thread(new Runnable() {
		  public void run() {
			while (progressBarStatus < 100) {

			  // performing operation
			  progressBarStatus = doOperation();

			  try {
				Thread.sleep(2000);
			  } catch (InterruptedException e) {
				e.printStackTrace();
			  }

			  // Updating the progress bar
			  progressBarHandler.post(new Runnable() {
				public void run() {
				  progressBar.setProgress(progressBarStatus);
				}
			  });
			}

			// performing operation if file is downloaded,
			if (progressBarStatus >= 100) {

				// sleeping for 1 second after operation completed
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {e.printStackTrace();}

				// close the progress bar dialog
				progressBar.dismiss();
			}
		  }
	     }).start();

	}

	class MyJavaScriptInterface {
        private Context ctx;
        MyJavaScriptInterface(Context ctx) {
            this.ctx = ctx;
        }
        @JavascriptInterface 
        public void showHTML(String html) {
        	   	tr=html.split("MP-09");
        	   for(int i=0;i<17;i++)
     {        	   	a[i]=tr[i+1].substring(0, 8);
        	   	a[i]="MP-09"+a[i];
        	    b[i]=tr[i+1].substring(52,71);
       	       String c[]=tr[i+1].split("left");
       	       int x=c[1].indexOf("<");
       	        d[i]=c[1].substring(2, x);
     }   	   	
 
        }

    }
	

	
	public class myClient extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView v, String url){
			v.loadUrl(url);
			return true;
		}
		 
	}
	int cnt=1;
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//Intent intent = new Intent(getApplicationContext(), Maink.class);
		//startActivity(intent);	// TODO Auto-generated method stub
		wv.loadUrl("javascript:window.HtmlViewer.showHTML(document.getElementById('vehicle_details_div').innerHTML);");
		
	if(cnt%2==0)
	{	
	
		Intent intent = new Intent(getBaseContext(), ListVehicle.class);
		intent.putExtra("a", a);
		intent.putExtra("b", b);
		intent.putExtra("d", d);
		
		startActivity(intent);
	}cnt++;
	}
	public int doOperation() {
		//The range of ProgressDialog starts from 0 to 10000
		while (fileSize <= 10000) {
 			fileSize++;
 			if (fileSize == 1000) {
				return 10;
			} else if (fileSize == 2000) {
				return 20;
			} else if (fileSize == 3000) {
				return 30;
			} else if (fileSize == 4000) {
			return 40;
			} else if (fileSize == 5000) {
				return 50;
			} else if (fileSize == 6000) {
				return 60;
			}
			 else if (fileSize == 7000) {
					return 70;
			}
			 else if (fileSize == 8000) {
					return 80;
			}
			 else if (fileSize == 9000) {
					return 90;
			}
			 else if (fileSize == 10000) {
					return 100;
			}
		}//end of while
		return 100;
	}//end of doOperation


	
	}
