package com.sheshu.cci5.graphsntrees;

import com.sheshu.cci5.Utils;

import java.util.ArrayList;
import java.util.List;

// Binary tree for now.. it can be binary search tree..
public class TNode  {

    int val;
    TNode left;
    TNode right;

    TNode(int aVal){
        this.val = aVal;
    }


    public static void testTree(){
        TNode root = null;
        root = createRandomBinarySearchTree(100,100);
       if(root!=null)
        printTreeLevelOrder(root);

    }

    public static TNode createRandomBinarySearchTree(int size, int maxNumber){
        TNode root = null;
        int[] array = Utils.getRandomArray(size,maxNumber);
        for(int i=0;i<array.length;i++){
            TNode node = new TNode(array[i]);
            if(root == null){
                root = node;
            }else {
                insertNodeInBinarySearchTree(root,node);
            }
        }

        return root;
    }


    public static void insertNodeInBinarySearchTree(TNode root,TNode node){

        if(root!=null && node != null){

            // If incoming value is greater than the node, it goes to right
            // else it goes to left..
            if(node.val>root.val){
                if(root.right == null)
                {
                    root.right = node;
                }else {
                    insertNodeInBinarySearchTree(root.right,node);
                }
            }
            else {
                if(root.left == null)
                {
                    root.left = node;
                }else {
                    insertNodeInBinarySearchTree(root.left,node);
                }
            }

        }

    }
    // This method will print will try to print in tree levels..
    public static void printTreeLevelOrder(TNode root){
        List<TNode> queue = new ArrayList<>();
        int level = 0;
        queue.add(root);
        queue.add(new TNode(-1)); // add a new line

        while(!queue.isEmpty()){
            TNode node = queue.remove(0);

            if(node.val == -1){
                System.out.println("\n------------------------------------------------------------level"+level++);
                if(!queue.isEmpty())
                    queue.add(new TNode(-1)); // When we get -1, means its end of previous level nodes..
                // So adding -1 to queue marking end of the previous level in the queue
                System.out.flush();
            }else {
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null){
                    queue.add(node.right);
                }
                System.out.print(" "+node.val);
            }

        }
        System.out.println("End Tree..");
        System.out.flush();

    }

    public static void insertNodeInBinaryTree(TNode root,TNode node){

    }

}
