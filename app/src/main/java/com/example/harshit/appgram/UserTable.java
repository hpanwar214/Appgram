package com.example.harshit.appgram;


import android.database.sqlite.SQLiteDatabase;

import static java.sql.Types.INTEGER;


public class UserTable {
     String table_name="User_Table";
     String id="id";
     String name="name";
     String username="username";
     String email="email";
     String post="post";
     String likes="likes";
     String followers="followers";
     String password="password";


    public UserTable(SQLiteDatabase sqLiteDatabase)
    {
        String create_table="CREATE TABLE "+ table_name +
                            "( "+name+" VARCHAR(30) not null,"+
                            ""+email +" VARCHAR(40) PRIMARY KEY," +
                            ""+username+" varchar(50),"+
                            ""+password+" varchar(50) ,"+
                            ""+followers+" varchar(5) not null ,"+
                            ""+likes+" varchar(5) not null,"+
                            ""+post+" varchar(5) not null);";
        sqLiteDatabase.execSQL(create_table);
    }
    public UserTable(){

    }
    public UserTable(String table_name,String name,String email,String password, String username,String followers,String likes,String post)
    {
        this.table_name=table_name;
        this.name=name;
        this.email=email;
        this.password=password;
        this.username=username;
        this.followers=followers;
        this.likes=likes;
        this.post=post;

    }
    public UserTable(String name,String email, String username,String followers,String likes,String post)
    {
        this.name=name;
        this.email=email;
        this.username=username;
        this.followers=followers;
        this.likes=likes;
        this.post=post;

    }


}
