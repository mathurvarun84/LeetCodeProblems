package RansomNote;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    /**
     * Returns true if ransomNote can be constructed from the characters of magazine.
     * Each character in magazine can only be used once.
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) {
            return false;
        }

        // Frequency map for characters in magazine
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Try to construct ransomNote using the frequency map
        for (char c : ransomNote.toCharArray()) {
            int count = freq.getOrDefault(c, 0);
            if (count == 0) {
                return false; // character not available enough times
            }
            freq.put(c, count - 1);
        }

        return true;
    }

    // Simple manual test
    public static void main(String[] args) {
        RansomNote solver = new RansomNote();

        System.out.println(solver.canConstruct("a", "b"));       // false
        System.out.println(solver.canConstruct("aa", "ab"));     // false
        System.out.println(solver.canConstruct("aa", "aab"));    // true
        System.out.println(solver.canConstruct("abc", "cbad"));  // true
    }
}


