package com.cioc.report;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by Ashish on 2/26/2018.
 */

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.MyHolder> {

    Context context;
//    ArrayList arrayList;
    String from[] = {"categories", "vendor","date", "amount"};

    public ViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.recylerview_viewadapter_style, parent, false);
        ViewAdapter.MyHolder mh = new ViewAdapter.MyHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ViewAdapter.MyHolder holder, int position) {
        HashMap hm = (HashMap) ViewActivity.arrayList.get(position);
//        String categories = (String) hm.get(from[0]);
        String vendor = (String) hm.get(from[1]);
        String date = (String) hm.get(from[2]);
        String amount = (String) hm.get(from[3]);
//        holder.va_tv_categories.setText(categories);
        holder.va_tv_vendor.setText(vendor);
        holder.va_tv_date.setText(date);
        holder.va_tv_amount.setText(amount);
    }

    @Override
    public int getItemCount() {
        return  ViewActivity.arrayList.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        TextView nea_tv_categories, va_tv_vendor, va_tv_date, va_tv_amount;

        public MyHolder(View itemView) {
            super(itemView);
//            nea_tv_categories = itemView.findViewById(R.id.nea_tv_categories);
            va_tv_vendor = itemView.findViewById(R.id.va_tv_vendor);
            va_tv_date = itemView.findViewById(R.id.va_tv_date);
            va_tv_amount = itemView.findViewById(R.id.va_tv_amount);
        }
    }
}