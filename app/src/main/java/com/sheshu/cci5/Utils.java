package com.sheshu.cci5;

import com.sheshu.cci5.lists.Node;

import java.util.Arrays;

public class Utils {
    public static int randomInteger(int max){
        // Since we always pass 0 as min, dont worry about -ve.
        // always expect max is really greater than min..
        int range = max +1;
        return ((int) (Math.random()*range));
    }

    public static void printMatrix(int[][] mat){
        int m = mat.length;

        if(m>0) {
            System.out.println("Printing Matrix-------------------------");
            int n = mat[0].length;
            for (int[] aMat : mat) {
                System.out.println(Arrays.toString(aMat));
            }
            System.out.println("Printing Matrix-End------------------------");

        }
    }

    public static Node createRandomList(int size, int maxNumber){
        if(size ==0 || maxNumber == 0)
            return null;
       Node root = new Node(randomInteger(maxNumber));
       Node cur = root;
       for(int i=0;i<size-1;i++){
           cur.next = new Node(randomInteger(maxNumber));
           cur = cur.next;
       }

       return root;
    }

    public static void printList(Node root, String message){
        System.out.println("Start"+message+": --------- ");

        while(root!=null){
            System.out.print(" "+root.val);
            root = root.next;
        }
        System.out.println();
        System.out.println("------------end: "+message);
    }

    public static int[] getRandomArray(int size, int maxNumber){
        int[] randomArray = new int[size];
        for(int i=0;i<size;i++){
            randomArray[i] = randomInteger(maxNumber);
        }
        return randomArray;
    }


}
