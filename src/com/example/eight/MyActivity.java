package com.example.eight;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MyActivity extends Activity {

    EditText pass_main;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        pass_main = (EditText) findViewById(R.id.pass_main);
    }


    public void start(View v){
        if (pass_main.getText() == pass_main)  {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Неа, что-то другое...", Toast.LENGTH_SHORT);
            toast.show();
        }    else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Ура, начинаем!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
