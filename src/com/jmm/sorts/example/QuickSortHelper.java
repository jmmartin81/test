package com.jmm.sorts.example;

import java.util.Arrays;
import java.util.Random;

public class QuickSortHelper {

    public static void sort(int[]array,int indexLow, int indexHigh){
        if (indexLow>= indexHigh){
            return;
        }
        Random r = new Random();
        int pivotIndex = r.nextInt(indexHigh - indexLow ) + indexLow;
        int pivot = array[pivotIndex];
        swap(array,pivotIndex, indexHigh);
        int leftPointer = partition(array,indexLow,indexHigh,pivot);
        sort(array,indexLow,leftPointer -1 );
        sort(array,leftPointer+1,indexHigh);
    }

    private  static int  partition(int[] array, int indexLow, int indexHigh,int pivot) {
        int leftPointer = indexLow;
        int rightPointer = indexHigh;
        while (leftPointer < rightPointer){
            while (array[leftPointer] <= pivot && leftPointer < rightPointer ){
                leftPointer++;
            }
            while (array[rightPointer] >= pivot && leftPointer < rightPointer ){
                rightPointer -- ;
            }
            swap(array,leftPointer,rightPointer);
        }
        swap(array,leftPointer,indexHigh);
        return leftPointer;
    }

    private static void swap(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }
}
