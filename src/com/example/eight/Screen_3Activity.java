package com.example.eight;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Screen_3Activity extends Activity {

    TextView tq, pass_3;
    SharedPreferences spref;
    public static final String APP_PASSWORDS = "passwords";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_3);
        tq = (TextView) findViewById(R.id.scr3_q);
        pass_3 = (TextView) findViewById(R.id.pass_3);
        spref = getSharedPreferences(APP_PASSWORDS, Context.MODE_PRIVATE);
        if (spref.contains("pas_3")){
            String savedState = spref.getString("pas_3", "");
            pass_3.setText(savedState);
        }
    }

    public void showQ(View v){
        tq.setVisibility(tq.getVisibility()==1? 0 : 1);
    }


    public void finalCheck(View v){
        goStep3(v);
    }

    public void goStep3(View v){
        String pass = getResources().getString(R.string.pass_3);
        if (pass_3.getText().toString().equals(pass)){
            MyTask mt = new MyTask();
            mt.execute("http://katesmith.ru/eight_save.php?stage=3&json={hint:" + (tq.getVisibility() == 0? "true" : "false") +"}");

            SharedPreferences.Editor ed = spref.edit();
            ed.putString("pas_3", pass);
            ed.apply();

            Toast toast = Toast.makeText(getApplicationContext(),
                    "Всё верно !", Toast.LENGTH_SHORT);
            toast.show();

            //Intent intent = new Intent(Screen_3Activity.this, Screen_3Activity.class);
            //startActivity(intent);
            setContentView(R.layout.screen_4);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Неа, что-то другое...", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}