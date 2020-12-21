package com.sheshu.cci5.graphsntrees;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {
    public static void test(){
        TNode tNode = TNode.createRandomBinarySearchTree(100,100);
        System.out.println("\nPostOrder:-------");
        postOrderRecursive(tNode);
        System.out.flush();
        System.out.println("\r\n");

        //postOrderNonRecursive(tNode);
        System.out.flush();
    }

    // TODO: Fixit Not working..
    private static void postOrderNonRecursive(TNode root) {
        //if()
        List<TNode> stack = new ArrayList<>();
        TNode node = root;
        TNode prev = null;
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
                    node = stack.get(0); // stack.peek
                    if(node.right == null){
                        prev = node = stack.remove(0);
                        System.out.print(" "+node.val);
                    }
                    while(stack.get(0).right == prev){
                        prev = node = stack.remove(0);
                        System.out.print(" "+node.val);
                        node = null;
                    }


                }
            }
        }


    }

    private static void postOrderRecursive(TNode root){
        if(root!=null){

            if(root.left!=null){
                postOrderRecursive(root.left);
            }
            if(root.right!=null){
                postOrderRecursive(root.right);
            }
            System.out.print(" "+root.val);


        }
    }

}
