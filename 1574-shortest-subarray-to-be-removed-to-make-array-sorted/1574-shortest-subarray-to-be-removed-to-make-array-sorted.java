class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        // 3 possibilities, an array that starts from the 1st element and goes on
        // an array that ends at last element
        // or an array that contains segments of the above 2 arays
        // 2 pointer based approach
        int startLength = 0;
        int endLength = 0;
        int n = arr.length;
        int i=0;
        while(i+1 < n && arr[i] <= arr[i+1])
        {
            i++;
        }
        if(i == n-1)
        {
            return 0;
        }
        startLength = i+1;
        i=n-1;
        while(i-1 >= 0 && arr[i] >= arr[i-1])
        {
            i--;
        }
        if(i == 0)
        {
            return 0;
        }
        endLength = n - i;
        int ans = Math.max(endLength, startLength);
        int left = startLength-1;
        int right = n-1;
        int rightSegment = 0;
        while(right >= i)
        {
            while(left >= 0 && arr[left] > arr[right])
            {
                left--;
            }
            rightSegment++;
            // System.out.println(rightSegment+" "+left+" "+ans);
            ans = Math.max(left + 1 + rightSegment, ans);
            right--;
        }
        return n - ans;
    }
}