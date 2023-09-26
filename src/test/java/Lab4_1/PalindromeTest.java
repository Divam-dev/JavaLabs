package Lab4_1;

import org.example.Lab4_1.Palindrome;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PalindromeTest {

    @Test
    public void testIsPalindrome() {

        assertTrue(Palindrome.isPalindrome("radar"));
        assertTrue(Palindrome.isPalindrome("о Ко"));
        assertTrue(Palindrome.isPalindrome("Noo n"));
        assertTrue(Palindrome.isPalindrome("12321"));
        assertTrue(Palindrome.isPalindrome(""));
        assertTrue(Palindrome.isPalindrome("a"));

        assertFalse(Palindrome.isPalindrome("hello"));
        assertFalse(Palindrome.isPalindrome("Паліндром"));

    }
}
