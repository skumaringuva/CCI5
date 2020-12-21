package com.sheshu.cci5.lists;

import com.sheshu.cci5.Utils;

public class LinkedListPalindrome {

    public static void test(){

        Node root  = Utils.createRandomList(5,1);
        System.out.println("IsPalindromeList; ");
        Utils.printList(root,"Before isPalindromelist");
        System.out.println("IsPalindromeResylt: "+isLinkedListPalindromeDestructive(root));
        Utils.printList(root,"After palindrome test");

    }

    private static boolean isLinkedListPalindromeDestructive(Node root){
        int len = 0;
        Node cur = root;
        while(cur!=null){
            len++;
            cur = cur.next;
        }
        cur = root;
        Node prev = root;
        // go till half, from the half, reverse the linked list.. and compare the end with start by traversing in opposite direciton
        for(int i=0;i<len/2;i++){
            prev = cur;
            cur = cur.next;
        }
        // If lenght is odd, we need to start with other half, leaving the cener node as pivot...
        if(len%2 == 1){
            prev = cur;
            cur = cur.next;
        }
        //Print list before
        Utils.printList(cur,"Before reverse half list");
        prev.next = cur = reverseList(cur);

        // Print list after
        Utils.printList(cur,"After reverse half list");
        boolean result = true;
        while(root!=null && cur!=null){
            if(root.val!=cur.val){
                result = false;
                break;
            }
            root = root.next;
            cur = cur.next;
        }
        // reset the list( reverse the half which reversed and attach to first half, we saved the end in prev.next)
        prev.next = reverseList(prev.next);

        return result;
    }
    private static Node reverseList(Node root){
        Node prev = null;
        Node cur = root;
        while(cur!=null){

            if(prev!=null)
            {
                Node temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;


            }
            else
            {
                prev =cur;
                cur = cur.next;
                // This is important to stop looping here.
                prev.next = null;

            }
            System.out.println("Cur value: "+((cur!=null)?cur.val:null));

        }
        System.out.println("ReversedRoot: "+((prev!=null)?prev.val:null));
        return prev;
        /**
         * Complexity O(N) for length, O(N/2)+O(N/2) for reversal , O(N/2) for equality check ie O(N) overall
         * Memory O(N) as we did inplace swap and inplace compare..
         */

    }

    private static boolean isLinkedListPalindromeNonDestructive(){
        boolean result = false;

        /* One non destructive way is
        1. find length
        2. add first half of values with Key-Index value-value in a hashmap
        3. Find the values back from the map, with the index from second half..
        4. if not equals the its not palindrome.. if We get to the end then its a palindrome.
        memory - n/2 -- O(n)
        Time -- samd O(n)+O(N) -- O(N)..
         */

        return result;
    }

}
