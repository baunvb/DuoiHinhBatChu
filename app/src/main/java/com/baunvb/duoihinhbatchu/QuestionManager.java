package com.baunvb.duoihinhbatchu;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static android.R.attr.id;

/**
 * Created by Baunvb on 12/6/2016.
 */

public class QuestionManager {
    private ArrayList<Question> arrQuestion;

    public QuestionManager() {
        arrQuestion = new ArrayList<>();
        arrQuestion.add(new Question(R.drawable.aomua, "aomua"));
        arrQuestion.add(new Question(R.drawable.baocao, "baocao"));
        arrQuestion.add(new Question(R.drawable.canthiep, "canthiep"));
        arrQuestion.add(new Question(R.drawable.cattuong, "cattuong"));
        arrQuestion.add(new Question(R.drawable.danhlua, "danhlua"));
        arrQuestion.add(new Question(R.drawable.chieutre, "chieutre"));
        arrQuestion.add(new Question(R.drawable.danong, "danong"));
        arrQuestion.add(new Question(R.drawable.giandiep, "giandiep"));
        arrQuestion.add(new Question(R.drawable.giangmai, "giangmai"));
        arrQuestion.add(new Question(R.drawable.hoidong, "hoidong"));
        arrQuestion.add(new Question(R.drawable.hongtam, "hongtam"));
        arrQuestion.add(new Question(R.drawable.khoailang, "khoailang"));
        arrQuestion.add(new Question(R.drawable.kiemchuyen, "kiemchuyen"));
        arrQuestion.add(new Question(R.drawable.lancan, "lancan"));
        arrQuestion.add(new Question(R.drawable.masat, "masat"));
        arrQuestion.add(new Question(R.drawable.nambancau, "nambancau"));
        arrQuestion.add(new Question(R.drawable.oto, "oto"));
        arrQuestion.add(new Question(R.drawable.quyhang, "quyhang"));
        arrQuestion.add(new Question(R.drawable.songsong, "songsong"));
        arrQuestion.add(new Question(R.drawable.thattinh, "thattinh"));
        arrQuestion.add(new Question(R.drawable.thothe, "thothe"));
        arrQuestion.add(new Question(R.drawable.tichphan, "tichphan"));
        arrQuestion.add(new Question(R.drawable.tohoai, "tohoai"));
        arrQuestion.add(new Question(R.drawable.totien, "totien"));
        arrQuestion.add(new Question(R.drawable.tranhthu, "tranhthu"));
        arrQuestion.add(new Question(R.drawable.vuaphaluoi, "vuaphaluoi"));
        arrQuestion.add(new Question(R.drawable.vuonbachthu, "vuonbachthu"));
        arrQuestion.add(new Question(R.drawable.xakep, "xakep"));
        arrQuestion.add(new Question(R.drawable.xaphong, "xaphong"));
        arrQuestion.add(new Question(R.drawable.xedapdien, "xedapdien"));

    }

    public ArrayList<Question> getArrQuestion() {
        return arrQuestion;
    }
}
