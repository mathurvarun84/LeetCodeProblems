package WordLadder;

import java.util.*;

/*A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.



Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
*/

public class WordLadder {
    public static int wordLadder(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> mySet = new HashSet<>(wordList);
        if(!mySet.contains(endWord))
            return 0;
        Queue<String> currQueue = new LinkedList<>();
        currQueue.offer(beginWord);
        int length =0;
        //Check the words until they are empty
        while (!currQueue.isEmpty())
        {
            length++;
            //Store the length of the queue
            int size= currQueue.size();
            //Check all the words at the current level
            for(int i=0; i<size; i++) {
                String currWord = currQueue.poll();
                // Iterate on each character of the popped word
                for (int j = 0; j < currWord.length(); j++) {
                    String alpha = "abcdefghijklmnopqrstuvwxyz";
                    for(int k=0; k<alpha.length(); k++)
                    {
                        // Create a new word by replacing the jth character of the popped word
                        char[] temp = currWord.toCharArray();
                        temp[j] = alpha.charAt(k);
                        String newWord = new String(temp);
                        //Check if the new word is in dest
                        if(newWord.equals(endWord))
                            return length+1;
                        // Check if the new word is in the set
                        // If it is, push it into the queue and remove it from the set
                        if(mySet.contains(newWord))
                        {
                            currQueue.offer(newWord);
                            mySet.remove(newWord);
                        }
                    }
                }
            }
        }
        // Return 0 if no sequence exist
        return 0;
    }

    // Driver code
    public static void main(String[] args) {
        List<List<String>> wordsList = Arrays.asList(
                Arrays.asList("hog", "dot", "pot", "pop", "mop", "map", "cap", "cat"),
                Arrays.asList("hot", "dot", "lot", "log", "cog"),
                Arrays.asList("hot", "not", "dot", "lot", "cog"),
                Arrays.asList("hog", "dot", "pot", "pop", "mop", "map", "cap", "cat"),
                Arrays.asList("hot", "dot", "lot", "log", "cog","com","cam","frog")
        );
        List<String> srcList = Arrays.asList("dog", "hit", "hat", "dog", "dog");
        List<String> destList = Arrays.asList("cat", "cog", "log", "cat", "frog");

        for (int i = 0; i < srcList.size(); i++) {
            System.out.println((i + 1) + ".\tsrc: \"" + srcList.get(i) + "\"");
            System.out.println("\tdest: \"" + destList.get(i) + "\"");
            System.out.print("\tAvailable words: ");
            System.out.println(wordsList.get(i));
            System.out.println("\n\tLength of shortest chain is: " + wordLadder(srcList.get(i), destList.get(i), wordsList.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
