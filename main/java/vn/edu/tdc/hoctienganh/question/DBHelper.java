package vn.edu.tdc.hoctienganh.question;

/**
 * Created by NguyenTuan on 11/10/2016.
 */

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static String DB_PATH = "";
    private static final String DB_NAME = "luyenthi.sqlite";
    private SQLiteDatabase myDataBase;
    private final Context myContext;
    private static final int DATABASE_VERSION = 1;

    private static DBHelper mDBConnection;

    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
        DB_PATH = "/data/data/"
                + context.getApplicationContext().getPackageName()
                + "/databases/";
        // The Android's default system path of your application database is
        // "/data/data/mypackagename/databases/"

    }

    /**
     * getting Instance
     * @param context
     * @return DBAdapter
     */
    public static synchronized DBHelper getDBAdapterInstance(Context context) {
        if (mDBConnection == null) {
            mDBConnection = new DBHelper(context);
        }
        return mDBConnection;
    }

    /**
     * Creates an empty database on the system and rewrites it with your own database.
     **/
    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase(); //kiem tra db

        if (dbExist) {
            //khong lam gi ca, database da co roi
//            copyDataBase();
        } else {
            this.getReadableDatabase();
            try {
                copyDataBase(); //chep du lieu
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */

    public boolean checkDataBase() {
        SQLiteDatabase checkDB = null;

        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            //database chua ton tai
        }

        if (checkDB != null)
            checkDB.close();

        return checkDB != null ? true : false;
    }




/*public boolean checkDataBase()
{
File dbFile = new File(DB_PATH + DB_NAME);
return dbFile.exists();
}*/


    /**
     * Copies your database from your local assets-folder to the just created
     * empty database in the system folder, from where it can be accessed and
     * handled. This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException {

        //mo db trong thu muc assets nhu mot input stream
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        //duong dan den db se tao
        String outFileName = DB_PATH + DB_NAME;

        //mo db giong nhu mot output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //truyen du lieu tu inputfile sang outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        //Dong luon
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    /**
     * Open the database
     * @throws SQLException
     */
    public void openDataBase(){
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }



    public void deleteDataBase() {
        String myPath = DB_PATH + DB_NAME;
        SQLiteDatabase.deleteDatabase(new File(myPath));
    }

    /**
     * Close the database if exist
     */
    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }

    /**
     * Call on creating data base for example for creating tables at run time
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    /**
     * can used for drop tables then call onCreate(db) function to create tables again - upgrade
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    public  Cursor QueryData(String query){
        return myDataBase.rawQuery(query,null);
    }



}

