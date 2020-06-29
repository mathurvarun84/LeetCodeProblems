package PartitionEqualSubsetSum;

public class PartitionEqualSubsetSum_BottomUp_First{
    // Returns true if arr[] can be partitioned in two subsets of
    // equal sum, otherwise false
    public static boolean canPartition(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return false;
        }

        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if (totalSum % 2 == 0) {
            return findSubsetOfSum(nums, totalSum/2);
        } else {
            return false;
        }

    }

    private static boolean findSubsetOfSum(int[] elements, int totalSum) {

        // Cache
        boolean[][] elementsToSumCache = new boolean[elements.length + 1][totalSum + 1]; // 1 extra to accommodate 0

        // Initialization / base condition
        for (int i = 0; i <= elements.length; i++) {
            // with any number of elements we can make 0 sum by not using any elements
            elementsToSumCache[i][0] = true;
        }

        for (int i = 1; i <= totalSum; i++) {
            // with 0 elements we can't make any non-zero sum
            elementsToSumCache[0][i] = false;
        }

        for (int element = 1; element <= elements.length; element++) {
            if(elements[element-1]>totalSum) continue;
            for (int sum = 1; sum <= totalSum; sum++) {
                if (sum >= elements[element - 1]) {
                    // if current element can be removed from sum and produce a 0 or non-negative value

                    // we can either take it or leave it; which ever yields us a true value
                    // because in that case there is at least one way to achieve the desired sum
                    elementsToSumCache[element][sum] = elementsToSumCache[element - 1][sum] || elementsToSumCache[element - 1][sum - elements[element - 1]];
                } else {
                    // we can't take it
                    elementsToSumCache[element][sum] = elementsToSumCache[element - 1][sum];
                }
                printBooleanMatrix(elementsToSumCache,totalSum,elements.length);
            }
        }

        return elementsToSumCache[elements.length][totalSum];
    }

    public static void printBooleanMatrix(boolean[][] array,int sum, int n) {
        for (int i = 0; i <= n; i++) {
            {
                for(int j=0;j<=sum;j++) {
                    if (array[i][j]) {
                        System.out.print("1");
                    } else {
                        System.out.print("0");
                    }
                }
                System.out.println();
            }

        }
        System.out.println();
    }

    public static void main (String[] args)
    {
        int arr[] = {1,2,4,5};
        if (canPartition(arr) == true)
            System.out.println("Can be divided into two subsets of equal sum");
        else
            System.out.println("Can not be divided into two subsets of equal sum");

    }

}