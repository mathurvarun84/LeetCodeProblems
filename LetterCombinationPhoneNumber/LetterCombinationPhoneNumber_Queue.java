package LetterCombinationPhoneNumber;

import java.util.*;

public class LetterCombinationPhoneNumber_Queue {
    // Function to return a vector that contains
// all the generated letter combinations
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

    static List<String> letterCombinationsUtil(String number, int n) {
        // To store the generated letter combinations
        ArrayList<String> list = new ArrayList<>();

        Queue<String> q = new LinkedList<>();
        q.add("");

        while (!q.isEmpty()) {
            String s = q.remove();

            // If complete word is generated
            // push it in the list
            if (s.length() == n)
                list.add(s);
            else {
                String required_number = number.substring(s.length(),s.length()+1);
                String val = phone.get(required_number);
                for (int i = 0; i < val.length(); i++) {
                    q.add(s + val.charAt(i));
                }
            }
        }
        return list;
    }

    // Function that creates the mapping and
// calls letterCombinationsUtil
    static List<String>  letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        if(digits.length()!=0) {
            output =  letterCombinationsUtil(digits, digits.length());
        }
        return output;
    }

    // Driver code
    public static void main(String args[]) {
        int[] number = {2, 3};
        int n = number.length;
        // table[i] stores all characters that
        // corresponds to ith digit in phone
        String digits = "";
        List<String> output = letterCombinations(digits);

        // Print the contents of the list
        for (int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i) + " ");
        }
    }
}
