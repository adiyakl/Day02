package com.example.day02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ThirdPage extends AppCompatActivity {
    private LinearLayout br3;
    AlertDialog.Builder adb ;
    LinearLayout mydialog;
    EditText eTName,eTPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_page);
        br3 = findViewById(R.id.br3);
        br3.setBackgroundColor(Color.rgb(140, 192, 222));
    }









    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        String st = item.getTitle().toString();
        if (st.equals("calculator")) {
            Intent in  = new Intent(this, MainActivity.class);
            startActivity(in);
        }
        else if (st.equals("dialog")) {
            Intent in2  = new Intent(this, SecondPage.class);
            startActivity(in2);
        }
        else if (st.equals("custom dialog")) {
            Intent in3  = new Intent(this, ThirdPage.class);
            startActivity(in3);
        }
        return super.onOptionsItemSelected(item);
    }

}