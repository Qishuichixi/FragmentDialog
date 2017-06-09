package com.qishui.zhou.rv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.qishui.zhou.rv2.view.LabelButtonView;
import com.qishui.zhou.rv2.view.LabelImageView;
import com.qishui.zhou.rv2.view.LabelTextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LabelButtonView labelButtonView = (LabelButtonView) findViewById(R.id.labelbutton);
        labelButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                labelButtonView.setLabelVisual(!labelButtonView.isLabelVisual());
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });

        final LabelImageView labelImageView1 = (LabelImageView) findViewById(R.id.image1);
        labelImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                labelImageView1.setLabelDistance(50);
            }
        });

        final LabelImageView labelImageView2 = (LabelImageView) findViewById(R.id.image2);
        labelImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                labelImageView2.setLabelText("ART");
            }
        });


        final LabelTextView labelTextView = (LabelTextView) findViewById(R.id.text);
        labelTextView.setLabelText("HeBe"+ labelTextView.isLabelEnable());

        labelTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                labelTextView.setLabelOrientation(1+new Random().nextInt(4));

            }
        });
    }
}
