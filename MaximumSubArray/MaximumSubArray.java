package MaximumSubArray;

import java.util.Map;

public class MaximumSubArray {
    public static int maxSubArray(int[] arr) {

        int max = Integer.MIN_VALUE;
        int curr = 0;
        for(int index=0;index<arr.length;index++){
            curr += arr[index];
            curr = Math.max(curr, arr[index]);
            if(curr > max) max = curr;
        }
        return max;
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int max = maxSubArray(arr);
        System.out.println(max);
    }
}
