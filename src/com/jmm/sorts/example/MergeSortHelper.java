package com.jmm.sorts.example;

import java.util.Arrays;
import java.util.logging.Logger;

public class MergeSortHelper {

    public static void sort(int[] array,int arraySize){

      //  System.out.println("sort-> array" + Arrays.toString(array) + " size:" + arraySize);
        if (arraySize < 2) {
            return;
        }
        int mid = arraySize/2;
        int rightSize = arraySize - mid;
        int [] leftArray = new int[mid];
        int [] rightArray = new int[rightSize];
        for (int i = 0; i < mid; i++) {
            leftArray[i] = array[i];
        }
        for (int i = mid; i < arraySize; i++) {
            rightArray[i - mid] = array[i];
        }
        sort(leftArray,mid);
        sort(rightArray,rightSize);
      //  System.out.println("leftArray:" + Arrays.toString(leftArray) + " mid:"+ mid);
      //  System.out.println("rightArray:" + Arrays.toString(rightArray) + " mid:"+ rightSize);
        merge(array,leftArray,rightArray,mid,rightSize);

    }

    private static void merge(int[] array, int[] leftArray, int[] rightArray, int leftSize, int rightSize) {
        int leftCount = 0;
        int rightCount = 0;
        int arrayCount = 0;
      //  System.out.println("merge");
        while(leftCount < leftSize && rightCount < rightSize){
            if (leftArray[leftCount] <= rightArray[rightCount]){
                array[arrayCount++] = leftArray[leftCount++];
            }else {
                array[arrayCount++] = rightArray[rightCount++];
            }
        }

        while (leftCount < leftSize){
         //   System.out.println("left already has more to process");
            array[arrayCount++] = leftArray[leftCount++];
        }
        while (rightCount < rightSize){
         //   System.out.println("right already has more to process");
            array[arrayCount++] = rightArray[rightCount++];
        }
    }
}
