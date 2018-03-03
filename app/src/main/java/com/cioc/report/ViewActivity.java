package com.cioc.report;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        String name = getIntent().getExtras().getString("name");
        TextView tv = findViewById(R.id.textView);
        tv.setText(name);

    }
}
