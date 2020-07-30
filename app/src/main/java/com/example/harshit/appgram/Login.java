package com.example.harshit.appgram;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button login,signup,insta;
    private EditText email,password;
    DatabaseHelper dbs=new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=(Button) findViewById(R.id.login);
        signup=(Button) findViewById(R.id.signup);
        insta=(Button) findViewById(R.id.insta);

        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);
        final Context context=Login.this;

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor csr= dbs.selector(email.getText().toString(),password.getText().toString());

                if(csr!=null)
                {
                    if(csr.moveToFirst()){
                        while(csr.moveToNext()) {
                            String email_db = csr.getString(0);
                            String password_db = csr.getString(1);
                            Toast.makeText(context, email_db + " " + password_db, Toast.LENGTH_SHORT).show();
                            if (email.equals(email_db) && password.equals(password_db)) {
                                Toast.makeText(context, "Logged In Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(context, Dashboard.class));
                            } else {
                                Toast.makeText(context, "Email or Password does not match", Toast.LENGTH_LONG).show();
                                break;
                            }
                        }
                    }


                }
                else
                {
                        Toast.makeText(context,"Email Not found",Toast.LENGTH_LONG).show();

                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,signup.class));
            }
        });



    }
}
