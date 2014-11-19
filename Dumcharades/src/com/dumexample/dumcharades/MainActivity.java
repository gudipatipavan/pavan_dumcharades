package com.dumexample.dumcharades;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnItemSelectedListener {
	CheckedTextView team,numberofplayers;
	EditText et1,et2;
	Spinner sp1,sp2;
	String text="";
	int pos;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		team=(CheckedTextView)findViewById(R.id.checkedTextView1);
		numberofplayers=(CheckedTextView)findViewById(R.id.checkedTextView2);
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		sp1=(Spinner)findViewById(R.id.spinner1);
		sp2=(Spinner)findViewById(R.id.spinner2);
		et1.setText("Team A");
		et2.setText("Team B");
		Button startgame=(Button)findViewById(R.id.startbutton);
		final Spinner sp1 = (Spinner)findViewById(R.id.spinner1);
		final String[] items = new String[]{"1", "2", "3","4","5","6","7","8","9","10"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
		sp1.setAdapter(adapter);
		Spinner sp2 = (Spinner)findViewById(R.id.spinner2);
		String[] items1 = new String[]{"1", "2", "3","4","5","6","7","8","9","10"};
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items1);
		sp2.setAdapter(adapter1);
	
		sp1.setOnItemSelectedListener(new MainActivity());
		
	
		
		startgame.setOnClickListener(new OnClickListener() {
			
		
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent it=new Intent(MainActivity.this,Dumcharades1.class);
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
         
		it.putExtra("getData",sp1.toString());
		

		


		
		 it.putExtra("text",et1.getText().toString());

		 it.putExtra("texts",et2.getText().toString());
		
		startActivity(it);
		
	}

		});}


	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}}
