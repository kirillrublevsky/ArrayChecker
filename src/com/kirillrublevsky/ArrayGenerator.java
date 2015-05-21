package com.kirillrublevsky;

import java.util.Random;

public class ArrayGenerator {

    private static Random random = new Random();

    public static int[] generateNewArray(){
        return fillArrayWithNumbers(getEmptyArray());
    }

    private static int[] getEmptyArray(){
        int size = random.nextInt(20) + 5;
        return new int[size];
    }

    private static int[] fillArrayWithNumbers(int[] array){
        for(int i = 0; i < array.length; i++){
            array[i] = generateNumber();
        }
        return array;
    }

    private static int generateNumber(){
        int number = random.nextInt(100);
        if (random.nextDouble() >= 0.5){
            number *= -1;
        }
        return number;
    }
}
