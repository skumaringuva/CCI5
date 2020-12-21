package com.sheshu.cci5.arraysstrings;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharString {

    public static void test(){
        System.out.println(isUniqueCharString(""));
        System.out.println(isUniqueCharString(null));
        System.out.println(isUniqueCharString("a"));
        System.out.println(isUniqueCharString("aa"));
        System.out.println(isUniqueCharString("\0a"));

        System.out.println(isUniqueCharUtf8String(""));
        System.out.println(isUniqueCharUtf8String(null));
        System.out.println(isUniqueCharUtf8String("a"));
        System.out.println(isUniqueCharUtf8String("aa"));
        System.out.println(isUniqueCharUtf8String("\0a"));

        System.out.println(isUniqueCharUtf16String(""));
        System.out.println(isUniqueCharUtf16String(null));
        System.out.println(isUniqueCharUtf16String("a"));
        System.out.println(isUniqueCharUtf16String("aa"));
        System.out.println(isUniqueCharUtf16String("\0a"));
    }

    private static boolean isUniqueCharString(String string){
        if(string == null||string.length()<1)
            return false; // check

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i=0;i<string.length();i++){
            Character c = string.charAt(i);
            if(map.containsKey(c)){
                return false;
            }
            else
                map.put(c,1);
        }

        return true;
    }
    private static boolean isUniqueCharUtf8String(String string){

        if(string == null||string.length()<1)
            return false; // check

        int[] map = new int[256]; // may overflow for chars >256..

        for(int i=0;i<string.length();i++){
            Character c = string.charAt(i);
            int index = (int)c;
            if(map[index] == 1){
                return false;
            }
            else
                map[c] = 1;
        }

        return true;
    }
    private static boolean isUniqueCharUtf16String(String string){

        if(string == null||string.length()<1)
            return false; // check

        int[] map = new int[0xffff];

        for(int i=0;i<string.length();i++){
            Character c = string.charAt(i);
            char index = c;
            if(map[index] == 1){
                return false;
            }
            else
                map[c] = 1;
        }

        return true;
    }
}
