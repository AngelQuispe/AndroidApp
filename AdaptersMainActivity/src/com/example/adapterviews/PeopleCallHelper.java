package com.example.adapterviews;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PeopleCallHelper extends SQLiteOpenHelper {
	public static final int DB_VERSION=1;
	public static final String DB_NAME="Agenda";
	
	public static final String CREATE_PERSONA=
			"CREATE TABLE Persona (Name text, Tel int)";
	public static final String INSERT_PERSONA1=
			"INSERT INTO Persona (Name, Tel) VALUES('Ronald Zegarra', 4323233)";
	public static final String INSERT_PERSONA2=
			"INSERT INTO Persona (Name, Tel) VALUES('Angel Quispe', 3443239)";
	
	public PeopleCallHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// this method gets called when your db is created
		db.execSQL(CREATE_PERSONA);
		db.execSQL(INSERT_PERSONA1);
		db.execSQL(INSERT_PERSONA2);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// eventually, specify how to upgrade from one version to another
	}
	
	public Cursor getAllPersona()
	{
		return getReadableDatabase().
				rawQuery("SELECT name,tel,rowid AS _id from Persona", null);
	}
}