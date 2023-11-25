package Lab4_1;

import org.example.Lab4_1.Palindrome;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PalindromeTest {

    @Test
    void isPalindrome() {
        assertTrue(Palindrome.isPalindrome(null));
        assertTrue(Palindrome.isPalindrome("radar"));
        assertFalse(Palindrome.isPalindrome("banana"));
        assertTrue(Palindrome.isPalindrome("hannah"));
        assertTrue(Palindrome.isPalindrome("pup"));
        assertTrue(Palindrome.isPalindrome("nan"));
        assertFalse(Palindrome.isPalindrome("lollipop"));
        assertTrue(Palindrome.isPalindrome("eye"));
        assertTrue(Palindrome.isPalindrome("6543456"));
        assertTrue(Palindrome.isPalindrome("step on no pets"));
        assertFalse(Palindrome.isPalindrome("A man a plan a canal Panama"));
    }

}
