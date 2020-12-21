package com.sheshu.cci5.arraysstrings;

public class RotatedString {

    public static void test(){
        System.out.println(isRotatedString(null,null));
        System.out.println(isRotatedString("blah",null));
        System.out.println(isRotatedString(null,"blah"));
        System.out.println(isRotatedString("abcde","deabc"));
        System.out.println(isRotatedString("abcde","edabc"));

    }

    private static boolean isRotatedString(String str1, String str2){
        if(str1==null || str2==null || str1.length() != str2.length())
        {
            return false;
        }
        return((str2+str2).contains(str1));

    }
}
