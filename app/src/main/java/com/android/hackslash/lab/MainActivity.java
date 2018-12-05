package com.android.hackslash.lab;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    long starttime = 0;
    long currenttime = 0;
    long sdiff = 0;
    long diff = 0;

    TextView mintxt;
    TextView sectxt;
    TextView msectxt;

    Button startstop;
    Button reset;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mintxt = (TextView) findViewById(R.id.mintxt);
        sectxt = (TextView) findViewById(R.id.sectxt);
        msectxt = (TextView) findViewById(R.id.msectxt);

        startstop = (Button) findViewById(R.id.startstop);
        reset = (Button) findViewById(R.id.reset);

        startstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (startstop.getText().toString().equals("Start")) {
                    startstop.setText("Stop");
                    starttime = System.currentTimeMillis();
                    try {
                        handler.removeCallbacks(update);
                        handler.post(update);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    startstop.setText("Start");
                    handler.removeCallbacks(update);
                    starttime = System.currentTimeMillis();
                    sdiff += diff;
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startstop.setText("Start");
                handler.removeCallbacks(update);
                mintxt.setText("0m");
                sectxt.setText("0s");
                msectxt.setText("000ms");
                sdiff = 0;
            }
        });
    }

    private Runnable update = new Runnable() {
        @Override
        public void run() {
            currenttime = System.currentTimeMillis();
            diff = currenttime - starttime;
            long tmpdiff = diff + sdiff;
            mintxt.setText("" + (tmpdiff / 60000) + "m");
            sectxt.setText("" + (tmpdiff / 1000) % 60 + "s");
            msectxt.setText("" + tmpdiff % 1000 + "ms");
            handler.post(this);
        }
    };
}
