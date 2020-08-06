package com.example.project3;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
public class Showinghandymandataforadmin extends AppCompatActivity {
    ListView lv;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    String ph;
    String e1;
    String ER,rt1,rt;
    Integer n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_showinghandymandataforadmin);
        getSupportActionBar().setTitle("List Of Handymans");
        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getReadableDatabase();
        final List<String> usersList1 = new ArrayList<String>();
        final List<String> usersList = new ArrayList<String>();
        final List<String> cnic = new ArrayList<String>();
        final List<String> name = new ArrayList<String>();
        final List<String> gender = new ArrayList<String>();
        final Cursor p = dbHelper.getAlldata();
        while (p.moveToNext()) {

            Long id = p.getLong(0);
            String name1 = p.getString(1);
            String Ar = p.getString(2);
            String gend = p.getString(8);
            String cat = p.getString(9);
            String cni = p.getString(4);
            ph=p.getString(6);
            usersList.add("Ph#:"+ph);
             String ph1=p.getString(0);
            usersList1.add("ID:"+ph1);
            cnic.add("CNIC:  "+cni);
            name.add("Name: "+name1);
            gender.add("Gender: "+gend);


                }
        p.close();
        lv=(ListView) findViewById(R.id.list);
        final String [] array1=usersList1.toArray(new String[0]);
        final String [] array=usersList.toArray(new String[0]);
        final String [] array2=cnic.toArray(new String[0]);
        String [] array3=name.toArray(new String[0]);
        String [] array4=gender.toArray(new String[0]);
        lv=(ListView) findViewById(R.id.list);
        lv.setAdapter(new customAdapter1(Showinghandymandataforadmin.this,array2,array,array3,array4));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               String e1=array1[i];
                ER=e1.toString();
                 rt=ER.substring(5);
                 rt1=rt.toString();
                Integer deletedRows = dbHelper.delete12Data("4356");



            }
        });
        registerForContextMenu(lv);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextmenu, menu);

    }
    @Override

    public boolean onContextItemSelected(MenuItem item) {



        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {

            case R.id.about_delete:

                    Toast.makeText(getApplicationContext(), "Data Deleted", Toast.LENGTH_SHORT).show();



                return true;



            default:
                return super.onContextItemSelected(item);
        }
    }





}




































