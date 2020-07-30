package com.example.harshit.appgram;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;

import java.io.File;
import java.util.ArrayList;



import static android.os.Build.VERSION_CODES.M;

public class Dashboard extends AppCompatActivity {
    private SearchView mSearchView;
    private RecyclerView influencer;
    private FloatingActionButton floatingActionButton;
    DatabaseHelper databaseHelper;
    Cursor  profile;
    ArrayList<UserTable> userTables = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        mSearchView = findViewById(R.id.searchView2);
        influencer = findViewById(R.id.recyclerView);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        databaseHelper = new DatabaseHelper(this);
        profile = databaseHelper.getDataFromUser();
        influencer.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        if(profile!=null)
        {
            if(profile.moveToFirst()) {
                do {
                    String name = profile.getString(0).toUpperCase();
                    String email = profile.getString(1);
                    String username = profile.getString(2);
                    String follower = profile.getString(4);
                    String likes = profile.getString(5);
                    String posts = profile.getString(6);
                    UserTable users = new UserTable(name, email, username, follower, likes, posts);
                    userTables.add(users);
                } while (profile.moveToNext());
            }
            influencer.setAdapter(new Influencer(Dashboard.this,userTables));
        }




    }



}