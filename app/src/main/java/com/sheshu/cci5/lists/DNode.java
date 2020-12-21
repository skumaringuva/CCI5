package com.sheshu.cci5.lists;

import java.util.Stack;

// Program to manage text editor functions with Dlinked list
public class DNode {
    char val;
    DNode prev;
    DNode next;


    DNode(char aVal){
        val = aVal;
    }

    private void insertChar(char ch){

    }

    private void moveCursorLeft(){

    }
    private void moveCursorRigth(){

    }
    private void cursorBackspace(){

    }


    public static void test(){

        playEditor();


    }
    private static final  char BACKSPACE = '\b';
    private static final  char KEY_LEFT = '<';
    private static final  char Key_RIGHT='>';


    private static void playEditor() {
        // should have a class for clean design, using DNode..


        DNode root = null;
        DNode cursor= null;
        Stack opStack = new Stack();

        char[] operations = {'a','b','c',KEY_LEFT,'d','e','f','g',Key_RIGHT,'i','j',BACKSPACE,'a','b',};
        for(int i=0;i<operations.length;i++){
            opStack.push(new DNode(operations[i]));
            if(root!=null){
                root = new DNode(operations[i]);
                cursor = root;
            }
            else {
                runOperation(cursor,operations[i]);
            }
        }

    }

    private static void undo(Stack<DNode> opStack){
        DNode op = opStack.pop();
        if(op!=null){
            switch (op.val){
                // key left will be switched with key right.. noop left like, left on root?
                // key right will be switched with key left.. noop right like, right on last element?
            }
        }
    }

    private static void runOperation(DNode cursor, char operation) {

        if(cursor==null)
            return;
        switch (operation){
            case '\b': {
                if (cursor.prev != null) {
                    DNode delNode= cursor.prev;
                    // when we are deleting node, we need to make an entry in the opStack that this item is deleted.
                    // to get this restored.. but how? opstack.peek.next = new DNode(delNode.val);..
                    // we can check the operation and go to next for restoration..
                    if(delNode.prev!=null){
                        delNode.prev = delNode.next;
                    }
                    else {
                        // root = delNode.next; // since we are deleting root node, we need to make next node as root node..
                    }
                    System.out.println("Deleting at: "+cursor.val+" Cursors");
                    cursor.prev.next = cursor.next;
                    // in manual cleanup languages, we need to free the deleted node..
                }
                break;
            }
            case KEY_LEFT:
                if(cursor.prev!=null)
                    cursor = cursor.prev;
                break;
            case Key_RIGHT:
                if(cursor.next!=null)
                    cursor = cursor.next;
                break;
            default: {
                DNode temp = cursor.next;
                cursor.next = new DNode(operation);
                cursor.next.prev = cursor;
                cursor.next.next = temp;
                break;
            }
        }

    }
}




