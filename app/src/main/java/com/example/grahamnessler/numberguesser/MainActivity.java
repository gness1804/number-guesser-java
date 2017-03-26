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
    int min = 1;
    int max = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        computerNumber = domath.setRandomNum(min, max);
        String str = Integer.toString(computerNumber);
        Log.d("The computer number is ", str);
    }

    public void setMinMax (View view) {
        EditText userMin = (EditText) findViewById(R.id.userMin);
        EditText userMax = (EditText) findViewById(R.id.userMax);
        String userMinStr = userMin.getText().toString();
        String userMaxStr = userMax.getText().toString();
        int userMinInt = Integer.parseInt(userMinStr);
        int userMaxInt = Integer.parseInt(userMaxStr);
        if (userMinInt >= userMaxInt) {
            throw  new  Error("Oops! Your min must be less than your max!");
        }
        if (userMinStr.length() > 0) {
            min = userMinInt;
        }
        if (userMaxStr.length() > 0) {
            max = userMaxInt;
        }
        if (userMinStr.length() > 0 || userMaxStr.length() > 0) {
            computerNumber = domath.setRandomNum(min, max);
            String str = Integer.toString(computerNumber);
            Log.d("The computer number is ", str);
        }
    }

    public void compareNumbers(View view) {
        TextView numberDisplayField = (TextView) findViewById(R.id.numberOutput);
        TextView messageField = (TextView) findViewById(R.id.guessClue);

        EditText userInput = (EditText) findViewById(R.id.editText);

        String textNum = userInput.getText().toString();
        String displayText = "Your last guess was: " + textNum;
        numberDisplayField.setText(displayText);
        userNumber = Integer.parseInt(textNum);

        if (userNumber > computerNumber) {
            String message = "Your number is too high.";
            messageField.setText(message);
        } else if (userNumber < computerNumber) {
            String message = "Your number is too low.";
            messageField.setText(message);
        } else {
            String message = "You win!";
            messageField.setText(message);
            computerNumber = domath.setRandomNum(min, max);
            String str = Integer.toString(computerNumber);
            Log.d("The computer number is ", str);
        }
    }
}
