package com.example.database;

import java.util.ArrayList;
import java.util.Iterator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
	private static final String DB_NAME = "MyDataBase.db";
	private static final int vs = 1;
	private SQLiteDatabase database;

	public MySQLiteOpenHelper(Context context) {
		super(context, DB_NAME, null, vs);
		database = this.getWritableDatabase();
	}

	public static final String EXTRA = "extra";
	public static final String CL_idextra = "id";
	public static final String CL_ten = "ten";
	public static final String CL_noidung = "noi dung";
	private final static String CREATE_SQL = "CREAT TABLE" + EXTRA
			+ "(id INTEGER PRIMARY KEY AUTOINCREMENT,ten INT, noidung TEXT);";

	@Override
	public void onCreate(SQLiteDatabase db) {
		String[] sql = CREATE_SQL.split("\n");
	}

	private boolean execMultipleSQL(SQLiteDatabase db, String[] sql) {
		boolean returnfLag = false;
		db.beginTransaction();
		try {
			for (String s : sql) {
				if (s.trim().length() > 0)
					db.execSQL(s);
				{
					db.setTransactionSuccessful();
					returnfLag = true;
				}
			}
		} catch (Exception e) {

		} finally {
			db.endTransaction();
		}

		return returnfLag;

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS" + EXTRA);
		onCreate(db);
	}

	public Long insertExtra(ExtraData extra) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(CL_ten, extra.getTen());
		values.put(CL_noidung, extra.getNoidung());
		Long id = db.insert(EXTRA, null, values);
		db.close();
		return id;
	}

	public int updateExtra(ExtraData extra) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(CL_ten, extra.getTen());
		values.put(CL_noidung, extra.getNoidung());
		int i = db.update(EXTRA, values, CL_idextra + "= ?",
				new String[] { String.valueOf(extra.getId()) });
		db.close();
		return i;
	}

	public int deleteExtra(int a) {
		SQLiteDatabase db = this.getWritableDatabase();
		int d = db.delete(EXTRA, CL_idextra + "= ?",
				new String[] { String.valueOf(a) });
		db.close();
		return d;
	}

	public ExtraData getExtra(int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.query(EXTRA, new String[] { CL_idextra, CL_ten,
				CL_noidung }, CL_idextra + " = ?", new String[] { id + "" },
				null, null, null, null);
		ExtraData extraData = null;
		if (cursor.moveToFirst()) {
			do {
				extraData = new ExtraData(null, null, id);
				extraData.setId(Integer.parseInt(cursor.getString(0)));
				extraData.setTen(cursor.getString(1));
				extraData.setNoidung(cursor.getString(2));
			} while (cursor.moveToNext());
		}
		db.close();
		return extraData;
	}

	public ExtraData getExtrabyId(int id) {
		ArrayList<ExtraData> arrayList = new ArrayList<ExtraData>();
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.query(EXTRA, new String[] { CL_idextra, CL_ten,
				CL_noidung }, CL_idextra + " = ?", new String[] { id + "" },
				null, null, null, null);
		ExtraData extraData = null;
		if (cursor.moveToFirst()) {
			do {
				extraData = new ExtraData(null, null, id);
				extraData.setId(Integer.parseInt(cursor.getString(0)));
				extraData.setTen(cursor.getString(1));
				extraData.setNoidung(cursor.getString(2));
				arrayList.add(extraData);
			} while (cursor.moveToNext());
		}
		db.close();
		return extraData;
	}

	public ArrayList<ExtraData> getAllExtra() {
		ArrayList<ExtraData> arrayList = new ArrayList<ExtraData>();
		String query = "SELECT  * FROM " + EXTRA;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		ExtraData extraData = null;
		if (cursor.moveToFirst()) {
			do {
				extraData = new ExtraData();
				extraData.setId(Integer.parseInt(cursor.getString(0)));
				extraData.setTen(cursor.getString(1));
				extraData.setNoidung(cursor.getString(2));
				arrayList.add(extraData);
			} while (cursor.moveToNext());
		}
		db.close();
		return arrayList;
	}
}
