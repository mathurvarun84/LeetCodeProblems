package GreatestSumDivisibleByThree;

public class GreatestSumDivisibleByThree {
    //Idea behind this algorithm is that we need the greatest sum divisible by 3,
    // we just need to get the sum of the entire array and subtract the smaller number
    // that would remove the remainder if it is not divisible by 3.
    public static int maxSumDivThree(int[] nums) {
        int sum = 0;
        int oneRemainder = 99999999;
        int twoRemainder = 99999999;

        for(int num : nums)
        {
            sum += num;

            if(num % 3 == 1)
            {
                twoRemainder = Math.min(twoRemainder, oneRemainder + num);
                oneRemainder = Math.min(oneRemainder, num);
            }

            if(num % 3 == 2)
            {
                oneRemainder = Math.min(oneRemainder, twoRemainder + num);
                twoRemainder = Math.min(twoRemainder, num);

            }
        }

        if(sum % 3 == 0)
            return sum;

        if(sum % 3 == 1)
            return sum - oneRemainder;

        if(sum % 3 == 2)
            return sum - twoRemainder;

        return 0;

    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1,2,3,4,4};
        int sum = maxSumDivThree(nums);
        System.out.println(sum);
    }
}
