package com.example.picturealbum2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedlnstanceState){
        super.onCreate(savedlnstanceState);

        try{
            Thread.sleep(4000); //대기 초 설정 1000=1초
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
