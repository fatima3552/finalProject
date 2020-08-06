package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class area extends AppCompatActivity  implements View.OnClickListener{
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    String cc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        getSupportActionBar().setTitle(" Areas");
        b1=(Button)findViewById(R.id.btt1);
        b2=(Button)findViewById(R.id.btt2);
        b3=(Button)findViewById(R.id.btt3);
        b4=(Button)findViewById(R.id.btt4);
        b5=(Button)findViewById(R.id.btt5);
        b6=(Button)findViewById(R.id.btt6);
        b7=(Button)findViewById(R.id.btt7);
        b8=(Button)findViewById(R.id.btt8);
        b9=(Button)findViewById(R.id.btt9);
        b10=(Button)findViewById(R.id.btt10);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);
        Intent i=getIntent();
      cc=i.getStringExtra("name");
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btt1: {
                Intent g = new Intent(area.this, handy.class);
                g.putExtra("area","H-10");
                g.putExtra("name",cc);
                startActivity(g);
            }
            break;
            case R.id.btt2: {
                Intent g = new Intent(area.this, handy.class);
                g.putExtra("area","I-10");
                g.putExtra("name",cc);
                startActivity(g);
            }
            break;
            case R.id.btt3: {
                Intent g = new Intent(area.this, handy.class);
                g.putExtra("area","F-10");
                g.putExtra("name",cc);
                startActivity(g);
            }
            break;
            case R.id.btt4: {
                Intent g = new Intent(area.this, handy.class);
                g.putExtra("area","G-10");
                g.putExtra("name",cc);
                startActivity(g);
            }
            break;
            case R.id.btt5: {
                Intent g = new Intent(area.this, handy.class);
                g.putExtra("area","G-11");
                g.putExtra("name",cc);
                startActivity(g);
            }
            break;
            case R.id.btt6: {
                Intent g = new Intent(area.this, handy.class);
                g.putExtra("area","E-11");
                g.putExtra("name",cc);
                startActivity(g);
            }
            break;
            case R.id.btt7: {
                Intent g = new Intent(area.this, handy.class);
                g.putExtra("area","F-9");
                g.putExtra("name",cc);
                startActivity(g);
            }
            break;
            case R.id.btt8: {
                Intent g = new Intent(area.this, handy.class);
                g.putExtra("area","F-7");
                g.putExtra("name",cc);
                startActivity(g);
            }
            break;
            case R.id.btt9: {
                Intent g = new Intent(area.this, handy.class);
                g.putExtra("area","G-13");
                g.putExtra("name",cc);
                startActivity(g);
            }
            break;
            case R.id.btt10: {
                Intent g = new Intent(area.this, handy.class);
                g.putExtra("area","H-11");
                g.putExtra("name",cc);
                startActivity(g);
            }
            break;

        }

    }
}