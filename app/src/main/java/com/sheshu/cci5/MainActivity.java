package com.sheshu.cci5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sheshu.cci5.arraysstrings.ImageRotate;
import com.sheshu.cci5.arraysstrings.RotatedString;
import com.sheshu.cci5.arraysstrings.RowColumnZero;
import com.sheshu.cci5.arraysstrings.SpaceEncode;
import com.sheshu.cci5.arraysstrings.StringCompress;
import com.sheshu.cci5.arraysstrings.UniqueCharString;
import com.sheshu.cci5.arraysstrings.IsPermutation;
import com.sheshu.cci5.graphsntrees.CharTrie;
import com.sheshu.cci5.graphsntrees.Graph;
import com.sheshu.cci5.graphsntrees.GraphBfs;
import com.sheshu.cci5.graphsntrees.GraphDfs;
import com.sheshu.cci5.graphsntrees.InOrder;
import com.sheshu.cci5.graphsntrees.MaxHeap;
import com.sheshu.cci5.graphsntrees.MinHeap;
import com.sheshu.cci5.graphsntrees.PostOrder;
import com.sheshu.cci5.graphsntrees.PreOrder;
import com.sheshu.cci5.graphsntrees.TNode;
import com.sheshu.cci5.graphsntrees.TreeIsBalanced;
import com.sheshu.cci5.graphsntrees.TrieWordComplete;
import com.sheshu.cci5.lists.CircularListFindLoop;
import com.sheshu.cci5.lists.DeleteSingleMiddleNode;
import com.sheshu.cci5.lists.KthLastElementSingle;
import com.sheshu.cci5.lists.LinkedListPalindrome;
import com.sheshu.cci5.lists.ListToNumber;
import com.sheshu.cci5.lists.PartitionLinkedList;
import com.sheshu.cci5.lists.RemoveDuplicates;
import com.sheshu.cci5.searches.BinarySearch;
import com.sheshu.cci5.stacks.MaxStack;
import com.sheshu.cci5.stacks.MinStack;
import com.sheshu.cci5.stacks.SetOfStacks;
import com.sheshu.cci5.stacks.SingleArrayThreeStacks;
import com.sheshu.cci5.stacks.Stack;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //testArraysStrings();
       //testLists();
       // testStacks();
       // testGraphsNTrees();
        testSearch();
    }

    private void testArraysStrings(){
        UniqueCharString.test();
        IsPermutation.test();
        SpaceEncode.test();
        StringCompress.test();
        ImageRotate.test();
        RowColumnZero.test();
        RotatedString.test();
    }

    private void testLists(){
        KthLastElementSingle.test();
        RemoveDuplicates.test();
        DeleteSingleMiddleNode.test();
        CircularListFindLoop.test();
        LinkedListPalindrome.test();
        ListToNumber.test();
        PartitionLinkedList.test();
    }

    private void testStacks(){
        Stack.test();
        MinStack.test();
        MaxStack.test();
        SetOfStacks.test();
        SingleArrayThreeStacks.test();
        // Stack sorting
        // Two Stacks queue
        // Towers of hanoi
        //Cat dog stak

    }


    private void testGraphsNTrees(){
        TNode.testTree();
        InOrder.test();
        PreOrder.test();//
        PostOrder.test();
        MaxHeap.test();
        MinHeap.test();
        CharTrie.test();

        TreeIsBalanced.test();

        Graph.test();
        GraphBfs.test();
        GraphDfs.test();

        TrieWordComplete.test();
    }

    private void testSearch(){
        BinarySearch.test();
    }



}
