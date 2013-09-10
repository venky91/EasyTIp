package com.example.easytip;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Stack;
import java.util.Map;



public class BillEntry {
	
	String subTotal = null;
	String tip = null;
	String total = null;
	int yy, mm, dd;
	
	public int entryId;
	
	SimpleDateFormat dateFormat;
	Date dNow;
	
	public String date, time;
	
	public static Map<String, Stack<BillEntry>> table = new LinkedHashMap<String,Stack<BillEntry>>();
	public static int counter = 1;
	
	public BillEntry() {
		
	}
	
	public BillEntry( String subTotal, String tip, String total) {
		
		this.subTotal = subTotal;
		this.tip = tip;
		this.total = total;
			
		dNow = new Date();
		this.dateFormat = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
				
		this.date = dateFormat.format(dNow);
	
		
		this.entryId = counter++;
		
	}
	
	public void setDate( String date ) {
		this.date = date;
	}
	
	public void setSubTotal( String subTotal ) {
		this.subTotal = subTotal;
	}
	
	public void setTip( String tip ) {
		this.tip = tip;
	}
	
	public void setTotal( String total ) {
		this.total = total;
	}
}
