package com.sheshu.cci5.graphsntrees;

import com.sheshu.cci5.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: this min heap does work well, but it does not create balanced tree while creating
// Need to fix further to see how can we make it balanced..
public class MaxHeap {
    private HNode root;
    private HNode last;

    private static MaxHeap createRandomHeap() {
        int[] randomArray = Utils.getRandomArray(100, 100);
        System.out.println("Input: "+Arrays.toString(randomArray));
        MaxHeap heap = new MaxHeap();
        for (int i = 0; i < randomArray.length; i++) {
            heap.insert(new HNode(randomArray[i]));
        }
        printTreeLevelOrder(heap.root);
        return heap;
    }

    // This method will print will try to print in tree levels..
    public static void printTreeLevelOrder(HNode root){
        List<HNode> queue = new ArrayList<>();
        int level = 0;
        queue.add(root);
        queue.add(new HNode(-1)); // add a new line

        while(!queue.isEmpty()){
            HNode node = queue.remove(0);
            if(node.val == -1){
                System.out.println("\n------------------------------------------------------------level"+level++);
                if(!queue.isEmpty())
                    queue.add(new HNode(-1)); // When we get -1, means its end of previous level nodes..
                // So adding -1 to queue marking end of the previous level in the queue
                System.out.flush();
            }else {
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null){
                    queue.add(node.right);
                }
                System.out.print(" "+node.val);
                System.out.print(" p:"+(node.parent!=null?node.parent.val:""));
            }

        }
        System.out.println("End Tree..");
        System.out.flush();

    }

    private String nodeToStr(HNode node){
        return("(val: "+node.val+" parent: "+node.parent+" left:"+ node.left+" right:"+node.right+")");
    }


    public static void test() {
        MaxHeap heap = createRandomHeap();
        System.out.println("\n Max heap test: ");
        System.out.flush();

        if(heap!=null) {
            while (heap.getTop() != null) {
                System.out.println(" " + heap.removeTop().val+" root: "+(heap.root!=null?heap.root.val:""));
                //printTreeLevelOrder(heap.root);
            }
        }
        System.out.flush();

        System.out.println("\n"+"End Max heap test");
    }
    private void insert(HNode node) {
        if(root == null){
            root = last = node;
            System.out.println("Inserting root: "+node.val);
        }
        else{

            HNode lastParent = null;
            if(root == last){
                lastParent = last;
            }
            else {
                lastParent = last.parent;

            }

            if(lastParent.right ==  null){
                lastParent.right = node;
                node.parent = lastParent;
            }else if(lastParent.left == null){
                lastParent.left = node;
                node.parent = lastParent;
            }else{
                insertAtSmallestChild(lastParent,node);
            }
            last = node;
            System.out.println("inserting: "+node.val+" below: "+node.parent.val);


        }
        heapifyUp();

    }


    private HNode removeTop() {
        HNode tempNode = null;
        if(root == last){
            tempNode = root;
            root = last = null;
            return tempNode;
        }
        swap(root,last);
        HNode parent = last.parent;
        if(parent.left == last) {
            parent.left = null;
        }
        else{
            parent.right = null;
        }
        tempNode = last;
        last = parent;
        if(last.right!=null){
            last = last.right;
        }else if(last.left!=null){
            last = last.left;
        }

        heapifyDown();
        System.out.flush();

        return tempNode;
    }

    private void heapifyDown() {

        HNode node = root;
        while((node=checkWithChildrenAndSwap(node))!=null){

        }


    }
    void swap(HNode a, HNode b){

        int temp = a.val;
        a.val = b.val;
        b.val = temp;
       // System.out.println(" Swapping: "+a.val+" "+b.val);
    }

    private void heapifyUp(){
        HNode node = last;
        while(node!=root && node.val >node.parent.val){
            swap(node,node.parent);
            node = node.parent;
            //checkWithChildrenAndSwap(node);
        }

        System.out.println("Last after heapify: "+last.val);
    }

    private HNode checkWithChildrenAndSwap(HNode node) {
        HNode maxChild = ((node.left != null ? node.left.val : Integer.MIN_VALUE) > (node.right != null ? node.right.val : Integer.MIN_VALUE) ? node.left : node.right);
        if (maxChild != null && node.val < maxChild.val) {
            swap(node, maxChild);
            return maxChild;
        }
        return null;
    }

    private void insertAtSmallestChild(HNode node, HNode newNode) {
        HNode maxChild = (node.left.val > node.right.val ? node.left : node.right);
        maxChild.left = newNode;
        newNode.parent = maxChild;
    }

    public HNode getTop() {
        return root;
    }




}
