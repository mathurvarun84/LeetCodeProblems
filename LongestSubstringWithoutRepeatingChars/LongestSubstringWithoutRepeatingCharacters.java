package LongestSubstringWithoutRepeatingChars;

import java.util.HashMap;
import java.util.Map;

//Given a string str, find the length of the longest substring without repeating characters.
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                // Find the last index of s[j]
                // Update i (starting index of current window)
                // as maximum of current value of i and last
                // index
                i = Math.max(map.get(s.charAt(j)), i);
            }
            // Update result if we get a larger window
            ans = Math.max(ans, j - i + 1);
            // Update last index of j.
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args)
    {
        String str = "aaabdc";
        System.out.println("Length is: " +
                lengthOfLongestSubstring(str));
    }
}
