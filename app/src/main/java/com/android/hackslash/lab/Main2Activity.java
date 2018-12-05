package com.android.hackslash.lab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class Main2Activity extends AppCompatActivity {

    Spinner spinner;
    public static ImageView imView;
    public static Button button;
    String[] brand = {"BMW", "Maruti", "Ferrari", "Audi", "Tesla", "Renault"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spinner = (Spinner) findViewById(R.id.spinner);
        imView = (ImageView) findViewById(R.id.image);
        button = (Button) findViewById(R.id.button);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, brand);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
    }

    public static void func(View view) {
        if (imView.getVisibility() == View.INVISIBLE) {
            imView.setVisibility(View.VISIBLE);
            button.setText("Hide Image");
        } else {
            imView.setVisibility(View.INVISIBLE);
            button.setText("Show Image");
        }
    }
}
