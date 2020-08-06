package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class RatingActivity extends AppCompatActivity {
    RatingBar rating;
    TextView ratingvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        Intent intent=getIntent();
        rating=(RatingBar)findViewById(R.id.ratingBar);
        ratingvalue=(TextView)findViewById(R.id.ratingvalue);
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                ratingvalue.setText(String.valueOf(v));
                switch ((int)ratingBar.getRating())
                {
                    case 1:
                        ratingvalue.setText("Very Bad");
                        break;
                    case 2:
                        ratingvalue.setText("Need Some Improvement");
                        break;
                    case 3:
                        ratingvalue.setText("Good");
                        break;
                    case 4:
                        ratingvalue.setText("Great ");
                        break;
                    case 5:
                        ratingvalue.setText("Awesome.I loved it.");
                        break;
                    default:
                        ratingvalue.setText(" ");
                }


            }
        });



    }
}