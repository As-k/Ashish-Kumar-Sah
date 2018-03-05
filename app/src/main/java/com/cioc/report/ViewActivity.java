package com.cioc.report;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewActivity extends Activity {
    RecyclerView rv_view_activity;
    ViewAdapter viewAdapter;
    public static ArrayList arrayList;
    String from[] = {"categories", "vendor","date", "amount"};
    public static String categories, vendor, date,amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        arrayList = new ArrayList();

        Bundle bundle = getIntent().getExtras();
        vendor = bundle.getString("state");
        amount = bundle.getString("amount");
        date = bundle.getString("date");

        HashMap hm = new HashMap();
//        hm.put(from[0],categories);
        hm.put(from[1],vendor);
        hm.put(from[2],date);
        hm.put(from[3],amount);
        arrayList.add(hm);

        rv_view_activity = findViewById(R.id.view_rv);
        rv_view_activity.setLayoutManager(new LinearLayoutManager(this));

        viewAdapter = new ViewAdapter(this);
        rv_view_activity.setAdapter(viewAdapter);

//        TextView tv = findViewById(R.id.textView);
//        tv.setText(state+"\n"+amount+"\n"+date);

        Button revoke = findViewById(R.id.view_revoke);
        revoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewActivity.this, "Revoked", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
