package com.hy.demo.demo.study;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class MaoPaoSort {


    public static void main(String[] args) {
        Integer[] intArray = {1,9,2,5,3,5};
        Integer[] intArray1 = {1,9,2,5,3,5};
       long time =  System.currentTimeMillis();
        Comparator<Integer> compare = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1- o2;
            }
        };
       sort(rad(), compare);
       System.out.println(System.currentTimeMillis()-time);
       time = System.currentTimeMillis();
       sort1(rad(), compare);
        System.out.println(System.currentTimeMillis()-time);
    }

    public static <T> void sort(int[] array, Comparator<T> compare) {
        if (array.length < 2) return;
        boolean swapped = true;
        for (int i = 1,len = array.length; i < len&&swapped; i++) {
            swapped = false;
            for (int j=0;j<len-i;j++){
                if( array[j]-(array[j+1])>0) {
                   int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }
            }
        }
    }

    public static <T> void sort1(int[] array, Comparator<T> compare) {
        if (array.length < 2) return;
        for (int i = 0,len = array.length; i < len; i++) {
            for (int j=0;j<len-1;j++){
                if( array[i]-array[j]>0) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public  static  int [] rad(){
        Random r = new Random(10000);
        int[] a = new int[1000];
        int i = 0;
        while ( i>1000){
            a[1] = r.nextInt();
            i++;
        }
        return a;

    }

}
