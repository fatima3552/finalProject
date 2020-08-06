package com.example.project3;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Users.db";
    public static final String TABLE = "handyman";
    public static final String COL_11 = "ID";
    public static final String COL_22 = "NAME";
    public static final String COL_33 = "PHONE";
     public static final String COL_4 = "CATEGORY";
    public static final String COL_5 = "ADDRESS";
    public static final String COL_6 = "PASSWORD";
    public static final String COL_7 = "AREAS";
    public static final String COL_8 = "CNIC";
    public static final String COL_9 = "DIS";
    public static final String COL_10 = "GENDER";




    public static final String TABLE_NAM = "admin_table";
    //public static final String COL_1 = "ID";
    public static final String COL_2 = "EMAIL";
    public static final String COL_3 = "PASSWORD";

    public boolean insertData(String name,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
       ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, password);

        long result = db.insert(TABLE_NAM, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
    public boolean insertDataa( String NAME , String AREAS , String PASSWORD , String CNIC  , String ADDRESS,String PHONE ,String dis,String gender , String catago) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(COL_22, NAME);
        contentValues1.put(COL_33, PHONE);
        contentValues1.put(COL_5,ADDRESS);
        contentValues1.put(COL_6, PASSWORD);
        contentValues1.put(COL_7,AREAS);
        contentValues1.put(COL_8, CNIC);
        contentValues1.put(COL_9, dis);
        contentValues1.put(COL_4, catago);
        contentValues1.put(COL_10, gender);

        long result = db.insert(TABLE, null, contentValues1);
        if (result == -1)
            return false;
        else
            return true;
    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
       Cursor res = db.rawQuery("select * from " + TABLE_NAM, null);
        return res;
    }
    public Cursor getAlldata() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE, null);
        return res;
    }

    private static final String CREATE_TBL_USERS = "CREATE TABLE "
            + DatabaseContract.Users.TABLE_NAME + " ("
            + DatabaseContract.Users._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DatabaseContract.Users.COL_NAME + " TEXT , "
            + DatabaseContract.Users.COL_PHONENUMBER+" TEXT , "
            +DatabaseContract.Users.COL_EMAIL+" TEXT , "
            +DatabaseContract.Users.COL_PASSWORD+" TEXT , "
            +DatabaseContract.Users.COL_CONFIRMPASSWORD+" TEXT , "
            + DatabaseContract.Users. COL_CNIC+ " TEXT )";





    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TBL_USERS);
        db.execSQL("create table " + TABLE_NAM + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,EMAIL TEXT,PASSWORD TEXT)");
      
        db.execSQL("create table " + TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,AREAS TEXT ,PASSWORD TEXT ,CNIC TEXT,ADDRESS TEXT,PHONE TEXT,DIS TEXT,GENDER TEXT,CATEGORY TEXT)");
        // TODO Auto-generated method stub
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);

    }
    public Integer delete12Data ( String id) {

        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE, "CNIC= ?",new String[] {id});
    }




}

