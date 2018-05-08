package vn.edu.tdc.hoctienganh.tudien;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TuVungHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "luyenthi.sqlite";
    public static final String TABLE_NAME = "translate";
    public static final String KEY_ID = "_id";
    public static final String KEY_WORD = "word";
    public static final String KEY_MEAN = "mean";
    public static final String KEY_PRONOUNCE = "pronounce";
    public static final String KEY_IMAGE = "image";


    public TuVungHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "_id = ?",new String[] {id});
    }
}
