package com.example.project3;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class admin extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName,editSurname;
    Button btnAddData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getSupportActionBar().setTitle(" Admin Form");
        myDb = new DatabaseHelper(this);
        editName = (EditText)findViewById(R.id.em);
        editSurname = (EditText)findViewById(R.id.pass);
        btnAddData = (Button)findViewById(R.id.bt);
        AddData();



    }


    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData("Admin67@gmail.com", "Admin1234");

                        final ProgressDialog processdialog= new  ProgressDialog(admin.this);
                        processdialog.setTitle("processing");
                        processdialog.setMessage("Loading....Please...Wait");
                        CountDownTimer ctd=new CountDownTimer(3000,1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                processdialog.dismiss();
                            }
                        };
                        ctd.start();
                        processdialog.show();
                        if(editName.getText().toString().equals("Admin67@gmail.com")&&editSurname.getText().toString().equals("Admin1234"))
                        {
                            Toast.makeText(admin.this,"Login Sucessfuy",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(admin.this,Showinghandymandataforadmin.class);
                            startActivity(intent);
                        }
                        else
                        {
                            AlertDialog.Builder builder=new AlertDialog.Builder(admin.this);
                            builder.setMessage("Wrong Email and Password ?");
                            builder.setCancelable(false);
                            builder.setPositiveButton("ok", new DialogInterface.OnClickListener()
                            {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();

                                }
                            });

                            //Creating dialog box
                            AlertDialog alert = builder.create();
                            //Setting the title manually
                            alert.setTitle("Plz Enter Again");
                            alert.show();
                        }








                    }
                }
        );

    }





    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }



}