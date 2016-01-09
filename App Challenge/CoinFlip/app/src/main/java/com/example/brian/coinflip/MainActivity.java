package com.example.brian.coinflip;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable headAnim;
    ImageView headImage;
    int start;
    int end;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        headImage = (ImageView) findViewById(R.id.head);
        headImage.setBackgroundResource(R.drawable.heads_start_heads);
        headAnim = (AnimationDrawable) headImage.getBackground();
        start = 1;
        end = 1;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            randomFlip();
            return true;
        }
        return super.onTouchEvent(event);
    }
    public void randomFlip(){
        end = (int) (Math.random()*2);
        //head and head
        if(end == 1 && start == 1){
            start = end;
            headAnim.stop();
            headImage.setBackgroundResource(R.drawable.heads_start_heads);
            headAnim = (AnimationDrawable) headImage.getBackground();
            headAnim.start();
        }
        //start tail end heads
        else if(end == 1 && start == 0){
            headAnim.stop();
            headImage.setBackgroundResource(R.drawable.heads_start_tails);
            headAnim = (AnimationDrawable) headImage.getBackground();
            headAnim.start();
        }
        // start head end tail
        else if(end == 0 && start == 1){
            headAnim.stop();
            headImage.setBackgroundResource(R.drawable.tails_start_heads);
            headAnim = (AnimationDrawable) headImage.getBackground();
            headAnim.start();
        }
        //start tail end tail
        else if(end == 0 && start == 0){
            headAnim.stop();
            headImage.setBackgroundResource(R.drawable.tails_start_tails);
            headAnim = (AnimationDrawable) headImage.getBackground();
            headAnim.start();
        }

    }
}

