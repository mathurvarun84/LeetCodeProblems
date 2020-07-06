package CapacityShipPackages;
/*A conveyor belt has packages that must be shipped from one port to another within D days.

The i-th package on the conveyor belt has a weight of weights[i].
Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
 We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.

Example

Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
Output: 15
Explanation:
A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given,
so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
*/

public class CapacityShipPackages {
    public static int shipWithinDays(int[] weights, int D) {
        int start = Integer.MIN_VALUE;
        int end = 0;
        int result = -1;

        //We need to start from the maximum weight as minimum weight a ship can carry
        //should be greater than the maximum weight
        for(int weight : weights){
            end+=weight;
            start = Math.max(start,weight);
        }

        //Do binary search to reduce the search space
        while(start<=end){
            int mid = start+(end-start)/2;

            // check if it is possible to distribute
            // weights by using mid is current minimum
            if(isValid(weights,D,mid)){
                result = mid;
                end = mid-1;
            }
            else
                start = mid+1;
        }
        return result;
    }

    private static boolean isValid(int[] weights,int minDays,int capacity){
        int daysNeeded =1;
        int weightSum = 0;

        for(int weight : weights){
            //if weights[i] > capacity, it means this good can not be shiped under certain capacity
            if(weight > capacity){
                return false;
            }
            weightSum+=weight;

            // count how many days are required
            // to distribute current mid.
            //If found then increase the no of days
            // and make the sum to that weight to give the next weight to next day
            if(weightSum>capacity){
                daysNeeded++;
                weightSum = weight;
            }

            //If the no. of days increased than min no of days then return false
            if(daysNeeded>minDays)
                return false;
        }
        return true;
    }

    // Driver Method
    public static void main(String[] args)
    {
        //Number of pages in books
        int weights[] = {1,2,3,4,5,6,7,8,9,10};

        int days = 5; //No. of days

        System.out.println("Minimum number of days = " +
                shipWithinDays(weights, days));
    }
}
