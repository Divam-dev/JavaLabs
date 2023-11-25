package org.example.Lab4_1;

public class Palindrome {
    public static boolean isPalindrome(String word) {
        StringBuilder reverseStr = new StringBuilder();

        if (word == null) {
            return true;
        }

        int strLength = word.length();

        for (int i = (strLength - 1); i >= 0; --i) {
            reverseStr.append(word.charAt(i));
        }

        return word.equalsIgnoreCase(reverseStr.toString());
    }
}