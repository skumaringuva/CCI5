package com.sheshu.cci5.stacks;

import com.sheshu.cci5.Utils;
import com.sheshu.cci5.lists.Node;

import java.util.Arrays;

public class SingleArrayThreeStacks {
    private static final int ARRAY_LEN = 105;

    int[] array = new int[ARRAY_LEN];
    // Lets divide the tasks into 3.
    // first left to right
    // 2nd right to left from 2/3
    // 3rd left to right from 2/3
    // This way we can have 2 stacks to have maximum size utilization.
    int [] tops = {0,ARRAY_LEN*2/3,ARRAY_LEN*2/3+1};
    int [] direction = {1,-1,1};

    void push(Node node, int stack){
        System.out.println("inserting: "+node.val+" stack: "+stack+" top: "+tops[stack]);
        array[tops[stack]] = node.val;
        tops[stack]+=direction[stack];
    }
    Node pop(int stack){

       Node node = new Node( array[tops[stack]]);

       tops[stack]-=((direction[stack]*-1));
       return node;

    }

    int peek(int stack){
       return array[tops[stack]];
    }


    private static void testThreeStacks(){

       Node listRoot = Utils.createRandomList(100,100);
       SingleArrayThreeStacks threeStacks = new SingleArrayThreeStacks();
       int i=1;
       while (listRoot!=null){
           Node next = listRoot.next;

           listRoot.next = null;
           threeStacks.push(listRoot,i%threeStacks.tops.length);
           listRoot = next;
           if(++i%10 == 0)
               System.out.print(Arrays.toString(threeStacks.array));
       }





    }

    public static void test(){
        testThreeStacks();
    }

}
