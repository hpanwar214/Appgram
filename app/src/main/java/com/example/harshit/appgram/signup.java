package com.example.harshit.appgram;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class signup extends AppCompatActivity
{
    DatabaseHelper databaseHelper=new DatabaseHelper(this);
    private EditText name,email,password,username,follower,likes,posts;
    private Button signup;
    String tag2="Succesfully registered";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name=(EditText) findViewById(R.id.name);
        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);
        username=(EditText) findViewById(R.id.username);
        likes=(EditText)findViewById(R.id.likes);
        follower=(EditText)findViewById(R.id.followers);
        posts=(EditText) findViewById(R.id.posts);

        signup=(Button) findViewById(R.id.signup);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty()||
                        email.getText().toString().isEmpty()||
                        password.getText().toString().isEmpty()||
                        username.getText().toString().isEmpty()||
                        follower.getText().toString().isEmpty()||
                        likes.getText().toString().isEmpty()||
                        posts.getText().toString().isEmpty())
                {
                    Toast.makeText(signup.this, "Some fields are left empty...", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    UserTable inputData=new UserTable("User_Table",name.getText().toString(),email.getText().toString(),password.getText().toString()
                            ,username.getText().toString(), follower.getText().toString(),likes.getText().toString(),posts.getText().toString());
                    if(databaseHelper.addUserdata(inputData))
                    {

                        Toast.makeText(signup.this,"data stored",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(signup.this,Dashboard.class));
                    }
                    else{
                        Toast.makeText(signup.this,"data not stored",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }






}