package com.example.easytip;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;	
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;	
import android.util.Log;

public class DBAdapter extends SQLiteOpenHelper{

	public static final String KEY_ROWID = "id";
	public static final String KEY_DATE = "date";
	public static final String KEY_SUBTOTAL = "subTotal";
	public static final String KEY_TIP = "tip";
	public static final String KEY_TOTAL = "total";
	
	private static final String DATABASE_NAME = "EntryDB";
	private static final String DATABASE_TABLE = "entries";
	private static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_CREATE = 
			"create table if not exists " + DATABASE_TABLE + " (" + KEY_ROWID + " integer primary key " +
					"autoincrement, " + KEY_DATE + " VARCHAR, " + KEY_SUBTOTAL + " VARCHAR, " + 
					KEY_TIP + " VARCHAR, " + KEY_TOTAL + " VARCHAR);";
	
	public DBAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL(DATABASE_CREATE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public void addBillEntry( BillEntry entry ) {
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_DATE, entry.date);
		values.put(KEY_SUBTOTAL, entry.subTotal);
		values.put(KEY_TIP, entry.tip);
		values.put(KEY_TOTAL, entry.total);
		
		db.insert(DATABASE_TABLE, null, values);
	    db.close(); // Closing database connection
		
	}
}
