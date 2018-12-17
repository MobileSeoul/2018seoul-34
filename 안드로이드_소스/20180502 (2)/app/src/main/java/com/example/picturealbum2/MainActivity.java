package com.example.picturealbum2;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Mission ImpoSeoul");
    }

    public void displayPicture(View v) {
        int id = v.getId();
        LinearLayout layout = (LinearLayout) v.findViewById(id);
        String tag = (String) layout.getTag();

        Intent it = new Intent(this, Picture.class);
        it.putExtra("it_tag", tag);
        startActivity(it);
    }

    public void play(View v) {
        int id = v.getId();
        LinearLayout layout = (LinearLayout) findViewById(id);
        Resources res = getResources();

        if (mp.isPlaying()) {
            mp.pause();
            Drawable drawable = res.getDrawable(R.drawable.shape_list);
            layout.setBackground(drawable);
        } else {
            String tag = (String) layout.getTag();
            int id_audio = res.getIdentifier(tag, "raw", getPackageName());
            mp = MediaPlayer.create(this, id_audio);
            mp.setLooping(false);
            ;
            mp.start();
            Drawable drawable = res.getDrawable(R.drawable.shape_on);
            layout.setBackground(drawable);
        }
    }
}