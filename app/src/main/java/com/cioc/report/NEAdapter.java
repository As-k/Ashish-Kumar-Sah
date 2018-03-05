package com.cioc.report;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ashish on 2/26/2018.
 */

public class NEAdapter  extends RecyclerView.Adapter<NEAdapter.MyHolder> {

    Context context;
//    ArrayList arrayList;
//    String from[] = {"categories", "vendor","date", "amount"};

    public NEAdapter(Context context) {
        this.context = context;
    }

    @Override
    public NEAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.recylerview_nea_style, parent, false);
//        arrayList = new ArrayList();
//        String categories = NewEditorActivity.categories;
//        String vendor = NewEditorActivity.vendor;
//        String date = NewEditorActivity.date;
//        String amount = NewEditorActivity.amount;
//        HashMap hm = new HashMap();
//        hm.put(from[0],categories);
//        hm.put(from[1],vendor);
//        hm.put(from[2],date);
//        hm.put(from[3],amount);
//        arrayList.add(hm);
        NEAdapter.MyHolder mh = new NEAdapter.MyHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(NEAdapter.MyHolder holder, int position) {
//        holder.nea_tv_categories.setText(from[position]);
//        holder.nea_tv_vendor.setText(from[position]);
//        holder.nea_tv_date.setText(from[position]);
//        holder.nea_tv_amount.setText(from[position]);
    }

    @Override
    public int getItemCount() {
        return 0; //arrayList.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        TextView nea_tv_categories, nea_tv_vendor, nea_tv_date, nea_tv_amount;

        public MyHolder(View itemView) {
            super(itemView);
            nea_tv_categories = itemView.findViewById(R.id.nea_tv_categories);
            nea_tv_vendor = itemView.findViewById(R.id.nea_tv_vendor);
            nea_tv_date = itemView.findViewById(R.id.nea_tv_date);
            nea_tv_amount = itemView.findViewById(R.id.nea_tv_amount);
        }
    }
}