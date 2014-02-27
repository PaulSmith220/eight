package com.example.eight;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Screen_1Activity  extends Activity {
    EditText ps_1;
    SharedPreferences spref;
    public static final String APP_PASSWORDS = "passwords";

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_1);

        ps_1 = (EditText) findViewById(R.id.pass_1);
        spref = getSharedPreferences(APP_PASSWORDS, Context.MODE_PRIVATE);
        if (spref.contains("pas_1")){
            String savedState = spref.getString("pas_1", "");
            ps_1.setText(savedState);
        }
    }

    public void goToStep2(View v){
        String pass = getResources().getString(R.string.pass_1);
        if (ps_1.getText().toString().equals(pass)){
            MyTask mt = new MyTask();
            mt.execute("http://katesmith.ru/eight_save.php?stage=1");

            SharedPreferences.Editor ed = spref.edit();
            ed.putString("pas_1", pass);
            ed.apply();

            Toast toast = Toast.makeText(getApplicationContext(),
                    "Всё верно !", Toast.LENGTH_SHORT);
            toast.show();

            Intent intent = new Intent(Screen_1Activity.this, Screen_2Activity.class);
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Неа, что-то другое...", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
