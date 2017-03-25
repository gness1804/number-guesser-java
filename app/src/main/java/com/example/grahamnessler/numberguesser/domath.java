package com.example.grahamnessler.numberguesser;

import android.util.Log;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by grahamnessler on 3/24/17.
 */

public class domath {
    static int userNum;
    static int computerNum;
    public static int setRandomNum () {
        Random rand = new Random();
        computerNum = rand.nextInt(50) + 1;
        return computerNum;
    }

    public static void displayUserNum (int val) {

    }

    public static void addNums (int val) {
        userNum = val;
        displayUserNum(userNum);
        if (userNum > computerNum) {
            Log.d("Message", "Your number is too high.");
        } else if (userNum < computerNum) {
            Log.d("Message", "Your number is too low.");
        } else {
            Log.d("Message", "You win!");
            setRandomNum();
        }
    }
}
