class Solution {
    int[] pre;
    int total;
    public Solution(int[] w) {
        int n = w.length;
        pre = new int[n];
        total = 0;
        pre[0] = w[0];
        for(int i=1; i<n; i++)
        {
            pre[i] = pre[i-1] + w[i];
        }
        total = pre[n-1];
    }
    
    public int pickIndex() {
        Random r = new Random();
        int idx = r.nextInt(1, total+1);
        int start = 0;
        int end = pre.length-1;
        int ceil = -1;
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(idx <= pre[mid])
            {
                ceil = mid;
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return ceil;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */