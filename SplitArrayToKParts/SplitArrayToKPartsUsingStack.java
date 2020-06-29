package SplitArrayToKParts;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SplitArrayToKPartsUsingStack {

   // Function to print the maximum for
    // every k size sub-array
    static void print_max(int a[], int n, int k)
    {
        // max_upto array stores the index
        // upto which the maximum element is a[i]
        // i.e. max(a[i], a[i + 1], ... a[max_upto[i]]) = a[i]

        int[] max_upto = new int[n];

        // Update max_upto array similar to
        // finding next greater element
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int count=0;
        for (int i = 0; i < n; i++)
        {
            while (!s.empty() && a[s.peek()] < a[i])
            {
                max_upto[s.peek()] = i;
                s.pop();
            }
            s.push(i);
        }
        while (!s.empty())
        {
            max_upto[s.peek()] = n;
            s.pop();
        }
        int j = 1;
        for (int i = 0; i <= n-k; i++)
        {
            // j < i is to check whether the
            // jth element is outside the window
            while (j < i || max_upto[j] < i + k)
            {
                j++;
            }
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }

    // Main Entry function code
    public static void main(String[] args) {
        int arr[] = {3,6,7,2,8,0,11};
        int n = arr.length;
        print_max(arr, arr.length,3);
    }
}


