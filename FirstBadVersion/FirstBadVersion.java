package FirstBadVersion;

/*You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.



Example 1:

Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
Example 2:

Input: n = 1, bad = 1
Output: 1

 */
public class FirstBadVersion {
    public static int v;

    public static boolean isBadVersion(int s) {
        return s >= v;
    }

    public static int[] firstBadVersion(int n) {
        int[] result = new int[2];
        int calls=0;
        int first =1;
        int last =n;
        int mid=0;
        while(first<=last)
        {
            mid = first+(last-first)/2;
            if(isBadVersion(mid))
            {
                last = mid-1;
            }
            else {
                first = mid + 1;
            }
            calls++;
        }
        result[0]= first;
        result[1]=calls;
        return result;
    }

    // Driver code
    public static void main(String args[]) {
        int[] testCaseVersions = new int[] {38, 13, 29, 40, 23};
        int[] firstBadVersion = new int[] {28, 10, 10, 28, 19};

        for (int i = 0; i < testCaseVersions.length; i++) {
            v = firstBadVersion[i];
            if (i > 0) {
                System.out.println();
            }
            System.out.println(i + 1 + ".\tNumber of versions: " + testCaseVersions[i]);
            int[] result = firstBadVersion(testCaseVersions[i]);
            System.out.println("\n\tFirst bad version: " + result[0] + ". Found in " + result[1] + " API calls.");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
