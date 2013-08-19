package com.example.easytip;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Stack;
import java.util.Map;



public class BillEntry {
	
	String subTotal = null;
	String tip = null;
	String total = null;
	int yy, mm, dd;
	
	public int entryId;
	
	SimpleDateFormat dateFormat, timeFormat;
	
	public String date, time;
	
	final Calendar c;
	
	public static Map<String, Stack<BillEntry>> table = new LinkedHashMap<String,Stack<BillEntry>>();
	public static int counter = 1;
	
	public BillEntry( String subTotal, String tip, String total) {
		
		this.subTotal = subTotal;
		this.tip = tip;
		this.total = total;
		
		/*
		c = Calendar.getInstance();
		this.yy = c.get(Calendar.YEAR);
		this.mm = c.get(Calendar.MONTH);
		this.dd = c.get(Calendar.DATE);
		*/
		
		this.dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		this.timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		this.c = Calendar.getInstance();
		
		this.date = dateFormat.format(c.getTime());
		this.time = timeFormat.format(c.getTime());
		
		this.entryId = counter++;
		
	}
	
}
