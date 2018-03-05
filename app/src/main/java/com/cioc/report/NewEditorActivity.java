package com.cioc.report;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewEditorActivity extends Activity {

    Button add, neaSubmit;
    RecyclerView rv_new_editor;
    NEAdapter neAdapter;
//    public static String categories, vendor, date,amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_editor);

//        Bundle bundle = getIntent().getExtras();
//        if (bundle != null){
//            categories = bundle.getString("categories");
//            vendor = bundle.getString("vendor");
//            date = bundle.getString("date");
//            amount = bundle.getString("amount");
//            TextView tv = findViewById(R.id.tv_new);
//            tv.setText(categories+"\n"+vendor+"\n"+date+"\n"+amount);
//        }

        rv_new_editor = findViewById(R.id.rv_new_editor);
        rv_new_editor.setLayoutManager(new LinearLayoutManager(this));

        neAdapter = new NEAdapter(this);
        rv_new_editor.setAdapter(neAdapter);

        add = findViewById(R.id.add);
        neaSubmit = findViewById(R.id.nea_submit);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(NewEditorActivity.this, DetailsActivity.class);
                startActivity(intent1);
                finish();
            }
        });

        neaSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(NewEditorActivity.this, MainActivity.class);
                startActivity(intent2);
                finish();
            }
        });
    }
}
