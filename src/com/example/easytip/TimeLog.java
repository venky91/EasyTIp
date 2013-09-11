package com.example.easytip;

import java.util.ArrayList;
import java.util.Stack;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TimeLog extends Activity implements android.view.View.OnClickListener {

	Button deleteEntry;
	TextView showSubTotal;
	TextView showTip;
	TextView showTotal;
	int id;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_time);
		
		RelativeLayout timelayout = (RelativeLayout) findViewById(R.layout.log_time);
		
		showSubTotal = (TextView) findViewById(R.id.showSubTotal);
		showTip = (TextView) findViewById(R.id.showTip);
		showTotal = (TextView) findViewById(R.id.showTotal);
			
		Bundle myInput = this.getIntent().getExtras();
		
		String key = myInput.getString("key");
		id = Integer.parseInt(key);
			
		for ( int i = 0; i < ViewLog.aList.size() ; i++ ) {
			
			BillEntry entry = ViewLog.aList.get(i);
			
			if ( entry.entryId == id ) {
				
				showSubTotal.setText(entry.subTotal);
				showTip.setText(entry.tip);
				showTotal.setText(entry.total);
				break;
			}
		}
		
		
		deleteEntry = (Button) findViewById(R.id.deleteEntry);
		deleteEntry.setOnClickListener( new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				DBAdapter db = new DBAdapter(TimeLog.this);
				db.deleteBillEntry(id);
				Intent myIntent = new Intent(TimeLog.this, ViewLog.class);
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
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

}
