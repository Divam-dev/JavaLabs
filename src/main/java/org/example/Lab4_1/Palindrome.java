package org.example.Lab4_1;

public class Palindrome {
    public static boolean isPalindrome(String word) {
        word = word.replaceAll("\\s+", "").toLowerCase();
        int length = word.length();

        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
