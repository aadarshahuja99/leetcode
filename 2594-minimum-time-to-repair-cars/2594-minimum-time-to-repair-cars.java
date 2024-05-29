class Solution {
    public long repairCars(int[] ranks, int cars) {
        int max = ranks[0];
        for(int i=1; i<ranks.length; i++)
        {
            if(ranks[i] > max)
            {
                max = ranks[i];
            }
        }
        long start = 1;
        long end = (long)cars*cars*max;
        // System.out.println(start+" "+end);
        long ans = 0;
        while(start<=end)
        {
            long mid = start + (end-start)/2;
            if(check(ranks,cars,mid))
            {
                end = mid-1;
                ans = mid;
            }
            else
            {
                start = mid+1;
            }
        }
        return ans;
    }
    private boolean check(int[] ranks, int cars, long current)
    {
        long sum = 0;
        // how many cars can each mechanic repair in n minutes
        for(int i=0; i<ranks.length; i++)
        {
            sum += (int)Math.floor(Math.sqrt((double)current/((double)(ranks[i]))));
        }
        return sum >= cars;
    }
}