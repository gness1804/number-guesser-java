package com.example.grahamnessler.numberguesser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int computerNumber;
    int userNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        computerNumber = domath.setRandomNum();
        String str = Integer.toString(computerNumber);
        Log.d("The computer number is ", str);
    }

    public void compareNumbers(View view) {
        TextView numberDisplayField = (TextView) findViewById(R.id.numberOutput);
        EditText userInput = (EditText) findViewById(R.id.editText);
        String textNum = userInput.getText().toString();
        String displayText = "Your last guess was: " + textNum;
        numberDisplayField.setText(displayText);
        userNumber = Integer.parseInt(textNum);
        if (userNumber > computerNumber) {
            Log.d("Message", "Your number is too high.");
        } else if (userNumber < computerNumber) {
            Log.d("Message", "Your number is too low.");
        } else {
            Log.d("Message", "You win!");
            computerNumber = domath.setRandomNum();
        }
    }
}
