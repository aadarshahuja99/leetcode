class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] maxRanges = new int[n+1];
        int idx = 0;
        for(int r : ranges)
        {
            if(r == 0)
            {
                idx++;
                continue;
            }
            int leftmostPoint = Math.max(0,idx-r);
            maxRanges[leftmostPoint] = Math.max(maxRanges[leftmostPoint],idx+r);
            idx++;
        }
        // for(int i=0; i<maxRanges.length; i++)
        // {
        //     System.out.println(i + " " + maxRanges[i]);
        // }
        // System.out.println();
        // applying a bfs based greedy approach to get the min number of taps to cover the garden
        int left = 0;
        int right = 0;
        int count = 0;
        while(right < n)
        {
            int farthest = 0;
            for(int j=left; j<=right; j++)
            {
                farthest = Math.max(farthest, maxRanges[j]);
            }
            left = right+1;
            right = farthest;
            // System.out.println(left+" "+right+" "+(count+1));
            if(right < left)
            {
                return -1;
            }
            count++;
        }
        return count;
    }
}