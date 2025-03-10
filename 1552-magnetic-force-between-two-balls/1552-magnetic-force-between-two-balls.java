class Solution {
    public int maxDistance(int[] position, int m) {
        // BF: place the first ball in the 1st basket. Then for every possible distance 'd', check if it is possible to place balls such that the min distance between them is 'd'.
        Arrays.sort(position);
        int min = position[0];
        int max = position[position.length-1];
        int start = 1;
        int end = max-min;
        int ans = -1;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(check(mid,position,m))
            {
                start = mid+1;
                ans = mid;
            }
            else
            {
                end = mid-1;
            }
        }
        return ans;
    }
    private boolean check(int current, int[] position, int m)
    {
        int last = position[0];
        int i=1;
        int count = 1;
        while(i<position.length)
        {
            if(position[i]-last < current)
            {
                i++;
            }
            else
            {
                count++;
                if(count == m)
                {
                    break;
                }
                last = position[i];
                i++;
            }
        }
        return count == m;
    }
}