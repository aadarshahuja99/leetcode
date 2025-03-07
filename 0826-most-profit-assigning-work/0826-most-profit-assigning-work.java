class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int jobs = profit.length;
        int[] pre = new int[jobs];
        Integer[][] combined = new Integer[jobs][2];
        for(int i=0; i<jobs; i++)
        {
            combined[i][0] = difficulty[i];
            combined[i][1] = profit[i];
        }
        Arrays.sort(combined, (a, b) -> {
            return a[0] - b[0];
        });
        pre[0] = combined[0][1];
        for(int i=1; i<jobs; i++)
        {
            pre[i] = Math.max(pre[i-1], combined[i][1]);
        }
        int ans = 0;
        for(int w : worker)
        {
            int floor = findFloor(combined, w);
            if(floor != -1)
            {
                ans += pre[floor];
            }
        }
        return ans;
    }
    private int findFloor(Integer[][] combined, int t)
    {
        int floor = -1;
        int s = 0;
        int e = combined.length-1;
        while(s <= e)
        {
            int m = s + (e - s)/2;
            if(combined[m][0] <= t)
            {
                floor = m;
                s = m+1;
            }
            else
            {
                e = m-1;
            }
        }
        return floor;
    }
}