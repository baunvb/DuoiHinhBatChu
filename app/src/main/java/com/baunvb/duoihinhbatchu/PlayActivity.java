package com.baunvb.duoihinhbatchu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener {
    private int index, length, flag;
    private int alive, score;
    private String name;

    private QuestionManager questionMgn;
    private TextView tvAlive, tvScore, tvToast;

    private Button btNext;

    private ImageView imgQuestion;

    private ArrayList<Button> arrBtResult;
    private ArrayList<Button> arrBtHover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_layout);
        initView();
        setInvisibleButton();
        btNext.setVisibility(View.INVISIBLE);
        renewQuestion();
    }


    public void initView() {
        alive = 5;
        score = 0;

        questionMgn = new QuestionManager();
        tvAlive = (TextView) findViewById(R.id.tv_alive);
        tvScore = (TextView) findViewById(R.id.tv_score);
        tvToast = (TextView) findViewById(R.id.tv_toast);

        btNext = (Button) findViewById(R.id.bt_next);
        btNext.setOnClickListener(this);

        imgQuestion = (ImageView) findViewById(R.id.iv_question);

        arrBtResult = new ArrayList<>();
        arrBtResult.add((Button) findViewById(R.id.bt_result_1));
        arrBtResult.add((Button) findViewById(R.id.bt_result_2));
        arrBtResult.add((Button) findViewById(R.id.bt_result_3));
        arrBtResult.add((Button) findViewById(R.id.bt_result_4));
        arrBtResult.add((Button) findViewById(R.id.bt_result_5));
        arrBtResult.add((Button) findViewById(R.id.bt_result_6));
        arrBtResult.add((Button) findViewById(R.id.bt_result_7));
        arrBtResult.add((Button) findViewById(R.id.bt_result_8));
        arrBtResult.add((Button) findViewById(R.id.bt_result_9));
        arrBtResult.add((Button) findViewById(R.id.bt_result_10));
        arrBtResult.add((Button) findViewById(R.id.bt_result_11));
        arrBtResult.add((Button) findViewById(R.id.bt_result_12));
        arrBtResult.add((Button) findViewById(R.id.bt_result_13));
        arrBtResult.add((Button) findViewById(R.id.bt_result_14));
        arrBtResult.add((Button) findViewById(R.id.bt_result_15));
        arrBtResult.add((Button) findViewById(R.id.bt_result_16));

        arrBtHover = new ArrayList<>();
        arrBtHover.add((Button) findViewById(R.id.bt_hover_1));
        arrBtHover.add((Button) findViewById(R.id.bt_hover_2));
        arrBtHover.add((Button) findViewById(R.id.bt_hover_3));
        arrBtHover.add((Button) findViewById(R.id.bt_hover_4));
        arrBtHover.add((Button) findViewById(R.id.bt_hover_5));
        arrBtHover.add((Button) findViewById(R.id.bt_hover_6));
        arrBtHover.add((Button) findViewById(R.id.bt_hover_7));
        arrBtHover.add((Button) findViewById(R.id.bt_hover_8));
        arrBtHover.add((Button) findViewById(R.id.bt_hover_9));
        arrBtHover.add((Button) findViewById(R.id.bt_hover_10));
        arrBtHover.add((Button) findViewById(R.id.bt_hover_11));
        arrBtHover.add((Button) findViewById(R.id.bt_hover_12));
        arrBtHover.add((Button) findViewById(R.id.bt_hover_13));
        arrBtHover.add((Button) findViewById(R.id.bt_hover_14));
        arrBtHover.add((Button) findViewById(R.id.bt_hover_15));
        arrBtHover.add((Button) findViewById(R.id.bt_hover_16));

        for (int i = 0; i < arrBtHover.size(); i++) {
            arrBtHover.get(i).setOnClickListener(this);
            arrBtHover.get(i).setPaintFlags(i);
            arrBtResult.get(i).setOnClickListener(this);
        }

    }

    private void renewQuestion() {
        for (int i = 0; i < arrBtHover.size(); i++) {
            arrBtHover.get(i).setText(null);
            arrBtHover.get(i).setClickable(true);
            arrBtResult.get(i).setClickable(true);
        }
        index = randomQuestion();
        name = questionMgn.getArrQuestion().get(index).getName().toString();
        length = name.length();
        flag = 0;
        tvToast.setVisibility(View.INVISIBLE);
        imgQuestion.setImageResource(questionMgn.getArrQuestion().get(index).getId());
        setInvisibleButton();
        setVisibleButton(index);
        embroilChar(index);
    }

    public boolean isTrue(int index) {
        String result = "";
        String name = questionMgn.getArrQuestion().get(index).getName().toString();
        int length = name.length();
        for (int i = 0; i < length; i++) {
            result = result + arrBtResult.get(i).getText();
        }

        if (result.compareToIgnoreCase(name) == 0) {
            for (int i = 0; i < length; i++) {
                arrBtResult.get(i).setBackground(this.getResources().getDrawable(R.drawable.ic_tile_true));
            }
            return true;
        } else {
            for (int i = 0; i < length; i++) {
                arrBtResult.get(i).setBackground(this.getResources().getDrawable(R.drawable.ic_tile_false));
            }
            return false;
        }
    }

    public int randomQuestion() {
        int size = questionMgn.getArrQuestion().size();
        Random rd = new Random();
        int index = rd.nextInt(size);
        return index;
    }

    public void setInvisibleButton() {
        int size = arrBtResult.size();
        for (int i = 0; i < size; i++) {
            arrBtResult.get(i).setVisibility(View.INVISIBLE);
        }
    }

    public void setVisibleButton(int index) {
        String name = questionMgn.getArrQuestion().get(index).getName();
        int length = name.length();
        for (int i = 0; i < length; i++) {
            arrBtResult.get(i).setBackground(this.getResources().getDrawable(R.drawable.ic_title_result));
            arrBtResult.get(i).setVisibility(View.VISIBLE);
            arrBtResult.get(i).setText(null);
        }
        int size = arrBtHover.size();
        for (int i = 0; i < size; i++) {
            arrBtHover.get(i).setVisibility(View.VISIBLE);
        }

    }

    public void embroilChar(int index) {
        Random rd = new Random();
        int j, k;
        int size = arrBtHover.size();
        String name = questionMgn.getArrQuestion().get(index).getName();
        int length = name.length();
        String sub[] = name.split("");
        for (int i = 0; i < length; i++) {
            j = rd.nextInt(size);
            while (!arrBtHover.get(j).getText().toString().isEmpty()) {
                j++;
                if (j == size) {
                    j = 0;
                }
            }

            arrBtHover.get(j).setText(sub[i + 1]);
        }

        for (int i = 0; i < size; i++) {
            if (arrBtHover.get(i).getText().toString().isEmpty()) {
                k = rd.nextInt(26) + 65;
                arrBtHover.get(i).setText(Character.toString((char) k));
            }
        }

    }

    public void setAnswer(Button bt, int index) {
        String name = questionMgn.getArrQuestion().get(index).getName();
        int length = name.length();
        String str = bt.getText().toString();
        for (int i = 0; i < length; i++) {
            if (arrBtResult.get(i).getText().toString().isEmpty()) {
                arrBtResult.get(i).setText(str);
                arrBtResult.get(i).setPaintFlags(bt.getPaintFlags());
                break;
            }
        }
    }

    public void resetAnswer(Button bt){
        if (!bt.getText().toString().isEmpty()){
            flag--;
        }
        bt.setText(null);
        int flag = bt.getPaintFlags();
        for (int i = 0; i < arrBtHover.size(); i++){
            if (arrBtHover.get(i).getPaintFlags() == flag){
                arrBtHover.get(i).setVisibility(View.VISIBLE);
            }
        }
    }

    public void actionButton(Button bt){
        bt.setVisibility(View.INVISIBLE);
        setAnswer(bt, index);
        flag++;
        if (flag == length) {
            if (isTrue(index)) {
                tvToast.setText(getString(R.string.true_label));
                score = score + 100;
                tvScore.setText(score + "");
            } else {
                alive = alive - 1;
                tvToast.setText(getString(R.string.false_label));
                tvAlive.setText(alive + "");
                if (alive == 0) {
                    DialogEndGame dialogEndGame = new DialogEndGame(this, score);
                    dialogEndGame.show();
                }
            }
            btNext.setVisibility(View.VISIBLE);
            tvToast.setVisibility(View.VISIBLE);
            for (int i = 0; i < arrBtHover.size(); i++) {
                arrBtHover.get(i).setClickable(false);
                arrBtResult.get(i).setClickable(false);
            }
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_next:
                renewQuestion();
                btNext.setVisibility(View.INVISIBLE);
                break;
            case R.id.bt_hover_1:
                actionButton(arrBtHover.get(0));
                break;
            case R.id.bt_hover_2:
                actionButton(arrBtHover.get(1));
                break;
            case R.id.bt_hover_3:
                actionButton(arrBtHover.get(2));
                break;
            case R.id.bt_hover_4:
                actionButton(arrBtHover.get(3));
                break;
            case R.id.bt_hover_5:
                actionButton(arrBtHover.get(4));
                break;
            case R.id.bt_hover_6:
                actionButton(arrBtHover.get(5));
                break;
            case R.id.bt_hover_7:
                actionButton(arrBtHover.get(6));
                break;
            case R.id.bt_hover_8:
                actionButton(arrBtHover.get(7));
                break;
            case R.id.bt_hover_9:
                actionButton(arrBtHover.get(8));
                break;
            case R.id.bt_hover_10:
                actionButton(arrBtHover.get(9));
                break;
            case R.id.bt_hover_11:
                actionButton(arrBtHover.get(10));
                break;
            case R.id.bt_hover_12:
                actionButton(arrBtHover.get(11));
                break;
            case R.id.bt_hover_13:
                actionButton(arrBtHover.get(12));
                break;
            case R.id.bt_hover_14:
                actionButton(arrBtHover.get(13));
                break;
            case R.id.bt_hover_15:
                actionButton(arrBtHover.get(14));
                break;
            case R.id.bt_hover_16:
                actionButton(arrBtHover.get(15));
                break;
            case R.id.bt_result_1:
                resetAnswer(arrBtResult.get(0));
                break;
            case R.id.bt_result_2:
                resetAnswer(arrBtResult.get(1));
                break;
            case R.id.bt_result_3:
                resetAnswer(arrBtResult.get(2));
                break;
            case R.id.bt_result_4:
                resetAnswer(arrBtResult.get(3));
                break;
            case R.id.bt_result_5:
                resetAnswer(arrBtResult.get(4));
                break;
            case R.id.bt_result_6:
                resetAnswer(arrBtResult.get(5));
                break;
            case R.id.bt_result_7:
                resetAnswer(arrBtResult.get(6));
                break;
            case R.id.bt_result_8:
                resetAnswer(arrBtResult.get(7));
                break;
            case R.id.bt_result_9:
                resetAnswer(arrBtResult.get(8));
                break;
            case R.id.bt_result_10:
                resetAnswer(arrBtResult.get(9));
                break;
            case R.id.bt_result_11:
                resetAnswer(arrBtResult.get(10));
                break;
            case R.id.bt_result_12:
                resetAnswer(arrBtResult.get(11));
                break;
            case R.id.bt_result_13:
                resetAnswer(arrBtResult.get(12));
                break;
            case R.id.bt_result_14:
                resetAnswer(arrBtResult.get(13));
                break;
            case R.id.bt_result_15:
                resetAnswer(arrBtResult.get(14));
                break;
            case R.id.bt_result_16:
                resetAnswer(arrBtResult.get(15));
                break;

            default:
                break;
        }
    }

}
