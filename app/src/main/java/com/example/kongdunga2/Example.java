package com.example.kongdunga2;

import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Example extends AppCompatActivity {

TextView foodtxt,priceTxt;
CircleImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        foodtxt=findViewById(R.id.foodview);
        priceTxt=findViewById(R.id.pricefood);
        imageView=findViewById(R.id.imagefood);

        Bundle extras = getIntent().getExtras();
        byte[] b = extras.getByteArray("picture");
        Bitmap bmp = BitmapFactory.decodeByteArray(b, 0, b.length);

        String foodview=getIntent().getStringExtra("foodname");
        String priceview=getIntent().getStringExtra("foodprice");

        foodtxt.setText(foodview);
        priceTxt.setText(priceview);
        imageView.setImageBitmap(bmp);


    }

    public void goViewCode(View view){

initNotification();


    }

    private void initNotification(){

       /* AlertDialog.Builder popUp = new AlertDialog.Builder(this);
        popUp.setTitle("This is Your Order Code");
        popUp.setCancelable(false);
        popUp.setIcon(R.drawable.money);
        popUp.setMessage("7793020");
        popUp.setNegativeButton("exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        popUp.create().show();*/

       int notificationId=0;
        NotificationCompat.Builder notif= new NotificationCompat.Builder(this);
        notif.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.money));
        notif.setContentText("567890");
        notif.setContentTitle("This is your Order code");
        notif.setAutoCancel(true);
        notif.setSmallIcon(R.drawable.money);
        notif.setDefaults(NotificationCompat.DEFAULT_ALL);

        Uri follow= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        notif.setSound(follow);
        NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.notify(notificationId,notif.build());



    }
}
