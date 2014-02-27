package com.example.eight;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Screen_3Activity extends Activity {

    TextView tq;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_3);
        tq = (TextView) findViewById(R.id.scr3_q);
    }

    public void showQ(View v){
        tq.setVisibility(tq.getVisibility()==1? 0 : 1);
    }

    // О прочтении подсказки сообщать в параметре json
}