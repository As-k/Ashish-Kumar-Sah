package com.cioc.report;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ashish on 2/25/2018.
 */

public class ApprovalAdapter extends RecyclerView.Adapter<ApprovalAdapter.MyHolder> {

    Context context;
    public ApprovalAdapter(Context context){
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.rv_approval_style,parent,false);
        ApprovalAdapter.MyHolder mh = new ApprovalAdapter.MyHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        public MyHolder(View itemView) {
            super(itemView);
        }
    }
}
