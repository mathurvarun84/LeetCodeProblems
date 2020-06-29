package CombinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result =
                new ArrayList<List<Integer>>();
        helper(candidates, target, 0, result, new ArrayList<Integer>());
        return result;
    }

    private static void helper(int[] candidates, int target, int start, List<List<Integer>> result, List<Integer> combination) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(combination));
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                //If the candidate is more than target then there is no need to proceed
                if(candidates[i] > target) break;
                if (i > start && candidates[i] == candidates[i - 1]) { // to avoid duplicates skip all equal numbers except the first
                    continue;
                }
                combination.add(candidates[i]);
                //Reduce the target sum and do the depth first search on next element
                helper(candidates, target - candidates[i], i + 1, result, combination);
                //Remove the last element and do the depth first search on the rest of the element
                combination.remove(combination.size() - 1);
            }
        }
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{10,1,2,7,6,1,5};
        int tagetSum = 8;
        List<List<Integer>> integerList = combinationSum2(arr,tagetSum);
        for(int i=0;i<integerList.size(); i ++)
        {
            System.out.println(Arrays.toString(integerList.get(i).toArray()));
        }
    }
}
