package com.sheshu.cci5.arraysstrings;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class StringCompress {

    public static void test(){

        System.out.println(compress("aabccccccaaa"));
        System.out.println(compress("aabbcc"));

    }


    public static String compress(String str){
        StringBuilder output = new StringBuilder();
        int prevCount = 0;
        Character prevChar = null;

        for(int i=0;i<str.length();i++){
            Character c = str.charAt(i);
            if(prevChar != c){

                if(prevChar!=null){
                    output.append(prevChar);
                    output.append(prevCount);
                }
                prevChar = c;
                prevCount = 1;

            }
            else{
                prevCount++;
            }


            if(i == str.length()-1){
                output.append(prevChar);
                output.append(prevCount);
            }
        }

        String outputString = output.toString();

        if(outputString.length()<str.length())
            return output.toString();
        else
            return str;

    }
}
