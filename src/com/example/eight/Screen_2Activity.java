package com.example.eight;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Screen_2Activity extends Activity {

    EditText ps_2;
    SharedPreferences spref;
    public static final String APP_PASSWORDS = "passwords";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_2);
        ps_2 = (EditText) findViewById(R.id.pass_2);

        spref = getSharedPreferences(APP_PASSWORDS, Context.MODE_PRIVATE);
        if (spref.contains("pas_2")){
            String savedState = spref.getString("pas_2", "");
            ps_2.setText(savedState);
        }
    }


    public void goStep3(View v){
        String pass = getResources().getString(R.string.pass_2);
        if (ps_2.getText().toString().equals(pass)){
            MyTask mt = new MyTask();
            mt.execute("http://katesmith.ru/eight_save.php?stage=2");

            SharedPreferences.Editor ed = spref.edit();
            ed.putString("pas_2", pass);
            ed.apply();

            Toast toast = Toast.makeText(getApplicationContext(),
                    "Всё верно !", Toast.LENGTH_SHORT);
            toast.show();

            Intent intent = new Intent(Screen_2Activity.this, Screen_3Activity.class);
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Неа, что-то другое...", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}