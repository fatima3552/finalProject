package com.example.project3;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;


import static com.example.project3.DatabaseContract.Users.TABLE_NAME;

import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity  {

    private AppBarConfiguration mAppBarConfiguration;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    EditText et1, et2,et3, et4,et5, et6;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.nav_gallery:
                        Intent adm=new Intent(MainActivity.this,admin.class);
                        startActivity(adm);
                        break;
                    case R.id.nav_home:
                        Intent hand=new Intent(MainActivity.this,handymanform.class);
                        startActivity(hand);
                        break;

                }
                return true;
            }
        });

                // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        dbHelper = new DatabaseHelper(this);
        getSupportActionBar().setTitle("Application form");

        b1=(Button) findViewById(R.id.submit);
        et1 = (EditText) findViewById(R.id.ed1);
        et2 = (EditText) findViewById(R.id.ed2);
        et3 = (EditText) findViewById(R.id.ed3);
        et4 = (EditText) findViewById(R.id.ed4);
        et5 = (EditText) findViewById(R.id.ed5);
        et6 = (EditText) findViewById(R.id.ed6);
        et1.addTextChangedListener(t);
        et2.addTextChangedListener(t);
        et6.addTextChangedListener(t);
    }
    private TextWatcher t=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String et11=et1.getText().toString().trim();
            String et22=et2.getText().toString();
            String et66=et6.getText().toString();
            b1.setEnabled(!et11.isEmpty()&&!et22.isEmpty()&&!et66.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void enter(View v) {
        db = dbHelper.getWritableDatabase();
        String val1 = et1.getText().toString();
        String val2 = et2.getText().toString();
        String val3 = et3.getText().toString();
        String val4 = et4.getText().toString();
        String val5 = et5.getText().toString();
        String val6 = et6.getText().toString();
        //Toast.makeText(this,val1+val2+val3+val4+val5+val6,Toast.LENGTH_SHORT).show();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.Users.COL_NAME, val1);
        values.put(DatabaseContract.Users.COL_PHONENUMBER, val2);
        values.put(DatabaseContract.Users.COL_EMAIL, val3);
        values.put(DatabaseContract.Users.COL_PASSWORD, val4);
        values.put(DatabaseContract.Users.COL_CONFIRMPASSWORD, val5);
        values.put(DatabaseContract.Users.COL_CNIC, val6);

        long newRowId = db.insert(TABLE_NAME, null, values);
        Toast.makeText(this, "New Record Inserted: " + newRowId, Toast.LENGTH_SHORT).show();

        if (newRowId > 0) {
            Toast.makeText(this, "New Record Inserted: " + newRowId, Toast.LENGTH_SHORT).show();
            Intent g=new Intent(MainActivity.this,dashbord.class);
           startActivity(g);

        }

        db.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    public  boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void  rating(View v)
    {
        Intent ui=new Intent(MainActivity.this,RatingActivity.class);
        startActivity(ui);

    }



}