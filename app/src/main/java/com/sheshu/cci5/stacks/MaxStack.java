package com.sheshu.cci5.stacks;

import com.sheshu.cci5.Utils;
import com.sheshu.cci5.lists.Node;

public class MaxStack  extends Stack{

    int max;
    @Override
    public Node pop() {
        Node node = super.pop();

        if(node!=null && node.val>=max){
            int oldMax = max;

            max = node.val-max;
            // Sending out old max.
            node.val = oldMax;
        }

        return node;

    }

    @Override
    public Node peek() {
        return super.peek();
    }

    @Override
    public void push(Node node) {

        if(node.val>=max){
            int oldMax = max;
            // Updating new min.
            max = node.val;

            // Saving old max, into the value
            node.val = oldMax+max;
        }
        if(peek() == null){
            max = node.val;

        }
        super.push(node);
    }


    public int max(){
        return max;
    }

    @Override
    public void printStack() {
        super.printStack();
        System.out.println("Max: "+max);
    }

    public static MaxStack createRandomStack(int size,int maxValue){

        MaxStack stack = new MaxStack();

        if(size>0) {
            Node listRoot = Utils.createRandomList(size, maxValue);
            Utils.printList(listRoot,"Items Before inserting to MaxStack: ");
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

        MaxStack stack = createRandomStack(10,10);
        // System.out.println("Printing stack: ");
        stack.printStack();
        Node node = null;//stack.pop();
        while((node= stack.pop())!=null){
            //stack.printStack();
            System.out.println("pop value: "+node.val+" Max: "+stack.max);
            //node = stack.pop();

        }

    }

}

