package com.sheshu.cci5.lists;

import com.sheshu.cci5.Utils;

public class DeleteSingleMiddleNode {

    public static void test(){
        Node root = Utils.createRandomList(5,5);
        Utils.printList(root,"Before delete");

        deleteSomeMiddleNode(root.next.next);
        Utils.printList(root,"After delete");
    }

    private static void deleteSomeMiddleNode(Node del){
        // the only way to delete the node with its only reference(if its a single linked list)
        // Copy the data and next reference to this node and remove all references for the next node...
        Node nextNode = del.next;
        del.next = nextNode.next;
        del.val = nextNode.val;
        nextNode = null;

    }
}
