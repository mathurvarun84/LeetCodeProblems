package ValidPalindrome;

public class ValidPalindrome {
    /**
     * Check if a string is a palindrome after converting to lowercase
     * and removing non-alphanumeric characters.
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(1)
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            // Skip non-alphanumeric characters from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            
            // Skip non-alphanumeric characters from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            
            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    // Alternative approach: Clean string first, then check
    public boolean isPalindromeAlternative(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        // Build cleaned string with only alphanumeric characters
        StringBuilder cleaned = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        
        String cleanedStr = cleaned.toString();
        int left = 0;
        int right = cleanedStr.length() - 1;
        
        while (left < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    // Test cases
    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();
        
        // Test case 1: "A man, a plan, a canal: Panama"
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama")); // true
        
        // Test case 2: "race a car"
        System.out.println(solution.isPalindrome("race a car")); // false
        
        // Test case 3: " "
        System.out.println(solution.isPalindrome(" ")); // true
        
        // Test case 4: "Madam"
        System.out.println(solution.isPalindrome("Madam")); // true
    }
}

