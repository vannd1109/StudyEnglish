package vn.edu.tdc.hoctienganh.tudien;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import vn.edu.tdc.hoctienganh.question.DBHelper;

public class WordModify {
    TuVungHelper tuVungHelper;

    public WordModify(TuVungHelper tuVungHelper) {
        this.tuVungHelper = tuVungHelper;
    }

    //PT Them
    public void insert(TuVung tuVung){
        //Mo ket noi den Database
        SQLiteDatabase db= tuVungHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TuVungHelper.KEY_WORD,tuVung.getTu());
        values.put(TuVungHelper.KEY_MEAN, tuVung.getNghia());
        values.put(TuVungHelper.KEY_PRONOUNCE, tuVung.getPhatam());
        values.put(TuVungHelper.KEY_IMAGE, tuVung.getHinhanh());

        db.insert(TuVungHelper.TABLE_NAME,null,values);
        db.close();
    }

    //PT Sua
    public void update(TuVung tuVung){
        //Mo ket noi den Database
        SQLiteDatabase db= tuVungHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TuVungHelper.KEY_WORD,tuVung.getTu());
        values.put(TuVungHelper.KEY_MEAN, tuVung.getNghia());
        values.put(TuVungHelper.KEY_PRONOUNCE, tuVung.getPhatam());
        values.put(TuVungHelper.KEY_IMAGE, tuVung.getHinhanh());

        db.update(TuVungHelper.TABLE_NAME,values, TuVungHelper.KEY_ID + "=?",new String[]{String.valueOf(tuVung.getId())});
        db.close();

    }

    //PT xoa
    public void delete(int _id){
        //Mo ket noi den Database
        SQLiteDatabase db= tuVungHelper.getWritableDatabase();
        db.delete(TuVungHelper.TABLE_NAME,TuVungHelper.KEY_ID+"=?",new String[]{String.valueOf(_id)});
        db.close();
    }

}
