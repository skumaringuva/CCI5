package com.sheshu.cci5.lists;

import com.sheshu.cci5.Utils;

public class CircularListFindLoop {

    public static void test(){

        Node root  = Utils.createRandomList(10,5);
        Utils.printList(root,"before circular find");
        root.next.next.next = root;

        Node circle = findCircleStart(root);
        if(circle!=null)
            System.out.println("Circle start:  "+circle.val);
        else
            System.out.println("NO Loop!!");
    }


    private static Node findCircleStart(Node root){

        Node tor = root;
        Node hare = root;
        int index = 0;
        while(tor!=null && hare!=null){
            tor = tor.next;
            if(index%2 == 1){
                hare = hare.next;
            }

            if(hare == tor){
                return hare;
            }



            index++;
        }

        return null;
    }

}
