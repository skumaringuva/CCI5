package com.sheshu.cci5.searches;

import com.sheshu.cci5.Utils;

import java.util.Arrays;


public class BinarySearch {

    public static void test(){

        int[] input = Utils.getRandomArray(100,100);
        Arrays.sort(input);
        int search = input[Utils.randomInteger(99)]; // something random.

        System.out.println("Testing binary search input: "+Arrays.toString(input)+" \n: find: "+search);
        System.out.println(" found Item: "+binarySearch(input,0,input.length,search));
    }

    private static int binarySearch(int[] input,int start, int end, int num){
        int midIndex = start+(end-start)/2;
        System.out.println("searching start: "+start+" to end: "+end);
        System.out.flush();
        if(num>input[midIndex]){
            return binarySearch(input,midIndex,end,num);
        }else if(num<input[midIndex]){
            return binarySearch(input,start,midIndex,num);
        }
        return midIndex;
    }

}
