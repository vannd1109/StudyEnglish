package vn.edu.tdc.hoctienganh.chude.animal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import vn.edu.tdc.hoctienganh.question.DBHelper;

public class ChuDeController {
    private DBHelper dbHelper;

    public ChuDeController(Context context) {
        dbHelper= new DBHelper(context);
    }

    //Lấy danh sách câu hỏi
    public ArrayList<Animal> getChuDe(int idChude){
        ArrayList<Animal> lsData = new ArrayList<Animal>();
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM animal WHERE idChude = '"+ idChude +"'",null);
        cursor.moveToFirst();
        do {
            Animal item;
            item= new Animal(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getInt(5)
            );
            lsData.add(item);
        }while (cursor.moveToNext());
        return lsData;
    }
}
