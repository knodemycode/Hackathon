package com.knodemy.downloadmoreram;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class TestRAM extends AppCompatActivity {
    public static final String PREFS_NAME = "prefs";
    private ProgressBar testProgress;
    private TextView textView;
    private int mProgressStatus;
    private Handler handler = new Handler();
    public int elapsedtime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_ram);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        final int ram = settings.getInt("ram", 2);
        TextView ramAmount = (TextView) findViewById(R.id.ram);
        ramAmount.setText(String.valueOf(ram)+ " GB!");
        testProgress = (ProgressBar) findViewById(R.id.test_progress);
        textView = (TextView) findViewById(R.id.test_status);
        final Thread t = new Thread(new Runnable() {
            public void run() {
                while (mProgressStatus < 100) {
                    mProgressStatus++;
                    testProgress.setProgress(mProgressStatus);
                    handler.post(new Runnable() {
                        public void run() {
                            testProgress.setProgress(mProgressStatus);
                            textView.setText(mProgressStatus + "/" + testProgress.getMax());
                        }
                    });
                    try {
                        int interval = (int) (Math.random()*10000/ram);
                        elapsedtime+=interval;
                        Thread.sleep(interval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        TextView score = (TextView) findViewById(R.id.test_complete);
                        score.setText("Your phone's score is "+elapsedtime+" points.");
                        findViewById(R.id.scoredesc).setVisibility(View.VISIBLE);
                    }
                });
            }
        });
        t.start();
    }
}
