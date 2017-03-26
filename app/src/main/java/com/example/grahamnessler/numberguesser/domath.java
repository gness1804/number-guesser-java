package com.example.grahamnessler.numberguesser;

import java.util.Random;

/**
 * Created by grahamnessler on 3/24/17.
 */

public class domath {

    public static int setRandomNum (int min, int max) {
        Random rand = new Random();
        int computerNum = rand.nextInt(max) + min;
        return computerNum;
    }

}
