package com.example.project3;
import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import static com.example.project3.DatabaseContract.Users.TABLE_NAME;

public class handymanform extends AppCompatActivity {
    DatabaseHelper myDb;
RadioGroup radioGroup;
EditText rt1;
RadioButton radioButton;
    SQLiteDatabase bb;
    Button b1 ;
String se,A;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handymanform);
        Intent intent=getIntent();
         String p=intent.getStringExtra("cn");
        Toast.makeText(getApplicationContext(), "Data "+p, Toast.LENGTH_SHORT).show();
        EditText rt123 = findViewById(R.id.ede);
        rt123.setText(p);

       b1 = findViewById(R.id.t81);
        getSupportActionBar().setTitle("HandyMan Form");
        radioGroup= findViewById(R.id.t6);
        myDb= new DatabaseHelper(this);
       EditText rt = findViewById(R.id.et1);
        rt.addTextChangedListener(T1);
        EditText rt23 = findViewById(R.id.p);
        rt23.addTextChangedListener(T1);
        EditText rt1 = findViewById(R.id.ede);
        rt1.addTextChangedListener(T1);
        ImageView imageView = findViewById(R.id.t87);
        ImageView imageView1 = findViewById(R.id.pl);
        TextView textView1 = findViewById(R.id.t7);
        final AutoCompleteTextView textView = findViewById(R.id.t7);
        final AutoCompleteTextView textVie = findViewById(R.id.areas);
        final String[] ser = getResources().getStringArray(R.array.services);
        final String[] ar = getResources().getStringArray(R.array.aa);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ar);
        textVie.setAdapter(adapter1);
        textVie.setThreshold(1);
        textVie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(handymanform.this,ar[i], Toast.LENGTH_SHORT).show();
                A=ar[i].toString();
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ser);
        textView.setAdapter(adapter);
        textView.setThreshold(1);
        textView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                se=ser[i].toString();
            }
        });



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.showDropDown();

            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textVie.showDropDown();
            }
        });


    }




    private TextWatcher T1 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            EditText rt = findViewById(R.id.et1);
            EditText rt1 = findViewById(R.id.ede);
            EditText rt23 = findViewById(R.id.p);

            String et22 = rt.getText().toString();
            String et223 = rt1.getText().toString();
            String et2234 = rt23.getText().toString();

            b1.setEnabled(!et22.isEmpty() && !et223.isEmpty() && !et2234.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public  void checkbutton(View v)
    {
        int radioId=radioGroup.getCheckedRadioButtonId();
        radioButton=findViewById(radioId);
    }


    public void register(View view)
    {
        bb = myDb.getWritableDatabase();
        EditText rt = findViewById(R.id.et1);
        EditText rt23 = findViewById(R.id.p);
        EditText rt25 = findViewById(R.id.D);
        EditText rt26 = findViewById(R.id.rto);
        EditText rt1 = findViewById(R.id.ede);
        EditText r77 = findViewById(R.id.mult);
        String val1 = rt.getText().toString();
        String val6 = rt23.getText().toString();
        String val5 = rt25.getText().toString();
        String val3 = rt26.getText().toString();
        String val4 = rt1.getText().toString();
        String val7 = r77.getText().toString();
        String val8 = radioButton.getText().toString();
       boolean isInserted = myDb.insertDataa(val1,A,val3,val4,val5,val6,val7,val8,se);

        if(isInserted == true) {
            Intent yu = new Intent(handymanform.this, message.class);
            startActivity(yu);

        }
        else


            Toast.makeText(handymanform.this,"Data  not Inserted",Toast.LENGTH_LONG).show();




    }



}