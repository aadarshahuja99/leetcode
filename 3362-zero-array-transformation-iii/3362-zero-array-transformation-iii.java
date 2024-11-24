class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int[][] copiedQueries = Arrays.copyOf(queries, queries.length);
        int n = nums.length;
        int q = queries.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for(int i=1; i<n; i++)
        {
            pre[i] = pre[i-1] + nums[i];
        }
        if(pre[n-1] == 0)
        {
            return q;
        }
        Arrays.sort(copiedQueries, (a, b) -> {
            return b[1] - a[1];
        });
        // for(int[] qu : copiedQueries)
        // {
        //     System.out.println(qu[0] + " " + qu[1]);
        // }
        int start = 0;
        int end = q-1;
        int ans = -1;
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(check(mid, nums, copiedQueries))
            {
                ans = mid;
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        if(ans == -1)
        {
            return ans;
        }
        return q - (ans+1);
    }
    private boolean check(int guess, int[] nums, int[][] quer)
    {
        int n = nums.length;
        int[] hash = new int[n+1];
        for(int i=0; i<=guess; i++)
        {
            hash[quer[i][0]]++;
            hash[quer[i][1] + 1]--;
        }
        int total = 0;
        for(int i=0; i<n; i++)
        {
            total += hash[i];
            if(total < nums[i])
            {
                // System.out.println("false for "+guess+" at index " + i +" " + total);
                return false;
            }
        }
        // System.out.println("true for "+guess);
        return true;
    }
}