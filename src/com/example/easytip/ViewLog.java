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

public class ViewLog extends ListActivity implements android.view.View.OnClickListener {

	public static List<BillEntry> aList;
	
	ArrayList<String> list = new ArrayList<String>();
	
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_view2);	
		
		/*
		((TextView) findViewById(R.id.logView)).append("    Date" + "      " + "   Subtotal" + "      " + "Tip"
					+ "      " + "Total" + "\n");
		*/
		/*
		for ( int i = BillEntry.table.size() ; i >= 0; i-- ) {
			BillEntry temp = BillEntry.sq.elementAt(i);
			((TextView) findViewById(R.id.logView)).append(temp.yy + "/" + temp.mm + "/" + temp.dd + 
					"      " + temp.subTotal + "             " + temp.tip +  "      " + temp.total + "\n");
		}
		*/
		
		//final ListView listview = (ListView) findViewById(R.id.loglistview);
		
		DBAdapter db = new DBAdapter(this);
		
		aList = db.getAllBillEntries();
		BillEntry a;
		
		for ( int i = aList.size() - 1; i >= 0; i-- ){
			a = aList.get(i);
			list.add(a.date);
		}
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));
	    
		
	}
	
	@Override 
	public void onListItemClick(ListView parent, View v, int position, long id) {
		
		String key = getListAdapter().getItem(position).toString();
		
		Intent myIntent = new Intent(ViewLog.this, TimeLog.class);
		myIntent.putExtra("key", key);
		
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

	