package com.example.loginpage;

import android.support.v7.app.ActionBarActivity;
//import android.support.v7.widget.PopupMenu;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ListVehicle extends ListActivity implements OnClickListener, OnItemSelectedListener {
	String selectedItem="";
	private TextView text,tv1,tv2;
	private List<String> listValues;
	String a[]=new String[17],b[]=new String[17],d[]=new String[17];
    String tid;
	Button b1;
	Spinner spin;
@Override
public void onBackPressed() {
    // Do Here what ever you want do on back press;
}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_list_vehicle);
		Intent intent=getIntent();
		a=intent.getStringArrayExtra("a");
			  b = getIntent().getStringArrayExtra("b");
			 d = getIntent().getStringArrayExtra("d");
		b1=(Button)findViewById(R.id.b1);
spin = (Spinner) findViewById(R.id.spinner1);  
spin.setOnItemSelectedListener(this);  
b1.setOnClickListener(this);


		
		text = (TextView) findViewById(R.id.mainText);
		tv1 = (TextView) findViewById(R.id.tv1);
		tv2 = (TextView) findViewById(R.id.tv2);
		
		listValues = new ArrayList<String>();
		for(int i=0;i<17;i++)
		listValues.add(a[i]);
		
		// initiate the listadapter
		//ArrayAdapter<String> myAdapter = new ArrayAdapter <String>(this,R.layout.row_layout, R.id.listText, listValues);
		 ArrayAdapter myAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listValues);  

		myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 
         // assign the list adapter
         //setListAdapter(myAdapter);
         spin.setAdapter(myAdapter); 
         
	}
	
		@SuppressLint("NewApi")
		@Override
	public void onClick(View arg0) {
		//Creating the instance of PopupMenu  
			
            PopupMenu popup = new PopupMenu(getApplicationContext(), b1);  
            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());  
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {  
             public boolean onMenuItemClick(MenuItem item) {  
              switch(item.getTitle().toString())
              {
              case "Locate on Map":
            	Intent i1=new Intent(getApplicationContext(), Fourth.class);
      			i1.putExtra("tid", tid);
      			startActivity(i1);	
      	   
            	  break;
           
              case "Contact Driver":
            	  Intent i2=new Intent(getApplicationContext(), SndSms.class);
      			i2.putExtra("tid", tid);
      			i2.putExtra("Name", selectedItem);
      			startActivity(i2);
              	  break;
              case "Refresh":finish();
             	  break;
              case "Exit"://android.os.Process.killProcess(android.os.Process.myPid());
              
            	  Intent a = new Intent(Intent.ACTION_MAIN);
            	  a.addCategory(Intent.CATEGORY_HOME);
            	  a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            	  startActivity(a);
              	  break;
             
              }
            	 //Toast.makeText(getApplicationContext(),"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();  
              return true;  
             } } );
            popup.show();//showing popup menu  
				
		
	  	
		
	}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		b1.setVisibility(0);
		   selectedItem = listValues.get(arg2);
			//String selectedItem = (String) getListAdapter().getItem(position);
			String s=selectedItem.substring(9);
			//Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
			switch(s)
			{
			case "9215":tid="9975225871";break;
			case "0515":tid="97300703231";break;
			case "9325":tid="7709147540";break;
			case "9235":tid="9561254509";break;

			case "7315":tid="9561064634";break;
			case "4735":tid="9503526765";break;
			case "0715":tid="8600485432";break;
			case "3525":tid="8600034524";break;

			case "9825":tid="8600034523";break;
			case "6135":tid="8600014934";break;
			case "3115":tid="8600014933";break;
			case "8475":tid="8600014932";break;

			case "0615":tid="7387052131";break;
			case "6515":tid="7387048883";break;
			case "0315":tid="9975034012";break;
			case "3815":tid="7709147602";break;

			case "1382":tid="8600014929";break;
					
		
	}tv1.setText("Vehicle : " + selectedItem);
		tv2.setText("\n--------Location----------\n"+d[arg2]); 
			text.setText( "\n---Last Reporting Time---\n" + b[arg2]); 		
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	}
