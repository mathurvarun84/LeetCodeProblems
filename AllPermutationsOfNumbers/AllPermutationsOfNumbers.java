package AllPermutationsOfNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Given a collection of distinct integers, return all possible permutations.
public class AllPermutationsOfNumbers {
    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, nums.length, result);
        return result;
    }

    private static void permute(int[] nums, int start, int end, List<List<Integer>> output) {
        if (start == end) {
            output.add(toList(nums));
            return;
        }

        for (int i = start; i < end; i++) {
            //swapping b/w nums[start] and nums[i]
            swap(nums, start, i);
            permute(nums, start + 1, end, output);
            //swapping it again such that overall swapping has no effect on nums array
            swap(nums, start, i);
        }
    }

    private static void swap(int[] arr, int lhs, int rhs) {
        int tmp = arr[lhs];
        arr[lhs] = arr[rhs];
        arr[rhs] = tmp;
    }

    private static List<Integer> toList(int[] arr) {
        List<Integer> result = new ArrayList<>(arr.length);
        for (int num: arr) {
            result.add(num);
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{1,2,3,4};
        List<List<Integer>> integerList = permute(arr);
        for(int i=0;i<integerList.size(); i ++)
        {
            System.out.println(Arrays.toString(integerList.get(i).toArray()));
        }
    }
}
