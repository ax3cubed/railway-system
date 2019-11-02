package com.example.onrail;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String DB_NAME="beprojtry";
	public static final String TABLE_NAME="train";
	public static final String TABLE_NAME1="inode";
	public static final String TABLE_NAME2="laglng";
	public DatabaseHelper(Context context, String name, CursorFactory factory,int version){
		super(context,DB_NAME,factory,version);
		Log.i("Helper","Helper");
	}
	public void onCreate(SQLiteDatabase db){
		String createQuery="create table if not exists train(trainnum int primary key, trainname varchar(50),source varchar(30),dest varchar(30),arrival varchar(10),depart varchar(10),inter varchar(100),junction varchar(100),avail int,day varchar(50))";
		db.execSQL(createQuery);
		Log.i("Dropp", "Dropp1");
		createQuery="create table if not exists inode(trainno int,source varchar(30),arrival TIME)";
		db.execSQL(createQuery);
		Log.i("Dropp", "Dropp2");
		createQuery="create table if not exists latlng(city varchar(50) primary key,latitude double,longitude double)";
		db.execSQL(createQuery);
		Log.i("Dropp", "Dropp3");
	}
	
	public void onUpgrade(SQLiteDatabase db,int version,int newVersion){
		db.execSQL("DROP TABLE IF NOT EXISTS"+TABLE_NAME);
		db.execSQL("DROP TABLE IF NOT EXISTS"+TABLE_NAME1);
		db.execSQL("DROP TABLE IF NOT EXISTS"+TABLE_NAME2);
		onCreate(db);
	}
}
