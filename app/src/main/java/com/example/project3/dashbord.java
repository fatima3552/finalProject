package com.example.project3;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dashbord extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3,b4,b5,b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);
        getSupportActionBar().setTitle(" Which Service Do you Need");
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.b1: {
                Intent g = new Intent(dashbord.this, area.class);
                g.putExtra("name","Electrician");
                startActivity(g);
            }
            break;
            case R.id.b2: {
                Intent g = new Intent(dashbord.this,area.class);
                g.putExtra("name","Plumber");
                startActivity(g);
            }
            break;
            case R.id.b3: {
                Intent g = new Intent(dashbord.this, area.class);
                g.putExtra("name","Cleaner");
                startActivity(g);
            }
            break;
            case R.id.b4: {
                Intent g = new Intent(dashbord.this,area.class);
                g.putExtra("name","Cook");
                startActivity(g);
            }
            break;
            case R.id.b5: {
                Intent g = new Intent(dashbord.this, area.class);
                g.putExtra("name","Carpenter");
                startActivity(g);
            }
            break;
            case R.id.b6: {
                Intent g = new Intent(dashbord.this,area.class);
                g.putExtra("name","Constructor");
                startActivity(g);
            }
            break;

        }

    }
}