package com.sheshu.cci5.lists;

import com.sheshu.cci5.Utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveDuplicates {

    public static void test(){

        Node root = Utils.createRandomList(10,2);
        Utils.printList(root,"before remove dups");

        Utils.printList(removeDuplicatesBrute(root),"After remove dups brute");

        //Utils.printList(root);

        Utils.printList(removeDuplicatesMap(root),"After remove dups map");

    }

    private static Node removeDuplicatesBrute(Node root){
        Node cur1 = root;
        Node cur2 = root;
        while(cur1!=null){
            cur2 = cur1.next;
            Node prev = cur1;
            while(cur2!=null){

                if(cur1.val == cur2.val){
                    prev.next = cur2.next;
                    cur2 = cur2.next;
                    continue;
                }
                prev = cur2;
                cur2 = cur2.next;

            }
            cur1 = cur1.next;
        }

        return root;
    }

    private static Node removeDuplicatesMap(Node root){

        Map<Integer,Node> map = new LinkedHashMap<>();
        Node cur = root;
        while(cur!=null){
            if(!map.containsKey(cur.val)){
                map.put(cur.val,cur);
            }else{
                System.out.println("We alerady have value: "+cur.val);
            }
            cur = cur.next;
        }
        root = null;
        for(Integer val:map.keySet()){
            Node node = map.get(val);
            node.next = null;
            if(root == null) {
                root = node;
                cur = root;
            }
            else {
                cur.next = node;
                cur = cur.next;
            }
        }


        return root;
    }

    private Node removeDuplicatesMergeSort(Node root){
        // TODO: implement mergesort and removedups.
        return null;
    }

}
