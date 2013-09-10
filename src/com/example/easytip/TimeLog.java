package com.example.easytip;

import java.util.ArrayList;
import java.util.Stack;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TimeLog extends Activity implements android.view.View.OnClickListener {

	TextView showSubTotal;
	TextView showTip;
	TextView showTotal;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_time);
		
		showSubTotal = (TextView) findViewById(R.id.showSubTotal);
		showTip = (TextView) findViewById(R.id.showTip);
		showTotal = (TextView) findViewById(R.id.showTotal);
			
		Bundle myInput = this.getIntent().getExtras();
		
		String key = myInput.getString("key");
			
		for ( int i = 0; i < ViewLog.aList.size() ; i++ ) {
			
			BillEntry entry = ViewLog.aList.get(i);
			
			if ( entry.date.equalsIgnoreCase(key) ) {
				showSubTotal.setText(entry.subTotal);
				showTip.setText(entry.tip);
				showTotal.setText(entry.total);
				break;
			}
		}
	
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
