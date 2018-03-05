package com.cioc.report;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Bundle bundle = getIntent().getExtras();
        String state = bundle.getString("state");
        String amount = bundle.getString("amount");
        String date = bundle.getString("date");

        TextView tv = findViewById(R.id.textView);
        tv.setText(state+"\n"+amount+"\n"+date);

        Button revoke = findViewById(R.id.view_revoke);
        revoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewActivity.this, "Revoked", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
