package MedianOfDataStream;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfDataStream {


    PriorityQueue<Integer> maxHeapForSmallNum; //containing first half of numbers
    PriorityQueue<Integer> minHeapForLargeNum; //containing second half of numbers

    public MedianOfDataStream()
    {
        minHeapForLargeNum = new PriorityQueue<>();
        maxHeapForSmallNum = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void insertNum(int num) {
        if(maxHeapForSmallNum.isEmpty() || maxHeapForSmallNum.peek()>=num)
        {
            maxHeapForSmallNum.add(num);
        }
        else
            minHeapForLargeNum.add(num);

        // either both the heaps will have equal number of elements or max-heap will have one
        // more element than the min-heap
        if(maxHeapForSmallNum.size()> minHeapForLargeNum.size()+1)
        {
            minHeapForLargeNum.add(maxHeapForSmallNum.poll());
        }
        else if(maxHeapForSmallNum.size()<minHeapForLargeNum.size())
        {
            maxHeapForSmallNum.add(minHeapForLargeNum.poll());
        }
    }

    public double findMedian() {
       double  median = 0.0;
       if(minHeapForLargeNum.size() == maxHeapForSmallNum.size())
       {
           median = (minHeapForLargeNum.peek() + maxHeapForSmallNum.peek())/2.0;
       }
       else
           median = maxHeapForSmallNum.peek();
       return median;
    }

    public static void main(String[] args) {
        // Driver code
        int[] nums = {35, 22, 30, 25, 1};
        MedianOfDataStream medianOfAges = null;
        for(int i=0; i< nums.length; i++){
            System.out.print(i+1);
            System.out.print(".\tData stream: [");
            medianOfAges = new MedianOfDataStream();
            for(int j=0; j<=i; j++){
                System.out.print(nums[j]);
                if(j != i)
                    System.out.print(", ");
                medianOfAges.insertNum(nums[j]);
            }
            System.out.println("]");
            System.out.println("\tThe median for the given numbers is: " + medianOfAges.findMedian());
        }

    }
}
