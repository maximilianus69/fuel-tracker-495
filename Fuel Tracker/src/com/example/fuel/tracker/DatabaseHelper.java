package com.example.fuel.tracker;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class DatabaseHelper extends SQLiteOpenHelper {  
	static final String dbName="Fuel Tracker";  
	   static final int  dbVersion=1;  
	   
	   static final String MileTable="Mileage_Table";
	   static final String id = "ID";
	   static final String colstartloc=" Current_Mileage";
	   static final String colendloc="End_Mileage";
	   static final String coltotalMile="Total_Mileage";
	   static final String colgasm="Gas_Mileage";
	   static final String typeveh="Vehicle Type";
	   
	   public DatabaseHelper(Context context) {  
		   
	       super(context, dbName, null, dbVersion);  
	               // Android will look for the database defined by DB_NAME  
	               // And if not found will invoke your onCreate method  
	 
	   }  
	   private SQLiteDatabase db;

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " +MileTable+" ("+id+"INTEGER PRIMARY KEY AUTOINCREMENT, "+colstartloc+" INTEGER , "+colendloc+
				" INTEGER , "+coltotalMile+" INTEGER, "+colgasm+" INTEGER, "+typeveh+" TEXT )");
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		db.execSQL("DROP TABLE IF EXISTS "+MileTable);
		onCreate(db);
	} 
	public void addtrip(int cmile, int emile, int tmile, int gmile, String veh)
	{
		db=this.getWritableDatabase();
		ContentValues cv=new ContentValues();  
		cv.put(colstartloc,cmile);  
		cv.put(colendloc,emile);  
		cv.put(coltotalMile,tmile);  
		cv.put(colgasm,gmile);
		cv.put(typeveh, veh);
		db.insert(MileTable,id,cv);
		db.close();
	
	}
}