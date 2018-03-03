package com.cioc.report;

import android.content.Context;
import android.content.Intent;
import android.graphics.EmbossMaskFilter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

/**
 * Created by Amit on 2/20/2018.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{
    private List<Integer> mDataSet;
    private Context mContext;
    private Random mRandom = new Random();
    private static final String DRAWABLE_RESOURE = "resource";
    public CardAdapter(Context context, List<Integer> list){
        mDataSet = list;
        mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public ImageButton mRemoveButton;
        public RelativeLayout mRelativeLayout;
        public ViewHolder(View v){
            super(v);
            mImageView = v.findViewById(R.id.card_image);
            mRemoveButton = v.findViewById(R.id.ib_remove);
            mRelativeLayout = v.findViewById(R.id.rl);
        }
    }


    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        // Create a new View
        View v = LayoutInflater.from(mContext).inflate(R.layout.custom_view,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        holder.mImageView.setImageResource((Integer)mDataSet.get(position));
        // Set a click listener for TextView
        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer images = mDataSet.get(position);
                Toast.makeText(mContext,images,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, ImageDetailsActivity.class);
                intent.putExtra(DRAWABLE_RESOURE, images);
                mContext.startActivity(intent);
            }
        });

        // Set a click listener for item remove button
        holder.mRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the clicked item label
                Integer itemLabel = mDataSet.get(position);

                // Remove the item on remove/button click
                mDataSet.remove(position);

                notifyItemRemoved(position);

                notifyItemRangeChanged(position,mDataSet.size());

                // Show the removed item label
                Toast.makeText(mContext,"Removed : " + itemLabel,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount(){
        return mDataSet.size();
    }
}