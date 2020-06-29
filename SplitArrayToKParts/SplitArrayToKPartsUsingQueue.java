package SplitArrayToKParts;

import java.util.Deque;
import java.util.LinkedList;

//Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.
/*Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
        Output: 3 3 4 5 5 5 6
        Explanation:
        Maximum of 1, 2, 3 is 3
        Maximum of 2, 3, 1 is 3
        Maximum of 3, 1, 4 is 4
        Maximum of 1, 4, 5 is 5
        Maximum of 4, 5, 2 is 5
        Maximum of 5, 2, 3 is 5
        Maximum of 2, 3, 6 is 6*/
public class SplitArrayToKPartsUsingQueue{
    // A Dequeue (Double ended queue) based method for printing maximum element of
// all subarrays of size k
private static void printMax(int arr[], int n, int k)
        {
        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<>();

        /* Process first k (or first window) elements of array */
        int i;
        for (i = 0; i < k; ++i) {
        // For every element, the previous smaller elements are useless so
        // remove them from Qi
                RemoveAndAddToQ(Qi, i, arr);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i) {
        // The element at the front of the queue is the largest element of
        // previous window, so print it
        System.out.print(arr[Qi.peek()] + " ");

        // Remove the elements which are out of this window
        while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
        Qi.removeFirst();

        // Remove all elements smaller than the currently
        // being added element (remove useless elements)
                RemoveAndAddToQ(Qi, i, arr);
        }

        // Print the maximum element of last window
        System.out.print( arr[Qi.peek()]);
        }

        private static void RemoveAndAddToQ(Deque<Integer> qi, int i, int[] arr) {
                while ((!qi.isEmpty()) && arr[i] >= arr[qi.peekLast()])
                        qi.removeLast(); // Remove from rear

                // Add new element at rear of queue
                qi.addLast(i);
        }

        // Driver program to test above functions
public static void main(String[] args)
        {
        int arr[] = {7,6,8,2,9,0,11 };
        int k = 3;
        printMax(arr, arr.length, k);
        }
        }