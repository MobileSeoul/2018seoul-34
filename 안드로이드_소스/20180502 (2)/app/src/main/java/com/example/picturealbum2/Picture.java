package com.example.picturealbum2;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Picture extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture);

        //WebView webview = (WebView)findViewById(R.id.webview);
        //webview.setWebViewClient(new WebViewClient());
        //WebSettings set = webview.getSettings();
        //set.setJavaScriptEnabled(true);
        //set.setBuiltInZoomControls(true);

        //webview.loadUrl("https://map.naver.com/index.nhn?menu=route");

        setTitle("Mission ImpoSoeul Quiz");

        TextView tv_title = (TextView) findViewById(R.id.title);
        TextView tv_level = (TextView) findViewById(R.id.level);
        TextView tv_explain = (TextView) findViewById(R.id.explain);
        ImageView iv_picture = (ImageView) findViewById(R.id.picture);
        TextView tv_ex = (TextView) findViewById(R.id.ex);
        TextView tv_qz = (TextView) findViewById(R.id.qz);
        TextView tv_ms = (TextView) findViewById(R.id.ms);
        EditText et_answer = (EditText) findViewById(R.id.answer);
        EditText et_as = (EditText) findViewById(R.id.as);
        EditText et_aw = (EditText) findViewById(R.id.aw);


        Intent it = getIntent();
        String tag = it.getStringExtra("it_tag");

        Resources res = getResources();

        int id_title = res.getIdentifier("title" + tag, "string", getPackageName());
        String title = res.getString(id_title);
        tv_title.setText(title);

        int id_level = res.getIdentifier("level" + tag, "string", getPackageName());
        String level = res.getString(id_level);
        tv_level.setText(level);

        int id_explain = res.getIdentifier("explain" + tag, "string", getPackageName());
        String explain = res.getString(id_explain);
        tv_explain.setText(explain);


        int id_picture = res.getIdentifier("picture" + tag, "string", getPackageName());
        String picture = res.getString(id_picture);
        int id_img = res.getIdentifier(picture, "drawable", getPackageName());
        Drawable drawable = res.getDrawable(id_img);
        iv_picture.setBackground(drawable);

        int id_ex = res.getIdentifier("ex" + tag, "string", getPackageName());
        String ex = res.getString(id_ex);
        tv_ex.setText(ex);

        int id_qz = res.getIdentifier("qz" + tag, "string", getPackageName());
        String qz = res.getString(id_qz);
        tv_qz.setText(qz);

        int id_ms = res.getIdentifier("ms" + tag, "string", getPackageName());
        String ms = res.getString(id_ms);
        tv_ms.setText(ms);

        //int id_answer = res.getIdentifier("answer" + tag, "string", getPackageName());
        //String answer = res.getString(id_answer);
        //et_answer.setText(ms);
    }



    public void closePicture(View v) {
        finish();
    }

    public void submitScore(View view)
    {
        int score = calculateTotal();

        displayScore(score);
    }

    /**
     * method that calculates the user's total score
     * @return the total score from user's quiz answers
     */
    public int calculateTotal()
    {
        int score = 0;

        //  객관식 정답처리 하는 법
        // logic handling points for first question
        //RadioButton questionOneChoiceD = (RadioButton)findViewById(R.id.q1_choiceC);
        //boolean questionOneIsCorrect = questionOneChoiceD.isChecked();
        //if (questionOneIsCorrect)
        //  score++;

        // 1번 문제
        int id_answer = getResources().getIdentifier("answer" + getIntent().getStringExtra("it_tag"), "string", getPackageName());
        String answer = getResources().getString(id_answer);   //ID에 해당하는 데이터 추출

        if (answer.toLowerCase().contains("answer01"))
        {
            EditText questionOneEditText = (EditText)findViewById(R.id.answer);
            String quesOneStr = questionOneEditText.getText().toString();
            if (quesOneStr.toLowerCase().contains("장충동")) // 주관식 답
                score++;
        }

        else if (answer.toLowerCase().contains("answer02"))
        {
            EditText questionOneEditText = (EditText) findViewById(R.id.answer);
            String quesOneStr = questionOneEditText.getText().toString();
            if (quesOneStr.toLowerCase().contains("홍대입구")) // 주관식 답
                score++;
        }

        else
        {
            EditText questionOneEditText = (EditText) findViewById(R.id.answer);
            String quesOneStr = questionOneEditText.getText().toString();
            if (quesOneStr.toLowerCase().contains("광화문")) // 주관식 답
                score++;
        }

        //2번문제
        int id_as = getResources().getIdentifier("as" + getIntent().getStringExtra("it_tag"), "string", getPackageName());
        String as = getResources().getString(id_as);   //ID에 해당하는 데이터 추출

        if (as.toLowerCase().contains("as01"))
        {
            EditText questionTwoEditText = (EditText)findViewById(R.id.as);
            String quesTwoStr = questionTwoEditText.getText().toString();
            if (quesTwoStr.toLowerCase().contains("떡볶이")) // 주관식 답
                score++;
        }

        else if (as.toLowerCase().contains("as02"))
        {
            EditText questionTwoEditText = (EditText) findViewById(R.id.as);
            String quesTwoStr = questionTwoEditText.getText().toString();
            if (quesTwoStr.toLowerCase().contains("건대입구")) // 주관식 답
                score++;
        }

        else
        {
            EditText questionTwoEditText = (EditText) findViewById(R.id.as);
            String quesTwoStr = questionTwoEditText.getText().toString();
            if (quesTwoStr.toLowerCase().contains("부채")) // 주관식 답
                score++;
        }


        //3번문제
        int id_aw = getResources().getIdentifier("aw" + getIntent().getStringExtra("it_tag"), "string", getPackageName());
        String aw = getResources().getString(id_aw);   //ID에 해당하는 데이터 추출

        if (aw.toLowerCase().contains("aw01"))
        {
            EditText questionThrEditText = (EditText)findViewById(R.id.aw);
            String quesThrStr = questionThrEditText.getText().toString();
            if (quesThrStr.toLowerCase().contains("쭈꾸미")) // 주관식 답
                score++;
        }

        else if (aw.toLowerCase().contains("aw02"))
        {
            EditText questionThrEditText = (EditText) findViewById(R.id.aw);
            String quesThrStr = questionThrEditText.getText().toString();
            if (quesThrStr.toLowerCase().contains("잠실")) // 주관식 답
                score++;
        }

        else
        {
            EditText questionThrEditText = (EditText) findViewById(R.id.aw);
            String quesThrStr = questionThrEditText.getText().toString();
            if (quesThrStr.toLowerCase().contains("자물쇠")) // 주관식 답
                score++;
        }

        //EditText questionTwoEditText = (EditText)findViewById(R.id.q2_editText);
        //String quesTwoStr = questionTwoEditText.getText().toString();
        //if (quesTwoStr.toLowerCase().contains("광화문")) // 주관식 답
        //    score++;

        //EditText questionThrEditText = (EditText)findViewById(R.id.q3_editText);
        //String quesThrStr = questionThrEditText.getText().toString();
        //if (quesThrStr.toLowerCase().contains("남산")) // 주관식 답
        //    score++;


//5번
        // EditText questionfiveEditText = (EditText)findViewById(R.id.q5_editText);
        // String quesfiveStr = questionfiveEditText.getText().toString();
        // if (quesfiveStr.toLowerCase().contains("korea")) // 주관식 답
        //     score++;

        // logic handling points for the third question3
        //CheckBox biscuitCheckBox = (CheckBox)findViewById(R.id.biscuit);
        //boolean biscuitChecked = biscuitCheckBox.isChecked();

        //CheckBox nougatCheckBox = (CheckBox)findViewById(R.id.nougat);
        //boolean nougatChecked = nougatCheckBox.isChecked();

        //CheckBox eclairCheckBox = (CheckBox)findViewById(R.id.eclair);
        //boolean eclairChecked = eclairCheckBox.isChecked();

        //if (biscuitChecked && nougatChecked && eclairChecked)
        //  score++;

        // logic handling points for the fourth question6
        //if (apiVer == 15)
        //    score++;

        return score;
    }

    //int apiVer = 10; // 처음시작하는 값이 10

    /**
     * increments the number for the 4th question's response
     * @param view is the + button
     */

    //public void increment(View view) {
    //    if (apiVer == 20)
    //        return;
    //    apiVer += 1;
    //    displayQuesFour(apiVer);
    //}
    /**
     * decrements the number for the 4th question's response
     * @param view is the - button
     */

    // public void decrement(View view) {
    //     if (apiVer == 10)
    //         return;
    //     apiVer -= 1;
    //     displayQuesFour(apiVer);
    // }

    /**
     * displays the number for the 4th question's response
     * after the increment or decrement buttons are pressed
     * @param number
     */

    //private void displayQuesFour(int number) {
    //    TextView apiVerTextView = (TextView) findViewById(R.id.api_version);
    //    apiVerTextView.setText(String.valueOf(number));
    //}

    /** 스코어
     * displays the user's score after the submit button has been pressed
     * @param score is the score to display onto the app
     */
    public void displayScore(int score)
    {
        TextView scoreView = (TextView)findViewById(R.id.score);
        String scoreMessage;
        if (score == 3)
        {
            scoreMessage = "Your score: " + score + " out of 3" + "\nPerfect score! Congrats!";
        }
        else
        {
            scoreMessage = "Your score: " + score + " out of 3";
        }
        Toast.makeText(getApplicationContext(),scoreMessage,Toast.LENGTH_SHORT).show();
        scoreView.setText(scoreMessage);
    }
}





