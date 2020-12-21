package com.sheshu.cci5.arraysstrings;

import java.util.HashMap;

public class IsPermutation {

    public static void test(){

        System.out.println("IsPermutation: "+isStringPermutation("abcd","dcba"));
        System.out.println("IsPermutation: "+isStringPermutation(null,"dcba"));
        System.out.println("IsPermutation: "+isStringPermutation("abcd",null));
        System.out.println("IsPermutation: "+isStringPermutation(null,null));
        System.out.println("IsPermutation: "+isStringPermutation("abcd","dscba"));
        System.out.println("IsPermutation: "+isStringPermutation("abcds","dscb"));




    }

    private static boolean isStringPermutation(String a, String b){
        if(a == null || b == null){
            return false;
        }
        HashMap<Character,Integer> map =  new HashMap<>();
        int len = a.length();
        if(b.length()!=len){
            return false;
        }
        for(int i=0;i<a.length();i++){
            Character c = a.charAt(i);
            int oldCount = 0;
            if(map.containsKey(c)){
                oldCount= map.get(c);
            }
            map.put(c,oldCount+1);
        }

        for(int i=0;i<a.length();i++){
            Character c = a.charAt(i);
            if(map.containsKey(c)){
                int oldCount = map.get(c);
                if(oldCount != 1)
                    map.put(c,oldCount-1);
                else
                    map.remove(c);
            }
            else {
                return false;
            }

        }

        if(map.size()>0)
            return false;

            return true;
    }

}
