package LetterCombinationPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination_StringBuilder {

    static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    private static void helper(String digits, List<String> result, int pos, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            result.add(new String(sb.toString()));
            return;
        }
        for (int i = pos; i < digits.length(); i++) {
            String temp = phone.get(String.valueOf(digits.charAt(i)));
            for (int j = 0; j < temp.length(); j++) {
                sb.append(temp.charAt(j));
                helper(digits, result, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0 || digits == null) {
            return result;
        }
        helper(digits, result, 0, new StringBuilder());
        return result;
    }

    // Driver code
    public static void main(String args[]) {
        String digits = "23";
        List<String> output = letterCombinations(digits);

        // Print the contents of the list
        for (int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i) + " ");
        }
    }
}
