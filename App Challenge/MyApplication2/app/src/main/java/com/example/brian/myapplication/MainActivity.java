package com.example.brian.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    int kilos;
//    int megs;
//    int gigs;
    Integer[] labels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //create array of counters
        labels = new Integer[4];
        labels[0] = 0;
        labels[1] = 0;
        labels[2] = 0;
        labels[3] = 0;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create tabHost
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        //create tabs
        TabHost.TabSpec tab1 = tabHost.newTabSpec("1");
        tab1.setContent(R.id.Counter1);
        tab1.setIndicator("Counter 1");
        tabHost.addTab(tab1);

        tab1 = tabHost.newTabSpec("2");
        tab1.setContent(R.id.Counter2);
        tab1.setIndicator("Counter 2");
        tabHost.addTab(tab1);

        tab1 = tabHost.newTabSpec("3");
        tab1.setContent(R.id.Counter3);
        tab1.setIndicator("Counter 3");
        tabHost.addTab(tab1);

        tab1 = tabHost.newTabSpec("4");
        tab1.setContent(R.id.Counter4);
        tab1.setIndicator("Counter 4");
        tabHost.addTab(tab1);
        //create labels
        final TextView text1 = (TextView) findViewById(R.id.textView1);
        final TextView text2 = (TextView) findViewById(R.id.textView2);
        final TextView text3 = (TextView) findViewById(R.id.textView3);
        final TextView text4 = (TextView) findViewById(R.id.textView4);
        //create buttons
        Button add1 = (Button) findViewById(R.id.plus1);
        Button add2 = (Button) findViewById(R.id.plus2);
        Button add3 = (Button) findViewById(R.id.plus3);
        Button add4 = (Button) findViewById(R.id.plus4);
        Button min1 = (Button) findViewById(R.id.minus1);
        Button min2 = (Button) findViewById(R.id.minus2);
        Button min3 = (Button) findViewById(R.id.minus3);
        Button min4 = (Button) findViewById(R.id.minus4);
        //button onclicks
        add1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                labels[0]++;
                text1.setText(Integer.toString(labels[0]));
            }

        });

        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                labels[1]++;
                text2.setText(Integer.toString(labels[1]));
            }

        });

        add3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                labels[2]++;
                text3.setText(Integer.toString(labels[2]));
            }

        });

        add4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                labels[3]++;
                text4.setText(Integer.toString(labels[3]));
            }

        });

        min1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                labels[0]--;
                text1.setText(Integer.toString(labels[0]));
            }

        });

        min2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                labels[1]--;
                text2.setText(Integer.toString(labels[1]));
            }

        });

        min3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                labels[2]--;
                text3.setText(Integer.toString(labels[2]));
            }

        });

        min4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                labels[3]--;
                text4.setText(Integer.toString(labels[3]));
            }

        });

//        final TextView mainText = (TextView) findViewById(R.id.mainText);
//        final TextView stopText = (TextView) findViewById(R.id.textView);
//        Button mainButton = (Button) findViewById(R.id.mainButton);
//
//        kilos= 0;
//        megs = 0;
//        gigs = 0;
//
//        mainButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                kilos++;
//                if(kilos==1024){
//                    megs++;
//                    kilos=0;
//                }
//                mainText.setText(gigs + "GB and "+ megs + "MB and " + kilos + "KB of RAM Downloaded");
//                if(megs == 1024){
//                    gigs++;
//                    megs = 0;
//                    stopText.setText("PLEASE STOP DOWNLOADING RAM PLEASE PLEASE PLEASE PLEASE");
//                }
//            }
//
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
