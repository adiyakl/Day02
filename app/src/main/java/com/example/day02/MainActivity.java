package com.example.day02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Collections;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,
        View.OnCreateContextMenuListener {
    private LinearLayout br;
    private EditText a1;
    private EditText q;
    private ListView lst;
    private TextView tw1;
    private Button bt;//button
    private Switch sw;
    private String[] str= {"h","e","l","l","o"};
    private int x;    private int y;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        br = findViewById(R.id.br);
        br.setBackgroundColor(Color.rgb(250, 240, 215));
        a1 = findViewById(R.id.a1);
        q = findViewById(R.id.q);
        lst = findViewById(R.id.lst);
        tw1 = findViewById(R.id.tw1);//מיקום איבר או סכום סדרה עד עכשיו
        bt = findViewById(R.id.butt);
        sw = findViewById(R.id.swit);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(getApplicationContext(), androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, str);
        lst.setAdapter(adp);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = Integer.parseInt(a1.getText().toString());
                y = Integer.parseInt(q.getText().toString());
                if (sw.isChecked()) {
                    str[0] = String.valueOf(x);
                    str[1] = String.valueOf(x * y);
                    str[2] = String.valueOf(x * y * y);
                    str[3] = String.valueOf(x * y * y * y);
                    str[4] = String.valueOf(x * y * y * y * y);
                } else {
                    str[0] = String.valueOf(x);
                    str[1] = String.valueOf(x + y);
                    str[2] = String.valueOf(x + y + y);
                    str[3] = String.valueOf(x + y + y + y);
                    str[4] = String.valueOf(x + y + y + y + y);
                }
               // ArrayAdapter<String> adp = new ArrayAdapter<String>(getApplicationContext(), androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, str);
                lst.setAdapter(adp);
            }
        });


        lst.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lst.setOnItemClickListener(this);

        lst.setOnCreateContextMenuListener(this);//מאזין לתפריט
        registerForContextMenu(lst);//
    }




    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {//יוצר תפריט נשלף

        menu.setHeaderTitle("what will u want to see?");
        menu.add("location");
        menu.add("sum");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        //<3
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int pos = info.position+1; // This gives you the position of the item in the ListView
        int sum=0;
        String w = item.getTitle().toString();
        View loc = item.getActionView();
        if(w.equals("location")){
            tw1.setText(String.valueOf(pos));
            Toast t1 = Toast.makeText(this,String.valueOf(pos),Toast.LENGTH_SHORT);
            t1.show();
        }
        if(w.equals("sum")){
            if(sw.isChecked()){
                sum = (pos / 2) * (2 * x + (pos - 1) * y);//חישוב סכום סדרה חשבונית
            }
            else{
                sum = (int) (x * (Math.pow(y, pos) - 1) / (y - 1));//סכום סדרה הנדסית?
            }
            tw1.setText(String.valueOf(sum));
            Toast t2 = Toast.makeText(this,String.valueOf(sum),Toast.LENGTH_SHORT);
            t2.show();
        }
        return super.onContextItemSelected(item);
    }

    @Override//לצרף תפריט נשלף כאן לכל מדף
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        menu.add(0,0,400,"wtf");
        return super.onCreateOptionsMenu(menu);
    }

    //תפריט אפשרויות
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
        else if (st.equals("wtf")) {
            br.setBackgroundColor(Color.rgb(204, 238, 188));
        }
        else if (st.equals("custom dialog")) {
            Intent in3  = new Intent(this, ThirdPage.class);
            startActivity(in3);
        }
        return super.onOptionsItemSelected(item);
    }
}