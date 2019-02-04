package com.example.kongdunga2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity {

    public ArrayList<String> mNames= new ArrayList<>();
    public ArrayList<Integer> mImages=new ArrayList<>();
    public ArrayList<String> mPrice=new ArrayList<>();
    public ArrayList<String> mOrder=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        initBitmapas();
    }

    public void initBitmapas (){

        mNames.add("Bhajia");
        mImages.add(R.drawable.bajia);
        mPrice.add("Price:@ 50/-");
        mOrder.add("remaining order: 20 packs");

        mNames.add("Chapati");
        mImages.add(R.drawable.chapati);
        mPrice.add("Price:@ 10/-");
        mOrder.add("remaining order: 220");


        mNames.add("Chapati_nyama");
        mImages.add(R.drawable.chapati_nyama);
        mPrice.add("Price:@ 50/-");
        mOrder.add("remaining order: 150 dishes");

        mNames.add("Chips");
        mImages.add(R.drawable.chips);
        mPrice.add("Price:@ 80/-");
        mOrder.add("remaining order: 250 packs");

        mNames.add("Githeri");
        mImages.add(R.drawable.githerii);
        mPrice.add("Price:@ 40/-");
        mOrder.add("remaining order: 120 dishes");

        mNames.add("Kachumbari");
        mImages.add(R.drawable.kachumbari);
        mPrice.add("Price:@ 10/-");
        mOrder.add("remaining order: always available");

        mNames.add("Kuku");
        mImages.add(R.drawable.kuku);
        mPrice.add("Price:@ 150/-");
        mOrder.add("remaining order: 150 full packs");

        mNames.add("Mchele mix");
        mImages.add(R.drawable.mchele_mix_sinia);
        mPrice.add("Price:@ 250/-");
        mOrder.add("remaining order:100 dishes");

        mNames.add("Mokimo");
        mImages.add(R.drawable.mokimo_green);
        mPrice.add("Price:@ 40/-");
        mOrder.add("remaining order: 100 plates");

        mNames.add("Pilau");
        mImages.add(R.drawable.pilau2);
        mPrice.add("Price:@ 80/-");
        mOrder.add("remaining order: 80 plates");

        mNames.add("Rice");
        mImages.add(R.drawable.rice);
        mPrice.add("Price:@ 50/-");
        mOrder.add("remaining order: 150 plates");

        mNames.add("Samaki");
        mImages.add(R.drawable.samaki);
        mPrice.add("Price:@ 60/-");
        mOrder.add("remaining order: 30 fish");

        mNames.add("Samosa");
        mImages.add(R.drawable.samosa_poa);
        mPrice.add("Price:@ 15/-");
        mOrder.add("remaining order: 20 samosa");

        mNames.add("Stew Nyama");
        mImages.add(R.drawable.stew_nyama);
        mPrice.add("Price:@ 60/-");
        mOrder.add("remaining order: 100 plates");

        mNames.add("Ugali");
        mImages.add(R.drawable.ugali1);
        mPrice.add("Price:@ 40/-");
        mOrder.add("remaining order: 120 plates");

        mNames.add("Ugali Mayai");
        mImages.add(R.drawable.ugali_mayai);
        mPrice.add("Price:@ 60/-");
        mOrder.add("remaining order: 80 plates");

        mNames.add("Ugali Nyama_choma");
        mImages.add(R.drawable.ugali_nyama_choma);
        mPrice.add("Price:@ 250/-");
        mOrder.add("remaining order: 20 plates");

        mNames.add("Ugali Samaki");
        mImages.add(R.drawable.ugali_samaki);
        mPrice.add("Price:@ 100/-");
        mOrder.add("remaining order: 25 plates");

        mNames.add("Veg");
        mImages.add(R.drawable.veg);
        mPrice.add("Price:@ 20/-");
        mOrder.add("remaining order: 120 plates");

        mNames.add("Waruu_stew");
        mImages.add(R.drawable.waruu_stew);
        mPrice.add("Price:@ 20/-");
        mOrder.add("remaining order: 120 plates");


        initRecyclerView();

    }

    public void initRecyclerView(){
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapt= new RecyclerViewAdapter(this,mNames,mImages,mPrice,mOrder);
        recyclerView.setAdapter(adapt);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
