package com.example.grahamnessler.numberguesser;

import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int computerNumber;
    int userNumber;
    int min = 1;
    int max = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNewRandomNumber();
        displayMinMax();
        logComputerNum();
        styleTheApp();
    }

    public void styleTheApp () {
        TextView numberDisplayField = (TextView) findViewById(R.id.numberOutput);
        TextView messageField = (TextView) findViewById(R.id.guessClue);
        numberDisplayField.setTypeface(null, Typeface.BOLD);
        messageField.setTypeface(null, Typeface.BOLD);
        numberDisplayField.setTextSize(24);
        messageField.setTextSize(24);
    }

    public void clearInputFields () {
        EditText userInput = (EditText) findViewById(R.id.mainNumberInput);
        EditText userMin = (EditText) findViewById(R.id.userMin);
        EditText userMax = (EditText) findViewById(R.id.userMax);
        userInput.setText("");
        userMin.setText("");
        userMax.setText("");
    }

    public void clearNotificationFields () {
        TextView numberDisplayField = (TextView) findViewById(R.id.numberOutput);
        TextView messageField = (TextView) findViewById(R.id.guessClue);
        numberDisplayField.setText("");
        messageField.setText("");
    }

    public void adjustMinAndMaxByTen () {
        min = min - 10;
        max = max + 10;
        displayMinMax();
    }

    public void logComputerNum () {
        String str = Integer.toString(computerNumber);
        Log.d("The computer number is ", str);
    }

    public void setNewRandomNumber () {
        computerNumber = domath.setRandomNum(min, max);
    }

    public void displayMinMax () {
        TextView minField = (TextView) findViewById(R.id.minOutput);
        String message1 = "Current Min: " + min;
        minField.setText(message1);
        TextView maxField = (TextView) findViewById(R.id.maxOutput);
        String message2 = "Current Max: " + max;
        maxField.setText(message2);
    }

    public void notifyUserOfNewRandomNum () {
        Context context = getApplicationContext();
        CharSequence text = "New random number generated!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void showMinMaxErrorToast () {
        Context context = getApplicationContext();
        CharSequence text = "Oops! Your min must be less than your max!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void resetGame(View view) {
        min = 1;
        max = 50;
        setNewRandomNumber();
        displayMinMax();
        logComputerNum();
        notifyUserOfNewRandomNum();
        clearInputFields();
        clearNotificationFields();
    }

    public void setMinMax (View view) {
        EditText userMin = (EditText) findViewById(R.id.userMin);
        EditText userMax = (EditText) findViewById(R.id.userMax);
        String userMinStr = userMin.getText().toString();
        String userMaxStr = userMax.getText().toString();
        int userMinInt = Integer.parseInt(userMinStr);
        int userMaxInt = Integer.parseInt(userMaxStr);
        if (userMinInt >= userMaxInt) {
           showMinMaxErrorToast();
            return;
        }
        if (userMinStr.length() > 0) {
            min = userMinInt;
        }
        if (userMaxStr.length() > 0) {
            max = userMaxInt;
        }
        if (userMinStr.length() > 0 || userMaxStr.length() > 0) {
            setNewRandomNumber();
            displayMinMax();
            logComputerNum();
            notifyUserOfNewRandomNum();
            clearInputFields();
        }
    }

    public void compareNumbers(View view) {
        TextView numberDisplayField = (TextView) findViewById(R.id.numberOutput);
        TextView messageField = (TextView) findViewById(R.id.guessClue);

        EditText userInput = (EditText) findViewById(R.id.mainNumberInput);

        String textNum = userInput.getText().toString();
        String displayText = "Your last guess was: " + textNum;
        numberDisplayField.setText(displayText);
        userNumber = Integer.parseInt(textNum);

        if (userNumber > max) {
            String message = "Your number is above the max. Please try again.";
            messageField.setText(message);
        } else if (userNumber < min) {
            String message = "Your number is below the min. Please try again.";
            messageField.setText(message);
        } else if (userNumber > computerNumber) {
            String message = "Your number is too high.";
            messageField.setText(message);
        } else if (userNumber < computerNumber) {
            String message = "Your number is too low.";
            messageField.setText(message);
        } else {
            String message = "You win!";
            messageField.setText(message);
            setNewRandomNumber();
            adjustMinAndMaxByTen();
            logComputerNum();
            notifyUserOfNewRandomNum();
        }
        clearInputFields();
    }
}
