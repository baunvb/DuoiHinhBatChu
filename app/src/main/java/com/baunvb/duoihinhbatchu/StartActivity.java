package com.baunvb.duoihinhbatchu;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Bau NV on 5/18/2017.
 */

public class StartActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btStart;
    private Button btQuit;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_layout);
        initView();
    }

    private void initView() {
        btStart = (Button) findViewById(R.id.start);
        btStart.setOnClickListener(this);
        btQuit = (Button) findViewById(R.id.quit);
        btQuit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                Intent playIntent = new Intent(this, PlayActivity.class);
                startActivity(playIntent);
                break;
            case R.id.quit:
                finish();
            default:
                break;
        }
    }
}
