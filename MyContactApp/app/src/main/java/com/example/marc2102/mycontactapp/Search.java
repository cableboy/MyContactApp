package com.example.marc2102.mycontactapp;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by marc2102 on 5/19/2017.
 */
public class Search extends AppCompatActivity {

    DataHelper myDb;
    EditText search;
    public Button butl;


    

    @Override
    protected void onCreate(Bundle savedInstanaceState){
        super.onCreate(savedInstanaceState);
        setContentView(R.layout.contacts);


    }

    public void viewData(View v) {

        Context context = getApplicationContext();
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
            showMessage("Error", "No data is found in the database");
            //output a message using Log.d and toast
            return;
        }

        StringBuffer buffer = new StringBuffer();
        //setup a loop with the Cursor (res) using moveToNext
        for (int i = 0; i < res.getColumnCount(); i++) {
            buffer.append(res.getColumnName(i));
            buffer.append("\t");
        }
        buffer.append("\n");
        res.moveToFirst();
        do {

            for (int i = 0; i < res.getColumnCount(); i++) {
                buffer.append(res.getString(i));
                buffer.append("\t");
            }

            buffer.append("\n");
        }
        while (res.moveToNext()) ;
        showMessage("Data", buffer.toString());
    }

    private void showMessage(String title, String message) {
        //AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
