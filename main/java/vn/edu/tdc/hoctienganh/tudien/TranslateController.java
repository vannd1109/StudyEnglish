package vn.edu.tdc.hoctienganh.tudien;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import vn.edu.tdc.hoctienganh.question.DBHelper;

public class TranslateController {
    private DBHelper dbHelper;

    public TranslateController(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void insertWord(String word, String mean) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("word", word);
        values.put("mean", mean);
        db.insert("translate", null, values);
        db.close();
    }

    //Lấy danh sách từ
    public Cursor getWord() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("translate", // ten bang
                null, //Danh sach cot can lay
                null, //Dieu kien where
                null, // Doi so dieu kien where
                null, // Bieu thuc Groupby
                null, //Bieu thuc Having
                "_id DESC", // Bieu thuc oder by
                null
        );
        if (cursor != null) {
            cursor.moveToFirst();
        }

        return cursor;
    }
}
