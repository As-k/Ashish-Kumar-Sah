package com.cioc.report;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ashish on 2/21/2018.
 */

public class ActiveAdapter extends RecyclerView.Adapter<ActiveAdapter.MyHolder> {//implements View.OnClickListener

    public static String state_names[] = {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh","Delhi", "Goa","Gujarat","Haryana","Himachal Pradesh"};
    public static String price_amount[] = {"1505/-", "2000/-", "45000/-", "4512/-", "1345/-","58454/-", "4521/-","7845/-","2154/-","2145/-"};
    public static String c_date[] = {"03-March-2018", "03-March-2018", "02-March-2018", "02-March-2018", "02-March-2018","02-March-2018", "02-March-2018","01-March-2018","01-March-2018","01-March-2018"};

    Context context;
    RecyclerView recyclerView;

    public ActiveAdapter(Context context)
    {
        this.context = context;
    }

    @Override
    public ActiveAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.rv_active_style,parent,false);
//        v.setOnClickListener(this);
        MyHolder mh = new MyHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ActiveAdapter.MyHolder holder, int position) {
        holder.tv_vendor.setText(state_names[position]);
        holder.tv_amount.setText(price_amount[position]);
        holder.tv_date.setText(c_date[position]);
    }

    @Override
    public int getItemCount() {
        return state_names.length;
    }


    public static class MyHolder extends RecyclerView.ViewHolder{
        TextView tv_vendor, tv_amount, tv_date;
        public MyHolder(View itemView) {
            super(itemView);
            tv_vendor = itemView.findViewById(R.id.tv_vendor);
            tv_amount = itemView.findViewById(R.id.tv_amount);
            tv_date = itemView.findViewById(R.id.tv_date);
        }
    }
}
