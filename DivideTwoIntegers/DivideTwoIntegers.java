package DivideTwoIntegers;

public class DivideTwoIntegers {
    public static int divideWithoutShifts(int dividend, int divisor) {
        //Check for the maximum value. The system overflows if the divisor is -1 and dividend is the integer min value.
        // if that is the case then return the maxvalue of integer
        if(dividend==Integer.MIN_VALUE && divisor==-1)return Integer.MAX_VALUE;
        if(divisor==1)return dividend;

        int count=0;
        int divi=Math.abs(dividend);
        int div=Math.abs(divisor);
        while((divi-div)>=0){
            //A special case when the divisor is integer max value and divisor is 1
            if(count==Integer.MAX_VALUE)return Integer.MAX_VALUE;
            else count++;
            divi-=div;
        }
        //if the divisor or the dividend is negative then the answer will be negative
        if((divisor<0 && dividend>=0) || (divisor>=0 && dividend<0))return count*(-1);
        return count;

    }

    public static int divideWithShifts(int dividend, int divisor)
    {
        // handling special/edge cases
        if (divisor == 0)
            return Integer.MAX_VALUE;
        if (divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        // decide sign of resultant
        boolean isPositive = true;
        if ((divisor < 0) ^ (dividend < 0))
            isPositive = false;

        // using long to handle cases like, dividend = INT_MIN, divisor = 1
        long divid = Math.abs((long)dividend);
        long divis = Math.abs((long)divisor);

        // ans to store final result
        int ans = 0;
        while (divid >= divis) {

            // calculate number of left shifts
            int shifts = 0;
            while (divid >= (divis << shifts))
                shifts ++;

            // update answer
            ans += (1 << (shifts - 1));

            // dividend minus the largest shifted divisor
            divid -= (divis << (shifts - 1));
        }

        // return answer alongwith sign
        if (isPositive)
            return ans;
        return -ans;
    }
    public static void main(String[] args)
    {
        int value = divideWithShifts(Integer.MAX_VALUE,3);
        System.out.println(" Answer is " + value);
    }
}
