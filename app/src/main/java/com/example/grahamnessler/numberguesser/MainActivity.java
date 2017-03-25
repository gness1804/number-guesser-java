package com.example.grahamnessler.numberguesser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        domath.setRandomNum();
    }

    public void compareNumbers(View view) {
        EditText num = (EditText) findViewById(R.id.editText);
        int val = Integer.parseInt(num.getText().toString());
        domath.addNums(val);
    }
}
