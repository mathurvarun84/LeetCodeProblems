package FindPeakElement;

public class FindPeakElement {

    public static int findPeakElement(int[] nums)
    {
        // use binary search ans
        int numsLength = nums.length;
        int left = 0, right = numsLength - 1;
        while (left + 1< right) {
            int mid = left + (right - left) / 2;
            //If mid is greater than its previous and its next value then it is the answer
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            }
            //If mid is greater than its previous value then search right
            if (nums[mid] > nums[mid - 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        //if the last two elements are left over then check if left is greater than right
        //if yes then return left or return right
        if (nums[left] > nums[right]) return left;
        return right;
    }

    public static void main(String[] args)
    {
        int nums[] = new int[]{5,2,2,3,1};
        System.out.println("The peak element is " + findPeakElement(nums));
    }
}
