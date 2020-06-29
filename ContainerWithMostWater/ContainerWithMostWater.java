package ContainerWithMostWater;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxarea = 0, start = 0, end = height.length - 1;
        while (start < end) {
            int diff = end - start;

            //Take the minimum of height and then multiply it with width to get the maximum area
            maxarea = Math.max(maxarea, Math.min(height[start], height[end]) * (diff));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxarea;
    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{1,8,3,5,2,5,4,6,7};
        int area = maxArea(arr);
        System.out.println(area);
    }
}
