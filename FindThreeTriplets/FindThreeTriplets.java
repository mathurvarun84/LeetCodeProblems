package FindThreeTriplets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class FindThreeTriplets {

    // function to print triplets with 0 sum
    static  List<List<Integer>> findTriplets(int nums[])
    {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return result;
        // sort numsay elements
        Arrays.sort(nums);

        for (int index=0; index<nums.length-2; index++)
        {
            if(index == 0 || (index > 0 && (nums[index] != nums[index-1]))) {
                // initialize left and right
                int left = index + 1;
                int right = nums.length - 1;
                int current = nums[index];
                while (left < right) {
                    int sum = current + nums[left] + nums[right];
                    if (sum == 0) {
                        result.add(Arrays.asList(current, nums[left], nums[right]));
                        //if the same value is in the left then move the left
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        //if the same value is there in the right then move right
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }

                    // If sum of three elements is less
                    // than zero then increment in left
                    else if (sum < 0)
                        left++;

                        // if sum is greater than zero than
                        // decrement in right side
                    else
                        right--;
                }
            }
        }
       return result;
    }

    // Driven source
    public static void main (String[] args) {

        int nums[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = findTriplets(nums);
        for (List<Integer> list: result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
//This code is contributed by Tushil..
}

