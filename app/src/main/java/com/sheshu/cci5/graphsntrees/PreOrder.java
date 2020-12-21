package com.sheshu.cci5.graphsntrees;

import java.util.ArrayList;
import java.util.List;

public class PreOrder {

    public static void test(){
        TNode tNode = TNode.createRandomBinarySearchTree(100,100);
        System.out.println("\nPreOrder:-------");
        preOrderRecursive(tNode);
        System.out.flush();
        System.out.println("\r\n");

        preOrderNonRecursive(tNode);
        System.out.flush();
    }

    private static void preOrderNonRecursive(TNode root) {
        //if()
        List<TNode> stack = new ArrayList<>();
        TNode node = root;
        if (root != null) {
            while (!stack.isEmpty() || node!=null ) {
                // If we have left, push left till all lefts are over.. this will get us to the
                // left most sub tree..
                while (node!=null) {
                    System.out.print(" " + node.val);

                    stack.add(0, node);
                    node = node.left;
                }

                // pop the first element
                if(!stack.isEmpty()){
                    node = stack.remove(0);
                }
                // After processing deep left and center, go to right..
                // If right is null, loop will again pop next item from above block..
                if(node!=null)
                    node = node.right;
            }
        }


    }

    private static void preOrderRecursive(TNode root){
        if(root!=null){
            System.out.print(" "+root.val);

            if(root.left!=null){
                preOrderRecursive(root.left);
            }
            if(root.right!=null){
                preOrderRecursive(root.right);
            }


        }
    }

}
