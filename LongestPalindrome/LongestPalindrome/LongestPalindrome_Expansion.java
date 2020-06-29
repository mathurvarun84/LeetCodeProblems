package LongestPalindrome;

//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
public class LongestPalindrome_Expansion
{
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        String longest = s.substring(0, 1);

        // One by one consider every character as center
        // point of even and length palindromes
        for (int i = 0; i < s.length(); i++) {
            // Find the longest even length palindrome with
            // center points as i and i.
            String temp = expandAroundCenter(s, i, i);
            if(temp.length() > longest.length()) {
                longest = temp;
            }
            // Find the longest odd length palindrome with
            // center point as i and i+1
            temp = expandAroundCenter(s, i, i + 1);
            if(temp.length() > longest.length()) {
                longest = temp;
            }
        }
        return longest;
    }

    private static String expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return s.substring(L + 1, R);
    }

    public static void main(String[] args) {

        String str = "forgeeksskeegfor";
        System.out.println("Length is: " +
                longestPalindrome(str));
    }
}