package vn.edu.tdc.hoctienganh.score;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import vn.edu.tdc.hoctienganh.question.DBHelper;
import vn.edu.tdc.hoctienganh.question.Question;

public class ScoreController {
    private DBHelper dbHelper;

    public ScoreController(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void insertScore(String name, int score, String room) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("score", score);
        values.put("room", room);
        db.insert("tbscore", null, values);
        db.close();
    }

    //Lấy danh sách câu hỏi
    public Cursor getScore() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("tbscore", // ten bang
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
