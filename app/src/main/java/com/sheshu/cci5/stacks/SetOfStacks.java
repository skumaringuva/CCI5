package com.sheshu.cci5.stacks;

import com.sheshu.cci5.Utils;
import com.sheshu.cci5.lists.Node;

import java.util.ArrayList;
import java.util.List;

public class SetOfStacks {
    private void popAt(int subStackSize) {
    }

    private static final int MAX_SUB_STACK_SIZE = 10;
    private int mCurrentSubStackSize;
    private List<Node> mStackList;

    SetOfStacks() {
        mStackList = new ArrayList<>();
    }

    void push(Node node) {
        if (mStackList.isEmpty()) {
            mStackList.add(node);
            mCurrentSubStackSize = 1;
        } else if (mCurrentSubStackSize >= MAX_SUB_STACK_SIZE) {
            mCurrentSubStackSize = 1;
            mStackList.add(0, node);
        } else {
            Node top = mStackList.remove(0);
            node.next = top;
            mStackList.add(0, node);
            mCurrentSubStackSize++;
        }
    }

    Node pop() {
        if (!mStackList.isEmpty()) {
            Node top = mStackList.remove(0);
            Node next = top.next;
            // If next is not null, put the stack back to the list of stacks.
            if (next != null) {
                mStackList.add(0, next);
                mCurrentSubStackSize--;
            } else if (mStackList.size() > 0) {
                // If we just removed and emptied a top sub stack. next sub stack will be full anyways..
                mCurrentSubStackSize = MAX_SUB_STACK_SIZE;
            }
            return top;
        }
        return null;
    }

    private void printStack() {
        for (int i = 0; i < mStackList.size(); i++) {
            //Utils.printList(mStackList.get(i)," SubStack "+i);
            System.out.print("\nSubStack " + i + " :");
            Node node = mStackList.get(i);
            while (node != null) {
                System.out.print(" " + node.val);
                node = node.next;
            }
        }
        System.out.flush();
    }

    private static SetOfStacks createRandomStack(int size, int maxValue) {
        SetOfStacks stack = new SetOfStacks();
        if (size > 0) {
            Node listRoot = Utils.createRandomList(size, maxValue);
            Utils.printList(listRoot, " List: ");
            int i = 0;
            while (listRoot != null) {
                Node temp = listRoot.next;
                // System.out.println("inserting: "+listRoot.val);
                listRoot.next = null;
                stack.push(listRoot);
                //if(++i%10 ==0)
                {
                    // stack.printStack();
                }
                listRoot = temp;
            }
        }
        return stack;
    }

    public static void test() {
        SetOfStacks stack = createRandomStack(100, 10);
        stack.printStack();
        Node node = stack.pop();
        int i = 0;
        while (node != null) {
            //System.out.print(" "+node.val);
            node = stack.pop();
            if (++i % 9 == 0) {
                System.out.print("\nAfter removing " + (i + 1));
                stack.printStack();
            }
        }
        System.out.flush();
    }
}
