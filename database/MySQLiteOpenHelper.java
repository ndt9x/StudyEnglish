//package com.example.database;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.database.sqlite.SQLiteDatabase;
//import android.provider.OpenableColumns;

//public class MySQLiteOpenHelper {
//	/*Ten Database*/
//	private static final String DATABASE_NAME="DB_ENGLISH";
//	
//	/* Version database*/
//	private static final int DATABASE_VERSION = 1;
//		
//	/*Tên table và các column trong database*/
//	
//	/*Tao bang vocabulary*/
//	private static final String TABLE_VOCABULARY="VOCABULARY";
//	public static final String COLUMN_ID="id";
//	public static final String COLUMN_LESSON="lesson";
//	public static final String COLUMN_NGHIA="nghia";
//	public static final String COLUMN_TENCHU="tenchu";
//	public static final String COLUMN_PHIENAM="phienam";
//	public static final String COLUMN_VIDU="vidu";
//	
//	
//	/*Cac doi tuong khac*/
//	private static Context context;
//	static SQLiteDatabase db;
//	private OpenHelper  openHelper;
//			
//	/*Ham dung, khoi tao doi tuong*/
//	public MySQLiteOpenHelper(Context c){
//		MySQLiteOpenHelper.context=c;
//	}
//	/*Ham mo ket noi database*/
//	public MySQLiteOpenHelper onpen() throws SQLException{
//		
//		openHelper=new OpenHelper(context);
//		db=openHelper.getWritableDatabase();
//		return this;
//	}
//	
//	/*Ham dong ket noi database*/
//	
//	public void close(){
//		openHelper.close();
//	}
//	
//	/*Ham createData dung de chen du lieu moi vao database*/
//	public long createData(String _lesson, String _nghia, String _tenchu, String _phienam, String _vidu){
//		
//		ContentValues cv= new ContentValues();
//		cv.put(COLUMN_LESSON, _lesson);
//		cv.put(COLUMN_NGHIA, _nghia);
//		cv.put(COLUMN_PHIENAM, _phienam);
//		cv.put(COLUMN_TENCHU, _tenchu);
//		cv.put(COLUMN_VIDU, _vidu);
//		return db.insert(TABLE_VOCABULARY, null, cv);
//	}	
//		/*Ham getData tra ve toan bo du lieu cua table VOCABULARY cua database duoi 1 chuoi*/
//		public String getData(){
//			
//			String[] columns=new String[]{COLUMN_ID, COLUMN_LESSON, COLUMN_NGHIA, COLUMN_PHIENAM, COLUMN_TENCHU, COLUMN_VIDU};
//			Cursor c=db.query(TABLE_VOCABULARY, columns, null, null, null, null, null,null);
//			
//			String result="";
//			//lay chi so, vi tri cua column id
//			int iRow=c.getColumnIndex(COLUMN_ID);
//			int iLess=c.getColumnIndex(COLUMN_LESSON);
//			int iNghia=c.getColumnIndex(COLUMN_NGHIA);
//			int iPhienAm=c.getColumnIndex(COLUMN_PHIENAM);
//			int iTenChu=c.getColumnIndex(COLUMN_TENCHU);
//			int iViDu=c.getColumnIndex(COLUMN_VIDU);
//			
//			// Vong lap lay du lieu cua con tro
//			for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
//				
//				result=result + " " + c.getString(iRow)
//							+"- id:"+ c.getString(iLess)
//							+"- nghia"+ c.getString(iNghia)
//							+"- phien am"+ c.getString(iPhienAm)
//							+"- ten chu"+ c.getString(iTenChu)
//							+"- vi du"+ c.getString(iViDu) + "\n";
//			}
//			c.close();
//			return result;
//		}
//			
//		//--------Class OpenHelper-----------
//		private static class OpenHelper extends SQLiteOpenHelper{
//			
//			/*Hàm dựng khởi tạo 1 OpenHelper*/
//	        public OpenHelper(Context context) {
//	            super(context, DATABASE_NAME, null, DATABASE_VERSION);
//	        }
//	        
//	        /*tao moi database*/
//	        @Override 
//	        public void onCreate(SQLiteDatabase arg0){
//	        	
//	        	arg0.execSQL("CREATE TABLE" + TABLE_VOCABULARY +"("
//	        			+ COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
//	        			+ COLUMN_LESSON + "TEXT NOT NULL,"
//	        			+ COLUMN_NGHIA + "TEXT NOT NULL,"
//	        			+ COLUMN_PHIENAM +"TEXT NOT NULL,"
//	        			+ COLUMN_TENCHU + "TEXT NOT NULL,"
//	        			+ COLUMN_VIDU + "TEXT NOT NULL);");
//	        }
//	        
//	        /*kiem tra phien ban database neu khac se thay doi*/
//	        @Override
//	        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){
//	        	arg0.execSQL("DROP TABLE IF EXISTS"+ TABLE_VOCABULARY);
//	        	
//	        }
//		}
//	}


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
	

