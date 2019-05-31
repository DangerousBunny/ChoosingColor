package com.example.choosingcolor;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import yuku.ambilwarna.AmbilWarnaDialog;

public class MainActivity extends AppCompatActivity {
        ConstraintLayout alayout;
        int adefaultcolor;
        Button abutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alayout = (ConstraintLayout) findViewById(R.id.layout);
        adefaultcolor = ContextCompat.getColor(MainActivity.this, R.color.colorPrimary);
        abutton = (Button) findViewById(R.id.button);
        abutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Coloropen();
            }
        });
    }

    public void Coloropen(){
        AmbilWarnaDialog choosecolor = new AmbilWarnaDialog(this, adefaultcolor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                adefaultcolor = color;
                alayout.setBackgroundColor(adefaultcolor);
            }
        });

        choosecolor.show();
    }
}
