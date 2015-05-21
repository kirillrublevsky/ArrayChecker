package com.kirillrublevsky;

import static com.kirillrublevsky.ArrayChecker.findMaxSumSequence;
import static com.kirillrublevsky.ArrayGenerator.generateNewArray;

public class Application {

    public static void main(String[] args) {

        int[] array = generateNewArray();
        findMaxSumSequence(array);
    }
}
