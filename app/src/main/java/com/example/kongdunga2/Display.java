package com.example.kongdunga2;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;

public class Display extends AppCompatActivity {
    TextView name, price, order;
    ImageView imageDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        imageDisplay = findViewById(R.id.imageDisplay);
        name = findViewById(R.id.foodDisplay);
        price = findViewById(R.id.priceDisplay);
        order = findViewById(R.id.orderDisplay);

        Intent intent = getIntent();
        if (getIntent().hasExtra("image") && getIntent().hasExtra("name")
                && getIntent().hasExtra("price") && getIntent().hasExtra("order")) {
            String mName = getIntent().getStringExtra("name");
            String mPrice = getIntent().getStringExtra("price");
            String mOrder = getIntent().getStringExtra("order");
            Integer mImages = getIntent().getIntExtra("image", -1);

            name.setText(mName);
            price.setText(mPrice);
            order.setText(mOrder);

            Glide.with(this).asBitmap().load(mImages).into(imageDisplay);

        }

    }

    public void onPurchase(View view) {
        initShowpopUp();


    }

    private void initShowpopUp() {

        AlertDialog.Builder popUp = new AlertDialog.Builder(this);
        popUp.setTitle("Select pay method!");
        popUp.setCancelable(false);
        popUp.setIcon(R.drawable.money);
        popUp.setMessage("Lipa na Mpesa or cash Delivery?");
        popUp.setNegativeButton("Mpesa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getApplicationContext(),"request succesfull!",Toast.LENGTH_LONG).show();

                String foodname=name.getText().toString();
                String pricefood=price.getText().toString();

                Drawable drawable=imageDisplay.getDrawable();
                Bitmap bitmap= ((BitmapDrawable)drawable).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] b = baos.toByteArray();


                Intent intent= new Intent(Display.this,Example.class);
                intent.putExtra("foodname",foodname);
                intent.putExtra("picture", b);
                intent.putExtra("foodprice",pricefood);
                startActivity(intent);

            }
        });

        popUp.setPositiveButton("cash", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getApplicationContext(),"request succesfull!"+"\nremember to come with cash!",Toast.LENGTH_LONG).show();
                String foodname=name.getText().toString();
                String pricefood=price.getText().toString();

                Drawable drawable=imageDisplay.getDrawable();
                Bitmap bitmap= ((BitmapDrawable)drawable).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] b = baos.toByteArray();


                Intent intent= new Intent(Display.this,Example.class);
                intent.putExtra("foodname",foodname);
                intent.putExtra("picture", b);
                intent.putExtra("foodprice",pricefood);
                startActivity(intent);



            }
        });

        popUp.setNeutralButton("exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();

            }
        });


        popUp.create().show();
    }
}
