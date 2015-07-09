package com.agroho.rezaul.listviewsqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by ASUS on 7/9/2015
 * This is Database Helper class. All Database Related Functions
 * like table Creation, Insert, Read data will be implemented here
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    //Database Name
    public static final String DB_NAME = "book_db";
    //Database Version name.
    public static final int DB_VERSION = 1;
    //Table name
    public static final String BOOK_TABLE = "book_info";
    //ID column (This the best practice to use _id)
    public static final String ID_FIELD = "_id";
    //Name Column
    public static final String NAME_FIELD = "name";
    // Price column
    public static final String PRICE_FIELD = "price";
    //This is just tag for debug. (You can ignore this)
    public static final String TAG = "BookDBModel";

    //This is the Create Table SQL Query. Make sure you check it right when you code by yourself. This can give you hard time!
    public static final String BookInfo_Table_Create_SQL = "CREATE TABLE " +
            BOOK_TABLE+" ("+ID_FIELD+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME_FIELD+" TEXT NOT NULL, "+ PRICE_FIELD+" REAL NOT NULL);";

    //DatabaseHelper Constructor
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //Whenever you start your application for the first time this onCreate create the Table for you
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BookInfo_Table_Create_SQL);
        Log.e("Table Created", BookInfo_Table_Create_SQL);
    }

    //Needed when Database upgrade required.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Insert Data
    public long insertBookInfo(Book book){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_FIELD, book.getBook_name());
        values.put(PRICE_FIELD, book.getBook_price());

        long inserted = db.insert(BOOK_TABLE,null,values);
        db.close();

        return inserted;
    }

    //Getting data
    public ArrayList<Book> getAllBooksInfo(){
        ArrayList<Book> allBooksInfo = new ArrayList<Book>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(BOOK_TABLE,null,null,null,null,null,null);

        if (cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                int id = cursor.getInt(cursor.getColumnIndex(ID_FIELD));
                String Name = cursor.getString(cursor.getColumnIndex(NAME_FIELD));
                Double Price = cursor.getDouble(cursor.getColumnIndex(PRICE_FIELD));

                Book b = new Book(id,Name,Price);
                allBooksInfo.add(b);
                cursor.moveToNext();
            }
        }

        cursor.close();
        db.close();

        return allBooksInfo;
    }


}
