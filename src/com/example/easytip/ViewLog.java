package com.example.easytip;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.CheckBox;
import android.widget.Toast;

public class ViewLog extends ListActivity implements android.view.View.OnClickListener {

	public static List<BillEntry> aList;
	
	ArrayList<String> list = new ArrayList<String>();
	
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_view2);	
	
		
		DBAdapter db = new DBAdapter(this);
		
		aList = db.getAllBillEntries();
		BillEntry a;
		
		for ( int i = aList.size() - 1; i >= 0; i-- ){
			a = aList.get(i);
			String entry = a.entryId + ": " + a.date;
			list.add(entry);
		}
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));
	    
		
	}
	
	@Override 
	public void onListItemClick(ListView parent, View v, int position, long id) {
		
		
		String key = getListAdapter().getItem(position).toString();
		String[] str = key.split(": ");
		String entryId = str[0];
		
		/*
		Toast pr = Toast.makeText(ViewLog.this, key, Toast.LENGTH_LONG);
		pr.show();
		*/
		
		Intent myIntent = new Intent(ViewLog.this, TimeLog.class);
		myIntent.putExtra("key", entryId);
		
		startActivity(myIntent);
	
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

	