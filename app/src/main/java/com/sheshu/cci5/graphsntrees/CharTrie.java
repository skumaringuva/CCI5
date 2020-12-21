package com.sheshu.cci5.graphsntrees;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharTrie {
    Character ch;
    Map<Character,CharTrie> children;
    boolean isCompleteWord;

    CharTrie(Character aCh){
        ch = aCh;
        children = new HashMap<>();
        isCompleteWord = false;
    }

    public static void test(){

        CharTrie root = new CharTrie('*');

        addWord(root,"Hello");
        addWord(root,"hi");
        addWord(root,"test");
        addWord(root, "my");

        printTrie(root);
        System.out.println("contains word hi?: "+containsWord(root,"hi"));
        System.out.println("contains word He?: "+containsWord(root,"He"));
        System.out.println("contains word Him?: "+containsWord(root,"Him"));

        removeWord(root,"He");
        removeWord(root,"hi");
        printTrie(root);


        System.out.flush();
    }

    private static void printTrie(CharTrie root){
        if(root!=null && root.children.size()>0){
            System.out.println("\nPrinting Trie: "+root.ch);

            for(Character ch: root.children.keySet()) {
                System.out.print(" " +ch);
            }
            for(Character ch: root.children.keySet()) {
                printTrie(root.children.get(ch));
            }

        }
        System.out.flush();
    }

    public static void addWord(CharTrie root, String word){

        root.addWordFromIndex(word,0);
    }

    private void addWordFromIndex(String word, int index){
        if(word==null || index>=word.length()){
            if(index>0 && index==word.length()){
                isCompleteWord = true;
            }
            return;
        }
        Character ch = word.charAt(index);
        if(children.containsKey(ch)){
            children.get(ch).addWordFromIndex(word,index+1);
        }
        else{
            CharTrie node = new CharTrie(ch);
            children.put(ch,node);
            children.get(ch).addWordFromIndex(word,index+1);

        }
    }

    private boolean removeWordFromIndex(String word, int index){
        Character ch = word.charAt(index);
        if(children.containsKey(ch)){
            boolean  removeParent = false;
            if(children.get(ch).children.size()==0 ) {
                removeParent = true;

            }else if(index+1 <word.length())
            {
                removeParent = children.get(ch).removeWordFromIndex(word, index + 1);

            }
            if(removeParent)
            {
                children.remove(ch);
                return true;
            }else return false;
        }else {
            return false;
        }

    }

    private boolean startsWithWordFromIndex(String word, int index){
        if(word.length()>index) {
            Character ch = word.charAt(index);
            boolean result = children.containsKey(ch) && children.get(ch).startsWithWordFromIndex(word, index + 1);
           // System.out.println("index: "+index+" result: "+result);
            return result;
        }
        else {
            return true;
        }
    }
    private boolean containsWordFromIndex(String word, int index){
        if(word.length()>index) {
            Character ch = word.charAt(index);
            boolean result = children.containsKey(ch) && children.get(ch).containsWordFromIndex(word, index + 1);
            if ((word.length() == index+1)) {
                if( children.get(ch).isCompleteWord)
                    return true;
                else
                    return false;
            }
            return result;
        }
        else {
            return true;
        }
    }


    public static void removeWord(CharTrie root, String word){
        root.removeWordFromIndex(word,0);
    }

    public static boolean startsWithWord(CharTrie root, String word){
        if(root.children.size()>0 && word.length()>0){
            return root.startsWithWordFromIndex(word,0);
        }
        return false;
    }

    public static boolean containsWord(CharTrie root, String word){
        if(root.children.size()>0 && word.length()>0){
            return root.containsWordFromIndex(word,0);
        }

        return false;
    }




}
