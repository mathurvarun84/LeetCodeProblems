package SmallestSubarrayGivenSum;
/*Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example:

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint
*/
public class SmallestSubarrayGivenSum {

        public static int smallestSubarray(int targetSum, int[] arr) {
            if(arr.length ==0) return 0;
            int minWindowSize = Integer.MAX_VALUE;
            int currentWindowSum = 0;
            int windowStart = 0;
            for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
                currentWindowSum += arr[windowEnd];

                while(currentWindowSum >= targetSum) {
                    minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                    currentWindowSum -= arr[windowStart];
                    windowStart++;
                }
            }
            if(minWindowSize == Integer.MAX_VALUE){
                return 0;
            }
            return minWindowSize;
        }

        public static void main(String[] args) {
            int[] input = new int[]{4,2,2,7,8,1,2,8,10};
            int targetSum = 8;
            System.out.println(smallestSubarray(targetSum, input));
        }
    }
