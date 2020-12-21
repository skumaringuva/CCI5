package com.sheshu.cci5.stacks;

import com.sheshu.cci5.lists.Node;

import java.util.ArrayList;
import java.util.List;

public class CatDogStack {
    private static final int CAT = 0;
    private static final int DOG = 1;
    int[] categories = {CAT,DOG};

    List<Stack> stacks;

    CatDogStack(){
        stacks = new ArrayList<>();
        for(int i=0;i<categories.length;i++){
            stacks.add(new Stack());
        }
    }

    public void push(Animal animal){

    }

    public Animal pop(){

        return null;
    }

    public Animal peek(){
        return null;
    }

    public void createTestData(){

    }

    public static void test(){

    }





}
