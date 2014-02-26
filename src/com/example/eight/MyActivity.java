package com.example.eight;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.content.SharedPreferences.Editor;

import java.util.concurrent.TimeUnit;

public class MyActivity extends Activity {

    EditText pass_main;
    SharedPreferences spref;
    public static final String APP_PASSWORDS = "passwords";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        pass_main = (EditText) findViewById(R.id.pass_main);

        spref = getSharedPreferences(APP_PASSWORDS, Context.MODE_PRIVATE);
        if (spref.contains("pas_0")){
            String savedState = spref.getString("pas_0", "");
            pass_main.setText(savedState);
        }

    }


    public void start(View v){
        if (! pass_main.getText().toString().equals(getResources().getString(R.string.pass_main)))  {
            if (pass_main.getText().toString().equals( "clear")){
                SharedPreferences.Editor ed = spref.edit();
                ed.clear();
                ed.apply();
                ed.commit();
                Log.d("PREF", "++++++++   ");


            }
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Неа, что-то другое...", Toast.LENGTH_SHORT);
            toast.show();
        }    else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Ура, начинаем!", Toast.LENGTH_SHORT);
            toast.show();

                Editor ed = spref.edit();
                ed.putString("pas_0", "123");
                ed.apply();


            goNext();
        }
    }

    public void goNext(){
        MyTask mt = new MyTask();
        mt.execute("http://katesmith.ru/eight_save.php?stage=0");
        Intent intent = new Intent(MyActivity.this, Screen_1Activity.class);
        startActivity(intent);
    }
}
