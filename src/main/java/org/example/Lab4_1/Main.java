package org.example.Lab4_1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word:");
        String word = scanner.nextLine();

        if (Palindrome.isPalindrome(word)) {
            System.out.println(word + " is Palindrome.");
        } else {
            System.out.println(word + " is not Palindrome.");
        }

        scanner.close();
    }
}