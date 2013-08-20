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

public class TimeLog extends ListActivity implements android.view.View.OnClickListener {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_time);
		
		Bundle myInput = this.getIntent().getExtras();
		
		String key = myInput.getString("key");
		
		Stack<BillEntry> temp = (Stack<BillEntry>) BillEntry.table.get(key);
		
		ArrayList<String> list = new ArrayList<String>();
		
		for ( int i = temp.size() - 1; i >= 0; i-- ) {
			BillEntry tempEntry = temp.get(i);
			list.add(tempEntry.time);
		}
		
		 setListAdapter(new ArrayAdapter<String>(this,
		            android.R.layout.simple_list_item_1, list));
		 
		 
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
