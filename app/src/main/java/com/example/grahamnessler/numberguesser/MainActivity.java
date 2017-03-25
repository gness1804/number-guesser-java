package com.example.grahamnessler.numberguesser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        domath.setRandomNum();
    }

    public void compareNumbers(View view) {
        TextView output = (TextView) findViewById(R.id.numberOutput);
        EditText num = (EditText) findViewById(R.id.editText);
        String textNum = num.getText().toString();
        int val = Integer.parseInt(textNum);
        output.setText(textNum);
        domath.addNums(val);
    }
}
