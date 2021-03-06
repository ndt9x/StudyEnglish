package com.example.database;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.e_learning.vocabulary;


public class MySQLiteOpenHelper extends SQLiteOpenHelper{

	private static final String DB_NAME = "MyDataBase.db";
	private static final int vs = 1;
	private SQLiteDatabase database;
	public MySQLiteOpenHelper(Context context) {
		 
		super(context, DB_NAME, null, vs);
		 database = this.getWritableDatabase();
		 }
	/*VOCABULARY*/
	private static final String VOCABULARY = "vocabulary";
	public static final String CL_id_vol = "id";
	public static final String CL_Lesson = "lesson";
	public static final String CL_Nghia = "nghia";
	public static final String CL_Tenchu = "tenchu";
	public static final String CL_Phienam = "phienam";
	public static final String CL_Vidu = "vidu";
	
	// SQL create query
	private final static String CREATE_SQL = "CREATE TABLE "
			+ VOCABULARY
			+ " (id INTEGER PRIMARY KEY AUTOINCREMENT, lesson TEXT,  tenchu TEXT, phienam TEXT, nghia TEXT, vidu TEXT);\n";

	// khoi tao csdl
	@Override
	public void onCreate(SQLiteDatabase db) {
		String[] sql = CREATE_SQL.split("\n");
		boolean success = execMultipleSQL(db, sql);
		
	}

	private boolean execMultipleSQL(SQLiteDatabase db, String[] sql) {
		boolean returnFlag = false;

		db.beginTransaction();
		try {
			for (String s : sql) {
				if (s.trim().length() > 0)
					db.execSQL(s);
			}
			db.setTransactionSuccessful();

			returnFlag = true;
		} catch (Exception e) {

		} finally {
			db.endTransaction();
		}

		return returnFlag;

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + VOCABULARY);
		onCreate(db);
	}

	public long insertVol(Vocabulary vol) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(CL_Lesson, vol.getLesson());
		values.put(CL_Tenchu, vol.getTenchu());
		values.put(CL_Phienam, vol.getPhienam());
		values.put(CL_Nghia, vol.getNghia());
		values.put(CL_Vidu, vol.getVidu());
		long id = db.insert(VOCABULARY, null, values);
		db.close();
		return id;
	}

	/* Update Vocabulary */
	public int updateVol(Vocabulary vol) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(CL_Lesson, vol.getLesson());
		values.put(CL_Tenchu, vol.getTenchu());
		values.put(CL_Phienam, vol.getPhienam());
		values.put(CL_Nghia, vol.getNghia());
		values.put(CL_Vidu, vol.getVidu());
		int i = db.update(VOCABULARY, values, CL_id_vol + " = ?",
				new String[] { String.valueOf(vol.getId()) });
		db.close();
		return i;

	}

	/* Delete Vocabulary by id */
	public int deleteVol(int a) {
		SQLiteDatabase db = this.getWritableDatabase();
		int d = db.delete(VOCABULARY, CL_id_vol + " = ?",
				new String[] { String.valueOf(a) });

		db.close();
		return d;

	}
	public ArrayList<String> getAllLesson(){
		ArrayList<String> arr = new ArrayList<String>();
		String query = "SELECT DISTINCT lesson  FROM " + VOCABULARY;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		if (cursor.moveToFirst()) {
			do {
				arr.add(cursor.getString(0));
			} while (cursor.moveToNext());
		}
		db.close();
		return arr;
	}
	public ArrayList<Vocabulary> getvocabulary(String string) {
		ArrayList<Vocabulary> arrayList = new ArrayList<Vocabulary>();
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.query(VOCABULARY, new String[] { CL_id_vol, CL_Lesson, CL_Tenchu,
				CL_Phienam, CL_Nghia,CL_Vidu }, CL_Lesson + "=?", new String[] { string
				 }, null, null, null, null);
		Vocabulary vol = null;
		if (cursor.moveToFirst()) {
			do {
				vol = new Vocabulary();
				vol.setId(Integer.parseInt(cursor.getString(0)));
				vol.setLesson(cursor.getString(1));
				vol.setTenchu(cursor.getString(2));
				vol.setPhienam(cursor.getString(3));
				vol.setNghia(cursor.getString(4));
				vol.setVidu(cursor.getString(5));
				arrayList.add(vol);
			} while (cursor.moveToNext());
		}
		db.close();
		return arrayList;
	}

	public Vocabulary getVolbyId(int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.query(VOCABULARY, new String[] { CL_id_vol, CL_Lesson, CL_Tenchu,
				CL_Phienam, CL_Nghia,CL_Vidu },  CL_id_vol + " = ?", new String[] { id + "" }, null,
				null, null, null);
		Vocabulary vol = null;
		if (cursor.moveToFirst()) {
			do {
				vol = new Vocabulary();
				vol.setId(Integer.parseInt(cursor.getString(0)));
				vol.setLesson(cursor.getString(1));
				vol.setTenchu(cursor.getString(2));
				vol.setPhienam(cursor.getString(3));
				vol.setNghia(cursor.getString(4));
				vol.setVidu(cursor.getString(5));
			} while (cursor.moveToNext());
		}
		db.close();
		return vol;
	}

	public ArrayList<Vocabulary> getAllVol() {
		ArrayList<Vocabulary> arrayList = new ArrayList<Vocabulary>();
		String query = "SELECT * FROM " + VOCABULARY ;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		Vocabulary vol = null;
		if (cursor.moveToFirst()) {
			do {
				vol = new Vocabulary();
				vol.setId(Integer.parseInt(cursor.getString(0)));
				vol.setLesson(cursor.getString(1));
				vol.setTenchu(cursor.getString(2));
				vol.setPhienam(cursor.getString(3));
				vol.setNghia(cursor.getString(4));
				vol.setVidu(cursor.getString(5));
				arrayList.add(vol);
			} while (cursor.moveToNext());
		}
		db.close();
		return arrayList;
	}
	
}
	

