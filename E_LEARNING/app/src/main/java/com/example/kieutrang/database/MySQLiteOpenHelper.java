package com.example.kieutrang.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.kieutrang.e_learning.E_Learning;

import java.util.ArrayList;

/**
 * Created by KieuTrang on 10/30/2015.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "MyDatabase.db";
    private static final int vs = 1;
    private SQLiteDatabase database;

    public MySQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, vs);
        database = this.getWritableDatabase();
    }

    /*VOCABULARY - MIEN*/
    private static final String VOCABULARY = "vocabulary";
    public static final String CL_id_vol = "id";
    public static final String CL_Lesson = "lesson";
    public static final String CL_Nghia = "nghia";
    public static final String CL_Tenchu = "tenchu";
    public static final String CL_Phienam = "phienam";
    public static final String CL_Vidu = "vidu";
    /* TEST - TRANG*/
    private static final String TEST = "test_english";
    public static final String CL_id_test = "id";
    public static final String CL_cat = "category";
    public static final String CL_Ques = "question";
    public static final String CL_aswA = "answerA";
    public static final String CL_aswB = "answerB";
    public static final String CL_aswC = "answerC";
    public static final String CL_aswD = "answerD";
    public static final String CL_aswT = "answerTrue";
    /*EXTRA - TIEN*/
    public static final String EXTRA = "extra";
    public static final String CL_id_extra = "id";
    public static final String CL_Ten = "ten";
    public static final String CL_Noidung = "noidung";
    // SQL create query
    private final static String CREATE_SQL = "CREATE TABLE "
            + VOCABULARY
            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, lesson TEXT,  tenchu TEXT, phienam TEXT, nghia TEXT, vidu TEXT);\n"
            + "CREATE TABLE "
            + TEST
            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, category TEXT, question TEXT, answerA TEXT, answerB TEXT, answerC TEXT, answerD TEXT, answerTrue TEXT);\n"
            + "CREATE TABLE "
            + EXTRA
            + " (id INTEGER PRIMARY KEY AUTOINCREMENT, ten INT, noidung TEXT);";



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
    /*METHODS VOCABLULARY - MIEN*/
    // Insert Vocabulary
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

    // Update Vocabulary
    public int updateVol(Vocabulary vol) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CL_Lesson, vol.getLesson());
        values.put(CL_Tenchu, vol.getTenchu());
        values.put(CL_Phienam, vol.getTenchu());
        values.put(CL_Nghia, vol.getNghia());
        values.put(CL_Vidu, vol.getVidu());
        int i = db.update(VOCABULARY, values, CL_id_vol + " = ?",
                new String[]{String.valueOf(vol.getId())});
        db.close();
        return i;
    }

    // Delete Vocabulary by id
    public int deleteVol(int a) {
        SQLiteDatabase db = this.getWritableDatabase();
        int d = db.delete(VOCABULARY, CL_id_vol + " = ?",
                new String[]{String.valueOf(a)});

        db.close();
        return d;

    }

    public ArrayList<String> getAllLesson() {
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
        Cursor cursor = db.query(VOCABULARY, new String[]{CL_id_vol, CL_Lesson, CL_Tenchu,
                CL_Phienam, CL_Nghia, CL_Vidu}, CL_Lesson + "=?", new String[]{string
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
        Cursor cursor = db.query(VOCABULARY, new String[]{CL_id_vol, CL_Lesson, CL_Tenchu,
                        CL_Phienam, CL_Nghia, CL_Vidu}, CL_id_vol + " = ?", new String[]{id + ""}, null,
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
        String query = "SELECT * FROM " + VOCABULARY;
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
    /*METHODS TEST - TRANG*/
    // Insert Test
    public long insertTest(Test test) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CL_cat, test.getCategory());
        values.put(CL_Ques, test.getQuestion());
        values.put(CL_aswA, test.getAnswerA());
        values.put(CL_aswB, test.getAnswerB());
        values.put(CL_aswC, test.getAnswerC());
        values.put(CL_aswD, test.getAnswerD());
        values.put(CL_aswT, test.getAnswerTrue());
        long id = db.insert(TEST, null, values);
        db.close();
        return id;
    }

    // Update Test
    public int updateTest(Test test) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CL_cat, test.getCategory());
        values.put(CL_Ques, test.getQuestion());
        values.put(CL_aswA, test.getAnswerA());
        values.put(CL_aswB, test.getAnswerB());
        values.put(CL_aswC, test.getAnswerC());
        values.put(CL_aswD, test.getAnswerD());
        values.put(CL_aswT, test.getAnswerTrue());
        int i = db.update(TEST, values, CL_id_test + " = ?",
                new String[]{String.valueOf(test.getId())});
        db.close();
        return i;

    }

    // Delete Test
    public int deleteTest(int a) {
        SQLiteDatabase db = this.getWritableDatabase();
        int d = db.delete(TEST, CL_id_test + " = ?",
                new String[]{String.valueOf(a)});

        db.close();
        return d;

    }

    public ArrayList<String> getAllTestLesson() {
        ArrayList<String> arr = new ArrayList<String>();
        String query = "SELECT DISTINCT category  FROM " + TEST;
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

    public Test getTest(String string) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TEST, new String[]{CL_id_test, CL_cat, CL_Ques,
                        CL_aswA, CL_aswB, CL_aswC, CL_aswD, CL_aswT}, CL_id_test + " = ?", new String[]{string + ""}, null,
                null, null, null);
        Test test = null;
        if (cursor.moveToFirst()) {
            do {
//				test_english = new Test();
                test.setId(Integer.parseInt(cursor.getString(0)));
                test.setCategory(cursor.getString(1));
                test.setQuestion(cursor.getString(2));
                test.setAnswerA(cursor.getString(3));
                test.setAnswerB(cursor.getString(4));
                test.setAnswerC(cursor.getString(5));
                test.setAnswerD(cursor.getString(6));
                test.setAnswerTrue(cursor.getString(7));
            } while (cursor.moveToNext());
        }
        db.close();
        return test;
    }

    public ArrayList<Test> getTestLesson(String string) {
        ArrayList<Test> arrayList = new ArrayList<Test>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TEST, new String[]{CL_id_test, CL_cat, CL_Ques,
                        CL_aswA, CL_aswB, CL_aswC, CL_aswD, CL_aswT}, CL_cat + " = ?", new String[]{string + ""}, null,
                null, null, null);
        Test test = null;
        if (cursor.moveToFirst()) {
            do {
                test = new Test();
                test.setId(Integer.parseInt(cursor.getString(0)));
                test.setCategory(cursor.getString(1));
                test.setQuestion(cursor.getString(2));
                test.setAnswerA(cursor.getString(3));
                test.setAnswerB(cursor.getString(4));
                test.setAnswerC(cursor.getString(5));
                test.setAnswerD(cursor.getString(6));
                test.setAnswerTrue(cursor.getString(7));
                arrayList.add(test);
            } while (cursor.moveToNext());
        }
        db.close();
        return arrayList;
    }

    public Test getTestbyId(int id) {
        ArrayList<Test> arrayList = new ArrayList<Test>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TEST, new String[]{CL_id_test, CL_cat, CL_Ques,
                        CL_aswA, CL_aswB, CL_aswC, CL_aswD, CL_aswT}, CL_id_test + " = ?", new String[]{id + ""}, null,
                null, null, null);
        Test test = null;
        if (cursor.moveToFirst()) {
            do {
//                test_english = new Test();
                test.setId(Integer.parseInt(cursor.getString(0)));
                test.setCategory(cursor.getString(1));
                test.setQuestion(cursor.getString(2));
                test.setAnswerA(cursor.getString(3));
                test.setAnswerB(cursor.getString(4));
                test.setAnswerC(cursor.getString(5));
                test.setAnswerD(cursor.getString(6));
                test.setAnswerTrue(cursor.getString(7));
                arrayList.add(test);
            } while (cursor.moveToNext());
        }
        db.close();
        return test;
    }


    public ArrayList<Test> getAllTest() {
        ArrayList<Test> arrayList = new ArrayList<Test>();
        String query = "SELECT  * FROM " + TEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Test test = null;
        if (cursor.moveToFirst()) {
            do {
                test = new Test();
                test.setId(Integer.parseInt(cursor.getString(0)));
                test.setCategory(cursor.getString(1));
                test.setQuestion(cursor.getString(2));
                test.setAnswerA(cursor.getString(3));
                test.setAnswerB(cursor.getString(4));
                test.setAnswerC(cursor.getString(5));
                test.setAnswerD(cursor.getString(6));
                test.setAnswerTrue(cursor.getString(7));
                arrayList.add(test);
            } while (cursor.moveToNext());
        }
        db.close();
        return arrayList;
    }
    /*METHODS - TIEN*/
    // Insert extra
    public long insertExtra(Extra extra) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CL_Ten, extra.getTen());
        values.put(CL_Noidung, extra.getNoidung());
        long id = db.insert(EXTRA, null, values);
        db.close();
        return id;
    }

    // Update Extra
    public int updateExtra(Extra extra) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CL_Ten, extra.getTen());
        values.put(CL_Noidung, extra.getNoidung());
        int i = db.update(EXTRA, values, CL_id_extra + " = ?",
                new String[]{String.valueOf(extra.getId())});
        db.close();
        return i;
    }

    // Delete Extra by id
    public int deleteExtra(int a) {
        SQLiteDatabase db = this.getWritableDatabase();
        int d = db.delete(EXTRA, CL_id_extra + " = ?",
                new String[]{String.valueOf(a)});
        db.close();
        return d;
    }

    public Extra getExtra(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(EXTRA, new String[]{CL_id_extra, CL_Ten, CL_Noidung}, CL_id_extra + " = ?", new String[]{id + ""}, null,
                null, null, null);
        Extra extra = null;
        if (cursor.moveToFirst()) {
            do {
                extra = new Extra();
                extra.setId(Integer.parseInt(cursor.getString(0)));
                extra.setTen(cursor.getString(1));
                extra.setNoidung(cursor.getString(2));
            } while (cursor.moveToNext());
        }
        db.close();
        return extra;
    }

    public Extra getExtrabyId(int id) {
        ArrayList<Extra> arrayList = new ArrayList<Extra>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(EXTRA, new String[]{CL_id_extra, CL_Ten, CL_Noidung}, CL_id_extra + " = ?", new String[]{id + ""}, null,
                null, null, null);
        Extra story = null;
        if (cursor.moveToFirst()) {
            do {
                story = new Extra();
                story.setId(Integer.parseInt(cursor.getString(0)));
                story.setTen(cursor.getString(1));
                story.setNoidung(cursor.getString(2));
                arrayList.add(story);
            } while (cursor.moveToNext());
        }
        db.close();
        return story;
    }

    public ArrayList<Extra> getAllExtra() {
        ArrayList<Extra> arrayList = new ArrayList<Extra>();
        String query = "SELECT  * FROM " + EXTRA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Extra story = null;
        if (cursor.moveToFirst()) {
            do {
                story = new Extra();
                story.setId(Integer.parseInt(cursor.getString(0)));
                story.setTen(cursor.getString(1));
                story.setNoidung(cursor.getString(2));
                arrayList.add(story);
            } while (cursor.moveToNext());
        }
        db.close();
        return arrayList;
    }
}
