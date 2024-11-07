package SlidingWindowMaximum;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.stream.Stream;
public class SlidingWindowMaximum {
    // function to find the maximum in all possible windows
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // If the length of input array is 1, return the input array
       if(nums.length == 1)
         return nums;

        // initializing variables
        int [] output = new int[nums.length - k + 1];
        Deque<Integer> currentWindow = new ArrayDeque<>();

        for(int i=0; i<nums.length;i++)
        {
            // remove first index from the currentWindow if it has fallen out of the current window
            if(!currentWindow.isEmpty() && currentWindow.getFirst()<=(i-k))
            {
                currentWindow.removeFirst();
            }
            cleanUp(i,currentWindow,nums);
            currentWindow.add(i);

            // adding the maximum element of the current window to the output list
            if(i>=k-1) {
                output[i - k + 1] = nums[currentWindow.getFirst()];
            }
        }
        return output;

    }

    //function to clean up
    public static Deque<Integer> cleanUp(int i, Deque<Integer> currentWindow, int[] nums)
    {
        // remove all the indexes from currentWindow whose corresponding values are smaller than or equal to the current element
        while(currentWindow.size()!=0 && nums[i]>=nums[currentWindow.getLast()])
        {
            currentWindow.removeLast();
        }
        return currentWindow;
    }

    // driver code
    public static void main(String args[]) {
        int windowSizes [] = {3, 3, 3, 3, 2, 4, 3, 2, 3, 6,1};
        int [][] numLists = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                {1, 5, 8, 10, 10, 10, 12, 14, 15, 19, 19, 19, 17, 14, 13, 12, 12, 12, 14, 18, 22, 26, 26, 26, 28, 29, 30},
                {10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67},
                {4, 5, 6, 1, 2, 3},
                {9, 5, 3, 1, 6, 3},
                {2, 4, 6, 8, 10, 12, 14, 16},
                {-1, -1, -2, -4, -6, -7},
                {4, 4, 4, 4, 4, 4},
                {1,-1}
        };

        for (int i = 0; i < numLists.length; i++) {
            System.out.println(i + 1 + ".\tInput array:\t" + Arrays.toString(numLists[i]));
            System.out.println("\tWindow size:\t" + windowSizes[i]);
            System.out.println("\n\tMaximum in each sliding window:\t" + Arrays.toString(maxSlidingWindow(numLists[i], windowSizes[i])));
            Stream.generate(() -> "-").limit(100).forEach(System.out::print);
            System.out.println();
        }
    }
}
