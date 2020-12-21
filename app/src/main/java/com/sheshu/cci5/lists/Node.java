package com.sheshu.cci5.lists;

public class Node {
    public int val;
    public Node next;
    // For single lists assuming prev will be null.
    public Node prev;
    public Node(int aVal){
        this.val = aVal;
    }
    public Node(){

    }
}
