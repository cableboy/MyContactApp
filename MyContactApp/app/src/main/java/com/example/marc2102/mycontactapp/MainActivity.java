package com.example.marc2102.mycontactapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    DataHelper myDb;
    EditText editName;
    Button btnaddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DataHelper(this);

        //add the layout bars
        editName = (EditText) findViewById(R.id.editText_name);
    }


    public void addData(View v) {

        boolean isInserted = myDb.insertData(editName.getText().toString());

        if (isInserted == true) {
            Log.d("MyContact", "Success inserting data");
            //insert Toast message here

        } else {
            Log.d("MyContact", "Failure inserting data");
            //insert Toast message here

        }
    }
}

