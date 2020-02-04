package com.example.datainput;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    DatePicker dob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText txtName = (EditText) findViewById(R.id.txtName);
        EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
         dob =(DatePicker) findViewById(R.id.dob);
        CheckBox checkbox = (CheckBox) findViewById(R.id.checkbox);
        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                displayNextAlert();
            }
        });

        dob.init(1990,5,1,null);


        

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void displayNextAlert(){
        EditText txtName = (EditText) findViewById(R.id.txtName);
        EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
        CheckBox checkbox = (CheckBox) findViewById(R.id.checkbox);

        String strName=txtName.getText().toString();
        String strdob=dob.getDayOfMonth()+
                "/" + (dob.getMonth() + 1)+
                "/" + dob.getYear();
        String strEmail= txtEmail.getText().toString();

        new AlertDialog.Builder( this).setTitle("Details entered").setMessage(
                "Details entered:\n" +strName +"/n"+ strdob+"/n"+strEmail)
                .setNeutralButton("Back",
        new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        }).show();


        }

    }

