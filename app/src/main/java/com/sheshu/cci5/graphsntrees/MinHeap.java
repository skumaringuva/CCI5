package com.sheshu.cci5.graphsntrees;

import com.sheshu.cci5.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: this min heap does work well, but it does not create balanced tree while creating
// Need to fix further to see how can we make it balanced..
public class MinHeap {
    int[] heap;
    int length;

    private MinHeap(int[] randomArray) {
        heap = new int[randomArray.length];
        for (int aRandomArray : randomArray) insert(aRandomArray);
    }

    private static MinHeap createRandomHeap() {
        int[] randomArray = Utils.getRandomArray(100, 100);
        System.out.println("Input: "+Arrays.toString(randomArray));
        MinHeap heap = new MinHeap(randomArray);
        printTreeLevelOrder(heap);
        return heap;
    }

    // This method will print will try to print in tree levels..
    public static void printTreeLevelOrder(MinHeap heap){

    }


    public static void test() {

        /*
        MinHeap heap = createRandomHeap();
        System.out.println("\n Max heap test: ");
        System.out.flush();

        if(heap!=null) {
            for(int i=0;i<heap.length;i++){
                System.out.println(" " + heap.removeTop()+" root: "+heap.peek());
                //printTreeLevelOrder(heap.root);
            }
        }
        System.out.flush();
    */
        System.out.println("\n"+"End Max heap test");
    }

    private int peek() {
        return length>0?heap[0]:Integer.MIN_VALUE;
    }

    private void insert(int number) {
            heap[length++] = number; // overflow check?
            heapifyUp();
    }


    private int removeTop() { return -1;}

    private void heapifyDown() {}
    void swap(int a, int b){

        int temp = a;
        a = b;
        b = temp;
        // System.out.println(" Swapping: "+a.val+" "+b.val);
    }

    private void heapifyUp(){
        int last = heap[length-1];
        int lastIndex = length-1;
        int parent = heap[(lastIndex/2) -1];
       // while(index)
        {

        }

        System.out.println("Last after heapify: ");
    }

    public int getTop() {
        return length>0?heap[0]:Integer.MIN_VALUE;
    }




}
