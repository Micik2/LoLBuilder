package com.example.maciek.lolbuilder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by Maciek on 2017-06-25.
 */

public class LayoutInflaterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        LayoutInflater inflater = LayoutInflater.from(this);
        LinearLayout row;

        row = (LinearLayout) inflater.inflate(R.layout.main0, null);
        layout.addView(row);
        row = (LinearLayout) inflater.inflate(R.layout.main1, null);
        layout.addView(row);

        setContentView(layout);

    }
}

