package com.dumexample.dumcharades;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Dumcharades2 extends Activity {
	Button back,next;
	TextView tsw;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dumcharades2);		
		Bundle extras = getIntent().getExtras();
		String et1=extras.getString("text");
		tsw.setText(et1);
		back=(Button)findViewById(R.id.startbutton1);
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it=new Intent(Dumcharades2.this,Dumcharades1.class);
				startActivity(it);
			}
			
		});
		
		next=(Button)findViewById(R.id.button2);
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent Intent = new Intent(Dumcharades2.this,Dumcharades3.class);
				startActivity(Intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dumcharades2, menu);
		return true;
	}

}
