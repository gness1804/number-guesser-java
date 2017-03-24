package com.example.grahamnessler.numberguesser;

import android.util.Log;

import java.util.Random;

/**
 * Created by grahamnessler on 3/24/17.
 */

public class domath {
    public static void addNums (int val) {
        int userNum = val;
        Random rand = new Random();
        int  computerNum = rand.nextInt(50) + 1;
        if (userNum > computerNum) {
            Log.d("Message", "Your number is too high.");
        } else if (userNum < computerNum) {
            Log.d("Message", "Your number is too low.");
        } else {
            Log.d("Message", "You win!");
        }
    }
}
