package com.example.grahamnessler.numberguesser;

import java.util.Random;

/**
 * Created by grahamnessler on 3/24/17.
 */

public class domath {

    public static int setRandomNum () {
        Random rand = new Random();
        int computerNum = rand.nextInt(50) + 1;
        return computerNum;
    }

}
