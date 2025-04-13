package MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.List;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        // If either string is empty or s is shorter than t, return empty string
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        // Create frequency maps for characters in t and the current window
        Map<Character, Integer> targetFreq = new HashMap<>();
        Map<Character, Integer> windowFreq = new HashMap<>();

        // Fill the target frequency map
        for (char c : t.toCharArray()) {
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        }

        int start = 0;                  // Start of current window
        int minStart = 0;               // Start of minimum window
        int minLength = Integer.MAX_VALUE;  // Length of minimum window
        int requiredChars = t.length(); // Number of characters still needed
        
        // Iterate through the string using end pointer
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            
            // Add current character to window frequency map
            windowFreq.put(currentChar, windowFreq.getOrDefault(currentChar, 0) + 1);
            
            // If current character is required and we haven't exceeded needed frequency
            if (targetFreq.containsKey(currentChar) && 
                windowFreq.get(currentChar) <= targetFreq.get(currentChar)) {
                requiredChars--;
            }
            
            // Try to minimize window by moving start pointer
            while (requiredChars == 0) {
                // Update minimum window if current window is smaller
                if (end - start + 1 < minLength) {
                    minStart = start;
                    minLength = end - start + 1;
                }
                
                // Remove character at start from window
                char startChar = s.charAt(start);
                windowFreq.put(startChar, windowFreq.get(startChar) - 1);
                
                // If removed char was required and we now have too few
                if (targetFreq.containsKey(startChar) && 
                    windowFreq.get(startChar) < targetFreq.get(startChar)) {
                    requiredChars++;
                }
                
                start++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }

    // Driver code
    public static void main(String[] args) {
        List<String> s = Arrays.asList(
            "ADOBECODEBANC",
            "a",
            "ab",
            "ABCDEFG",
            "aaaaaaaaaa"
        );
        
        List<String> t = Arrays.asList(
            "ABC",
            "a",
            "a",
            "AC",
            "aaa"
        );

        for (int i = 0; i < s.size(); i++) {
            System.out.println((i + 1) + ".\tString s: \"" + s.get(i) + "\"");
            System.out.println("\tString t: \"" + t.get(i) + "\"");
            System.out.println("\tMinimum Window Substring: \"" + minWindow(s.get(i), t.get(i)) + "\"");
            System.out.println(new String(new char[100]).replace("\0", "-"));
        }
    }
}
