package com.example.kongdunga2;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

public class Information extends AppCompatActivity {

    TextInputEditText username2, password2, mobile1;
    Button btnnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        username2 = findViewById(R.id.usernameEdTxt2);
        password2 = findViewById(R.id.passwordEdTxt2);
        mobile1=findViewById(R.id.mobileEdTxt1);
        btnnext = findViewById(R.id.btnNxt);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailsCheck();
            }
        });


    }

 private void detailsCheck(){

        String username=username2.getText().toString().trim();
        String mobile=mobile1.getText().toString().trim();
        String password =password2.getText().toString().trim();

        if(checkname(username)&&checkmobile(mobile)&&checkpass(password)){

            Intent inten=new Intent(Information.this,Confirmation.class);
            inten.putExtra("user",username);
            inten.putExtra("mobile",mobile);
            inten.putExtra("password",password);
            startActivity(inten);


        }
    }

    private boolean checkname(String name){

        if (TextUtils.isEmpty(name)){

            username2.setError("enter name");
            return false;
        }
        return true;
    }

    private boolean checkmobile(String mobile){

        if (TextUtils.isEmpty(mobile)){

            username2.setError("enter mobile");
            return false;
        }
        return true;
    }

    private boolean checkpass(String pass){

        if (TextUtils.isEmpty(pass)){

            username2.setError("enter pass");
            return false;
        }
        return true;
    }

}
