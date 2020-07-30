package com.example.harshit.appgram;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String dbName="DIR.db";
    //public String table_name="user_tab";

    public DatabaseHelper(Context context)
    {
        super(context,dbName,null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        new UserTable(sqLiteDatabase);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addUserdata(UserTable userTable)
    {
        UserTable keyUserName=new UserTable();

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        try
        {
            contentValues.put(keyUserName.name,userTable.name);
            contentValues.put(keyUserName.email,userTable.email);
            contentValues.put(keyUserName.password,userTable.password);
            contentValues.put(keyUserName.username,userTable.username);
            contentValues.put(keyUserName.followers,userTable.followers);
            contentValues.put(keyUserName.likes,userTable.likes);
            contentValues.put(keyUserName.post,userTable.post);
            sqLiteDatabase.insert(keyUserName.table_name,null,contentValues);
            return true;

        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public  Cursor getDataFromUser()
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        UserTable keyUserName=new UserTable();
        return sqLiteDatabase.rawQuery("select * from "+ keyUserName.table_name+";",null);
    }


    public boolean updatePass(String email,String password)
    {
        ContentValues cv=new ContentValues();
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        UserTable userTable=new UserTable();
        try{
            cv.put(userTable.password,password);
            sqLiteDatabase.update(userTable.password,cv,""+userTable.email+"= ?",new String[]{email});
        }catch (Exception e){e.printStackTrace();return true;}
        return false;
    }
    public Cursor selector(String email,String password)
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        UserTable keyUser=new UserTable();
        String q="SELECT email ,password FROM User_Table WHERE email='"+email+"' and password='"+password+"';";
        Cursor c=sqLiteDatabase.rawQuery(q,null);

        return c;

    }

}




