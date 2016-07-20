package com.example.loginpage;

import android.app.PendingIntent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class SndSms extends ActionBarActivity implements OnClickListener {
	 String SMSApi = "https://site2sms.p.mashape.com/index.php?uid=8085763785&pwd=waheguru&phone=8982450925&msg=hello";
	 String head = "aVi7utR6ZUkGLFkGRwXxd4wLsXz7c1QQ";
	 WebView wv;
	EditText message;
	 TextView tv;
	    Button sendsms;  
	    String id="",name="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_snd_sms);
        message=(EditText)findViewById(R.id.editText2);  
        wv=(WebView)findViewById(R.id.webView1);
        sendsms=(Button)findViewById(R.id.button1);  
        id=getIntent().getStringExtra("tid");
        name=getIntent().getStringExtra("Name");
        sendsms.setOnClickListener(this); 
tv=(TextView)findViewById(R.id.textView1);
        Toast.makeText(getApplicationContext(), "Enter Your message now",  
            Toast.LENGTH_LONG).show(); 
tv.setText("To : "+name);
			 
    }  

    @Override  
    public void onClick(View arg0) {  
        
        //String msg=message.getText().toString();  
        try
        {
            String url = SMSApi;
            String smsApiResponse = sendMySMS(url);
            //System.out.println(smsApiResponse);
            Toast.makeText(getApplicationContext(),"Message Sent successfully!" ,Toast.LENGTH_LONG).show();     
            
        }
        catch (Exception e)
        {
        	e.printStackTrace();
                   
        }
          
        //Getting intent and PendingIntent instance  
       // Intent intent=new Intent(getApplicationContext(),MainActivity.class);  
        //PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);  
          
        //Get the SmsManager instance and call the sendTextMessage method to send message  
        //SmsManager sms=SmsManager.getDefault();  
       // sms.sendTextMessage(id, null, msg, pi,null);  
          
      finish();  
    }
		
    private  String sendMySMS(String url)
    {
        StringBuilder output = new StringBuilder();
        try
        {
            URL hp = new URL(url);
            
            HttpURLConnection hpCon = ( HttpURLConnection)hp.openConnection();
            hpCon.setRequestProperty("X-Mashape-Authorization", head);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(hpCon.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                output.append(inputLine);
            in.close();
            hpCon.disconnect();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return output.toString();
    }

	}


