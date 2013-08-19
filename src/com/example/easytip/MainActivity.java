package com.example.easytip;

import java.util.Stack;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements android.view.View.OnClickListener {
	
	EditText subtotal;
	EditText tip;
	
	Button calculate;
	Button clear;
	Button addToLog;
	Button viewLog;
	
	String sub_total;
	String tip_;
	String showTotal;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		subtotal = (EditText) this.findViewById(R.id.input_subtotal);
		tip = (EditText) this.findViewById(R.id.input_tip);
		
		calculate = (Button) this.findViewById(R.id.calculate);
		clear = (Button) this.findViewById(R.id.clear);
		addToLog = (Button) this.findViewById(R.id.addtolog);
		viewLog = (Button) this.findViewById(R.id.viewlog);
		
		calculate.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				sub_total = ((TextView) subtotal).getText().toString();
				tip_ = ((TextView) tip).getText().toString();
				
				try {
					Double.parseDouble(sub_total);
				}
				catch (NumberFormatException e) {
					return;
				}
				
				try {
					Double.parseDouble(tip_);
				}
				catch (NumberFormatException e) {
					return;
				}
				
				/*
				if ( sub_total.equalsIgnoreCase("") || tip_.equalsIgnoreCase("") ){
					Context context = getApplicationContext();
					CharSequence text = "All fields must be entered correctly!";
					int duration = Toast.LENGTH_LONG;
					
					Toast error = Toast.makeText(context, text, duration);
					error.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
					error.show();
					return;
				}
				*/
				
				double _subtotal = Double.parseDouble(sub_total);
				double _tip = Double.parseDouble(tip_);
				
				double preTotal = _subtotal * _tip;
			
				double total = _subtotal + preTotal;
				
				showTotal = String.valueOf(total);
				
				((TextView) findViewById(R.id.showtotal)).setText("$" + showTotal);
			}
			
		});
		
		clear.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				((TextView) findViewById(R.id.input_subtotal)).setText("");
				((TextView) findViewById(R.id.input_tip)).setText("");
				((TextView) findViewById(R.id.showtotal)).setText("");
				
			}
			
		});
		
		
		addToLog.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				sub_total = ((TextView) findViewById(R.id.input_subtotal)).getText().toString();
				tip_ = ((TextView) findViewById(R.id.input_tip)).getText().toString();
				showTotal = ((TextView) findViewById(R.id.showtotal)).getText().toString();
				
				BillEntry newEntry = new BillEntry( sub_total, tip_, showTotal);
				
				if (BillEntry.table.containsKey(newEntry.date) == true) {
					Stack<BillEntry> temp = BillEntry.table.get(newEntry.date);
					temp.push(newEntry);
					BillEntry.table.put(newEntry.date, temp);
					
				}
				else{
					Stack<BillEntry> sq = new Stack<BillEntry>();
					sq.push(newEntry);
					BillEntry.table.put(newEntry.date, sq);
 				}
				
			}
		});
		
		viewLog.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Intent myIntent = new Intent(MainActivity.this, ViewLog.class);
				startActivity(myIntent);
				
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	}


}
