package IsSubsequence;

public class IsSubsequence {

    /**
     * Returns true if s is a subsequence of t.
     *
     * Two-pointer approach:
     * - i scans s, j scans t
     * - When chars match, move i (and j); otherwise move only j
     * - If we consume all of s (i == s.length()), s is a subsequence of t
     *
     * Time Complexity: O(|t|)
     * Space Complexity: O(1)
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        int i = 0; // pointer for s
        int j = 0; // pointer for t

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }

    // Simple manual tests
    public static void main(String[] args) {
        IsSubsequence solver = new IsSubsequence();

        System.out.println(solver.isSubsequence("abc", "ahbgdc"));  // true
        System.out.println(solver.isSubsequence("axc", "ahbgdc"));  // false
        System.out.println(solver.isSubsequence("", "ahbgdc"));     // true (empty string is subsequence)
        System.out.println(solver.isSubsequence("a", ""));          // false
        System.out.println(solver.isSubsequence("ace", "abcde"));   // true
    }
}



