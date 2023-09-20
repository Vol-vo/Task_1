//task 4

import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args){
        runTask(700000);
    }


    private static void runTask(int size){
        for (int i = 0; i < 1000; i++){
            int [] localData = randomArray(size);
            sort(localData);
        }
        int [] data = randomArray(size);
        long startTime = System.nanoTime(); //время в наносекундах
        sort(data);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime));
    }

    private static void sort(int[] a){
        int cntPlus = 0;
        int cntMinus = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i] < 0) {
                cntMinus++;
            }
            else {
                cntPlus++;
            }
        }
        int countPos = 0;
        int countNeg = 0;
        int [] negativeData = new int[cntMinus];
        int [] positiveData = new int[cntPlus];
        int [] finalArray = new int[a.length];
        for (int i = 0; i < a.length; i++){
            if (a[i] < 0){
                negativeData[countNeg] = a[i];
                countNeg++;
            }
            else {
                positiveData[countPos] = a[i];
                countPos++;
            }
        }
        for (int i = 0; i < a.length; i++){
            if (i < cntMinus) {
                finalArray[i] = negativeData[i];
            }else{
                finalArray[i] = positiveData[i - cntMinus];
            }
        }
    }

    private static int[] randomArray(int size){
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int)(Math.random() * 1001) - 500);
        }
        return array;
    }
}
