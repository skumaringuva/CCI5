package com.sheshu.cci5.arraysstrings;

public class SpaceEncode {

    public static void test(){

        System.out.println(encode("Mr John Smith                     ".toCharArray()));

    }


    private static char[] encode(char[] str)
    {
        int length = 0;
        int numberOfSpaces = 0;
        int spaceBetween = 0;
        for(int i=0;i<str.length;i++){
            if(str[i]!=' '){
                length = i;
                spaceBetween+=numberOfSpaces;
                numberOfSpaces = 0;
            }
            else
                numberOfSpaces++;

        }

        int start = str.length-(numberOfSpaces)+spaceBetween*2-1;

        for(int i=length;i>0;i--){
            if(str[i]!=' ') {
                str[start--] = str[i];
            }else{
                str[start--] = '0';
                str[start--] = '2';
                str[start--] = '%';

            }
        }

        return str;

    }
}
