class Solution {
    public int findKthPositive(int[] arr, int k) {
        int[] pre = new int[arr.length];
        int it = 1;
        for(int i=0; i<arr.length; i++)
        {
            pre[i] = arr[i] - (i+1);
        }
        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(pre[mid] < k)
            {
                ans = mid;
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        if(ans == -1)
        {
            return k;
        }
        return arr[ans] + k - pre[ans];
    }
}