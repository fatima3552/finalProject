package com.example.project3;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;

import android.widget.ListView;

import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
public class handy extends AppCompatActivity {
    ListView lv;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
String ph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handy);
        getSupportActionBar().setTitle(" List of HandyMan");

        Intent i=getIntent();
        String cc=i.getStringExtra("name");
        String area=i.getStringExtra("area");
       // Toast.makeText(handy.this,""+cc ,Toast.LENGTH_SHORT).show();
        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getReadableDatabase();

        final List<String> usersList = new ArrayList<String>();
        final List<String> cnic = new ArrayList<String>();
        final List<String> name = new ArrayList<String>();
        final List<String> gender = new ArrayList<String>();
        final Cursor p =dbHelper.getAlldata();
      // String cata=p.getString(9);
      //  Toast.makeText(handy.this,cata,Toast.LENGTH_SHORT).show();
        while (p.moveToNext()) {

            Long id= p.getLong(0) ;
            String name1= p.getString(1) ;
            String Ar= p.getString(2) ;
            String gend= p.getString(8) ;
            String cat= p.getString(9) ;

            String cni= p.getString(4) ;

            if(cat.equalsIgnoreCase(cc)&&Ar.equalsIgnoreCase(area))
           {
               ph=p.getString(6);
                usersList.add("Ph#:"+ph);
                cnic.add("CNIC:  "+cni);
                name.add("Name: "+name1);
                gender.add("Gender: "+gend);
           }

        }

        p.close();
       lv=(ListView) findViewById(R.id.list);

      final String [] array=usersList.toArray(new String[0]);
        String [] array2=cnic.toArray(new String[0]);
        String [] array3=name.toArray(new String[0]);
        String [] array4=gender.toArray(new String[0]);
        lv=(ListView) findViewById(R.id.list);
        lv.setAdapter(new customAdapter(handy.this,array2,array,array3,array4));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

             String e=array[i];
             e=e.substring(4);
                   Toast.makeText(handy.this, "item one+ "+e, Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(Intent.ACTION_DIAL);
               intent.setData(Uri.parse("tel:"+e));
               startActivity(intent);

            }
        });


        db.close();

    }





}