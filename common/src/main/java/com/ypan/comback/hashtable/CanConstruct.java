package com.ypan.comback.hashtable;

public class CanConstruct {


    public static void main(String[] args) {
        canConstruct("a", "b");
    }
    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] array = new int[26];

        for (int i = 0; i < ransomNote.length(); i++) {
            array[ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            array[magazine.charAt(i) - 'a']--;
        }

        for (int i : array) {
            if (i > 0) {
                return false;
            }
        }
        return true;


    }
}
