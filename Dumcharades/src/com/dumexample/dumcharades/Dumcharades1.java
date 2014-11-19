package com.dumexample.dumcharades;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Dumcharades1 extends Activity  {
	Button back,next;
	protected Intent Intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity1);
		back=(Button)findViewById(R.id.startbutton);
		
		TextView tvw=(TextView)findViewById(R.id.grp_child);
		Bundle extras = getIntent().getExtras();
		String et1=extras.getString("text");
		tvw.setText(et1);
		String getSpinnerValue = getIntent().getExtras().getString("Value"); 
		
		 Toast.makeText(getApplicationContext(), getSpinnerValue,Toast.LENGTH_LONG).show();
				 next=(Button)findViewById(R.id.button2);
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it =new Intent(Dumcharades1.this,Dumcharades2.class);
				startActivity(it);
			}
		});
		back=(Button)findViewById(R.id.startbutton);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent =new Intent(Dumcharades1.this,MainActivity.class);
				startActivity(Intent);
			}
		});

	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity1, menu);
		return true;
	}

	

}
