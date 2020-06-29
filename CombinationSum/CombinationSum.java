package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList();
        List combination=new ArrayList();
        if(candidates==null || candidates.length==0)
            return result;
        Arrays.sort(candidates);
        findCombinations(result,combination,candidates,target,0);
        return result;
    }
    private static  void findCombinations(List<List<Integer>> result, List combination, int[] candidates, int target, int start){
        if(target==0){
            result.add(new ArrayList<>(combination));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]>target)
                break;
            combination.add(candidates[i]);
            findCombinations(result,combination,candidates,target-candidates[i],i);
            combination.remove(combination.size()-1);
        }
    }

    public static void main(String[] args)
    {
        int[] candidates = new int[]{2,3,5};
        int targetSum = 8;
        List<List<Integer>> integerList =combinationSum(candidates,targetSum);
       for(int i=0;i<integerList.size(); i ++)
       {
           System.out.println(Arrays.toString(integerList.get(i).toArray()));
        }

    }
}
