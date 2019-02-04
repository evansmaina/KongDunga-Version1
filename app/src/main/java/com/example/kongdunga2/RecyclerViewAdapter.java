package com.example.kongdunga2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<String> mImagenames = new ArrayList<>();
    private ArrayList<Integer> mImages = new ArrayList<>();
    private ArrayList<String> mPrice = new ArrayList<>();
    private ArrayList<String> mOrder = new ArrayList<>();

    public RecyclerViewAdapter(Context mContext, ArrayList<String> mImagenames, ArrayList<Integer> mImages, ArrayList<String> mPrice, ArrayList<String> mOrder) {
        this.mContext = mContext;
        this.mImagenames = mImagenames;
        this.mImages = mImages;
        this.mPrice = mPrice;
        this.mOrder = mOrder;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.menu_listitems, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.textView.setText(mImagenames.get(i));
        Glide.with(mContext).asBitmap().load(mImages.get(i)).into(viewHolder.imageView);
        viewHolder.price.setText(mPrice.get(i));
        viewHolder.order.setText(mOrder.get(i));
        viewHolder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,mImagenames.get(i),Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(mContext,Display.class);
                intent.putExtra("image",mImages.get(i));
                intent.putExtra("name",mImagenames.get(i));
                intent.putExtra("price",mPrice.get(i));
                intent.putExtra("order",mOrder.get(i));
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mImagenames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        CircleImageView imageView;
        TextView textView,price,order;
        RelativeLayout parent_layout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image1);
            textView = itemView.findViewById(R.id.foodName);
            price=itemView.findViewById(R.id.price);
            order=itemView.findViewById(R.id.order);
            parent_layout=itemView.findViewById(R.id.parent_layout);

        }
    }
}
