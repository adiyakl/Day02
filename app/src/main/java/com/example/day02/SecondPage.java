package com.example.day02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;

public class SecondPage extends AppCompatActivity {
    private LinearLayout br2;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;

    private AlertDialog.Builder ad1;
    private AlertDialog.Builder ad2;
    private AlertDialog.Builder ad3;
    private AlertDialog.Builder ad4;
    private AlertDialog.Builder ad5;
    private Random rand = new Random();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        br2 = findViewById(R.id.br2);
        br2.setBackgroundColor(Color.rgb(255, 217, 192));
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);

        //first
        ad1 = new AlertDialog.Builder(this);
        ad1.setTitle("first: only text");
        ad1.setMessage("this is a simple alert");
        AlertDialog aad1=ad1.create();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aad1.show();
            }
        });

        //second
        ad2 = new AlertDialog.Builder(this);
        ad2.setTitle("second: gerald");
        ad2.setMessage("isn't he the cutest???");
        ad2.setIcon(R.mipmap.im1);
        AlertDialog aad2=ad2.create();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aad2.show();
            }
        });

        //third
        ad3 = new AlertDialog.Builder(this);
        ad3.setTitle("third: close option");
        ad3.setMessage("close me!");
        ad3.setIcon(R.mipmap.im1);
        ad3.setPositiveButton("bye", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              dialog.dismiss();
            }
        });
        ad3.setCancelable(false);
        AlertDialog aad3=ad3.create();
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aad3.show();
            }
        });

        //forth
        ad4 = new AlertDialog.Builder(this);
        ad4.setTitle("forth: color changing");
        ad4.setMessage("choose one!");
        ad4.setIcon(R.mipmap.im1);
        ad4.setPositiveButton("bye", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        ad4.setNegativeButton("random", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                br2.setBackgroundColor(Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));

            }
        });
        ad4.setCancelable(false);
        AlertDialog aad4=ad4.create();
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aad4.show();
            }
        });

        //fifth
        ad5 = new AlertDialog.Builder(this);
        ad5.setTitle("forth: color changing");
        ad5.setMessage("choose one!");
        ad5.setIcon(R.mipmap.im1);
        ad5.setPositiveButton("bye", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        ad5.setNegativeButton("random", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                br2.setBackgroundColor(Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));

            }
        });
        ad5.setNeutralButton("original color", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                br2.setBackgroundColor(Color.rgb(255, 217, 192));
                dialog.dismiss();
            }
        });
        AlertDialog aad5=ad5.create();
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aad5.show();
            }
        });
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