package com.sheshu.cci5.lists;

import com.sheshu.cci5.Utils;

public class PartitionLinkedList {

    public static void test(){

        Node root = Utils.createRandomList(100,100);
        Utils.printList(root,"before partition");
        root = partitionLinkedList(root,50);
        Utils.printList(root,"after partition");

    }

    private static Node partitionLinkedList(Node root, int k){
        Node leftRoot = null;
        Node rightRoot = null;
        Node endLeft = null;
        Node cur = root;

        while(cur!=null){
            Node temp = cur.next;
            if(cur.val<k){
                if(leftRoot == null) {
                    leftRoot = cur;
                    leftRoot.next = null;
                    endLeft = leftRoot;

                }else{
                    cur.next = leftRoot;
                    leftRoot = cur;
                }
            }
            else{
                if(rightRoot == null){
                    rightRoot = cur;
                    rightRoot.next = null;
                }else {
                    cur.next = rightRoot;
                    rightRoot = cur;
                }
            }
            cur = temp;

        }
        System.out.println("End left: "+endLeft.val+" startRight: "+rightRoot.val);
        endLeft.next = rightRoot;
        return leftRoot;
    }
}
