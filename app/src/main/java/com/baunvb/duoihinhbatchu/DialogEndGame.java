package com.baunvb.duoihinhbatchu;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URISyntaxException;

/**
 * Created by Bau NV on 5/18/2017.
 */

public class DialogEndGame extends Dialog implements View.OnClickListener {
    private Context context;
    private int score;
    private TextView edtScore;
    private Button btRestart, btExit;

    public DialogEndGame(Context context, int score) {
        super(context);
        this.context = context;
        this.score = score;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_endgame);
        iniViews();
        setCancelable(false);
        getWindow().setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
    }

    public void iniViews() {

        edtScore = (TextView) findViewById(R.id.score);
        edtScore.setText(score+"");
        btExit = (Button) findViewById(R.id.exit);
        btExit.setOnClickListener(this);
        btRestart = (Button) findViewById(R.id.restart);
        btRestart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.restart:
                Intent playIntent = new Intent(context, PlayActivity.class);
                context.startActivity(playIntent);
                break;
            case R.id.exit:
                Intent startIntent = new Intent(context, StartActivity.class);
                context.startActivity(startIntent);
                break;
        }

    }
}
