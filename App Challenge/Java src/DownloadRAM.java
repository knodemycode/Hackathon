package com.knodemy.downloadmoreram;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DownloadRAM extends AppCompatActivity {
    private int mProgressStatus = 0;
    private ProgressBar downloading;
    private Handler handler = new Handler();
    private TextView textView;
    private TextView complete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_ram);

        downloading = (ProgressBar) findViewById(R.id.download_progress);
        textView = (TextView) findViewById(R.id.status);
        complete = (TextView) findViewById(R.id.complete);
        Thread t = new Thread(new Runnable() {
            public void run() {
                while (mProgressStatus < 100) {
                    mProgressStatus++;
                    downloading.setProgress(mProgressStatus);
                    handler.post(new Runnable() {
                        public void run() {
                            downloading.setProgress(mProgressStatus);
                            textView.setText(mProgressStatus + "/" + downloading.getMax());
                        }
                    });
                    try {
                        int interval = (int) (Math.random()*500);
                        Thread.sleep(interval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        complete.setVisibility(View.VISIBLE);
                    }
                });
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        onBackPressed();
                    }
                });
            }
        });
        t.start();
    }
}
