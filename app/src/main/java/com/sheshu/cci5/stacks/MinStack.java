package com.sheshu.cci5.stacks;

import com.sheshu.cci5.Utils;
import com.sheshu.cci5.lists.Node;

public class MinStack  extends Stack{


    /*
    *
    *  x <min
    *  x-min <0
    *  x-min+x<x+0
    *  2x-min<x -- Save 2x-min instead of x, to the stack
    *
    *  Max stack case:
    *
    *  max <x
    *  max -x <0
    *   2*max -x <max
    *
    *
    *
    *
    *
    * */
    int min;
    @Override
    public Node pop() {
        Node node = super.pop();

        if(node!=null && node.val<min){
            int oldMin = min;

            // Calc new min
            min = (2* oldMin) - node.val;

            // Sending out old min.
            node.val = oldMin;
        }

      return node;

    }

    @Override
    public Node peek() {
        return super.peek();
    }

    @Override
    public void push(Node node) {

        if(node.val<min){
            int oldMin = min;
            // Updating new min.
            min = node.val;

            // Saving old min, into the value
            node.val = (2*node.val)-oldMin;
        }
        if(peek() == null){
            min = node.val;

        }
        super.push(node);
    }


    public int min(){
        return min;
    }

    @Override
    public void printStack() {
        super.printStack();
        System.out.println("Min: "+min);
    }

    public static MinStack createRandomStack(int size,int maxValue){

        MinStack stack = new MinStack();

        if(size>0) {
            Node listRoot = Utils.createRandomList(size, maxValue);
            Utils.printList(listRoot,"Items Before inserting to Minstack: ");
            while (listRoot != null) {
                Node temp = listRoot.next;
                // System.out.println("inserting: "+listRoot.val);
                stack.push(listRoot);
               // stack.printStack();
                listRoot = temp;
            }
        }

        return stack;
    }




    public static void test(){

        MinStack stack = createRandomStack(10,10);
        // System.out.println("Printing stack: ");
        stack.printStack();
        Node node = null;//stack.pop();
        while((node= stack.pop())!=null){
            //stack.printStack();
            System.out.println("pop value: "+node.val+" min: "+stack.min);
            //node = stack.pop();

        }

    }

}
