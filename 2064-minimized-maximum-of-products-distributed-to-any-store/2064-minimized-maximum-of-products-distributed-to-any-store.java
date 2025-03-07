class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int max = 0;
        for(int q : quantities)
        {
            max = Math.max(max, q);
        }
        int ans = 0;
        int min = 1;
        while(min <= max)
        {
            int m = min + (max - min)/2;
            if(check(m, n, quantities))
            {
                ans = m;
                max = m-1;
            }
            else
            {
                min = m+1;
            }
        }
        return ans;
    }
    private boolean check(int guess, int n, int[] q)
    {
        int idx = 0;
        int count = 0;
        while(idx < q.length)
        {
            int curr = q[idx];
            int stores = curr%guess == 0 ? curr/guess : (curr/guess)+1;
            count += stores;
            idx++;
        }
        return count <= n;
    }
}