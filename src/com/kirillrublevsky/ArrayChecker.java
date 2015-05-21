package com.kirillrublevsky;


import java.util.Arrays;

import static java.lang.System.arraycopy;

public class ArrayChecker {

    public static void findMaxSumSequence(int[] array){
        int[] maxSumSequence = getMaxArray(array);
        int maxSum = getSum(maxSumSequence, 0, maxSumSequence.length);

        System.out.println("The initial array is: " + Arrays.toString(array));
        System.out.println("Sequence of numbers with maximal sum is: " + Arrays.toString(maxSumSequence));
        System.out.println("The maximal sum is: " + maxSum);
    }



    private static int[] getMaxArray(int[] array){
        int[] maxArray = array;
        int[] leftArray;
        int[] rightArray;
        int leftArraySum;
        int rightArraySum;

        do {
            leftArray = getLeftArray(maxArray);
            rightArray = getRightArray(maxArray);
            leftArraySum = getSum(leftArray, 0, leftArray.length);
            rightArraySum = getSum(rightArray, 0, rightArray.length);

            if (leftArraySum > rightArraySum) {
                maxArray = leftArray;
            } else if (leftArraySum < rightArraySum) {
                maxArray = rightArray;
            } else {
                if (leftArray.length < rightArray.length) {
                    maxArray = leftArray;
                } else {
                    maxArray = rightArray;
                }
            }
        }
        while (!((leftArraySum == rightArraySum) && (leftArray.length == rightArray.length)));

        return maxArray;
    }

    private static int[] getLeftArray(int[] array){
        int leftSum = 0;
        int indexMaxSum = 0;
        int maxArrayLength = array.length;

        for (int i = 0; i < maxArrayLength; i++){
            int currentSum = getSum(array, i, maxArrayLength);
            if((currentSum) >= leftSum){
                leftSum = currentSum;
                indexMaxSum = i;
            }
        }
        int[] resultArray = new int[maxArrayLength - indexMaxSum];
        arraycopy(array, indexMaxSum, resultArray, 0, (maxArrayLength - indexMaxSum));
        return resultArray;
    }

    private static int[] getRightArray(int[] array){
        int rightSum = 0;
        int indexMaxSum= 0;
        int maxArrayLength = array.length;

        for (int i = maxArrayLength; i > 0; i--){
            int currentSum = getSum(array, 0, i);
            if((currentSum) >= rightSum){
                rightSum = currentSum;
                indexMaxSum = i - 1;
            }
        }
        int[] resultArray = new int[indexMaxSum + 1];
        arraycopy(array, 0, resultArray, 0, (indexMaxSum + 1));
        return resultArray;
    }

    private static int getSum(int[] array, int from, int to){
        int sum = 0;
        for (int i = from; i < to; i++){
            sum += array[i];
        }
        return sum;
    }


}
