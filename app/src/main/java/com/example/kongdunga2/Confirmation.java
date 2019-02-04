package com.example.kongdunga2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Confirmation extends AppCompatActivity {

    TextView userTxt,mobileTxt,passTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        userTxt=findViewById(R.id.txtUser);
        mobileTxt=findViewById(R.id.txtMobile);
        passTxt=findViewById(R.id.txtpass);

        Intent intent=getIntent();
        String user=intent.getStringExtra("user");
        String mobile=intent.getStringExtra("mobile");
        String pass=intent.getStringExtra("password");

        userTxt.setText(user);
        mobileTxt.setText(mobile);
        passTxt.setText(pass);

    }

    public void goMenu(View view){

        Intent menu= new Intent(Confirmation.this,MainMenu.class);
        startActivity(menu);

    }

    public void goBack(View view){

        Intent edit=new Intent(Confirmation.this,Information.class);
        startActivity(edit);
    }



}
