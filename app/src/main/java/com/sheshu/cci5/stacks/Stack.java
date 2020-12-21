package com.sheshu.cci5.stacks;

import com.sheshu.cci5.Utils;
import com.sheshu.cci5.lists.Node;

public class Stack {

    private Node top;

    public Node pop(){
        if(top!=null)
        {
            Node temp = top;
            top = top.next;
            return temp;

        }
        return top;
    }
    public void push(Node node){
        if(top!=null){
           node.next = top;
         //   System.out.println("inserting into: "+node.val+" above: "+top.val);

        }
        else{
            node.next = null;
        }
        top = node;
    }
    public Node peek(){
        return top;

    }

    public void printStack(){
        Utils.printList(top," Stack ");
    }

    public static Stack createRandomStack(int size,int maxValue){

        Stack stack = new Stack();

        if(size>0) {
            Node listRoot = Utils.createRandomList(size, maxValue);
            while (listRoot != null) {
                Node temp = listRoot.next;
               // System.out.println("inserting: "+listRoot.val);
                stack.push(listRoot);
                stack.printStack();
                listRoot = temp;
            }
        }

        return stack;
    }




    public static void test(){

        Stack stack = createRandomStack(10,10);
       // System.out.println("Printing stack: ");
        stack.printStack();
    }

}
