package com.cioc.report;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Ashish on 2/26/2018.
 */

public class NEAdapter  extends RecyclerView.Adapter<NEAdapter.MyHolder> {

    Context context;

    public NEAdapter(Context context) {
        this.context = context;
    }

    @Override
    public NEAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.rv_active_style, parent, false);
        NEAdapter.MyHolder mh = new NEAdapter.MyHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(NEAdapter.MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MyHolder extends RecyclerView.ViewHolder {
        TextView tv1, tv2, tv3;

        public MyHolder(View itemView) {
            super(itemView);

        }
    }
}