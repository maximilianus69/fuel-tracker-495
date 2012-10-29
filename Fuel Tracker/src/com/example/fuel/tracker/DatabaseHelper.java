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
	static final String dbName="Assignments";  
	   static final int       dbVersion=1;  
	   
	   static final String MileTable="Mileage Table";
	   static final String colstartloc=" Start Location";
	   static final String colendloc="End Location";
	   static final String coltotalMile="Total Mileage";
	   static final String colgasm="Gas Mileage";
	   
	   public DatabaseHelper(Context context) {  
		   
	       super(context, dbName, null, dbVersion);  
	               // Android will look for the database defined by DB_NAME  
	               // And if not found will invoke your onCreate method  
	 
	   }  
	   private SQLiteDatabase db;

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " +MileTable+" ("+colstartloc+" Integer , "+colendloc+
				" Integer , "+coltotalMile+" Integer, "+colgasm+" INTEGER )");
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		db.execSQL("DROP TABLE IF EXISTS "+MileTable);
		onCreate(db);
	} 

}