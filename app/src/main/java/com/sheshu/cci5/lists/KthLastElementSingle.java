package com.sheshu.cci5.lists;

import com.sheshu.cci5.Utils;

public class KthLastElementSingle {

    public static void test(){

        Node root = Utils.createRandomList(5,100);
        Utils.printList(root,"Before kth last element operation");
       System.out.println(kthLastElement(root,4).val);
        System.out.println(kthLastElement(root,0).val);

    }
    private static Node kthLastElement(Node root,int k){
        Node cur = root;
        int index = 0;
        Node kCur = null;
        while(cur!=null){

            if(index == k) {
                System.out.println("index: "+index);
                kCur = root;
            }
            index++;

            cur = cur.next;
            if(cur!=null && kCur!=null) {
                kCur = kCur.next;
               // System.out.println("cur : " + cur.val + " kCur" + kCur.val);
            }
        }
        return kCur;
    }


}
