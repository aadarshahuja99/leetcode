class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int numberOfFlowers = bloomDay.length;
        if((long)numberOfFlowers < 1L*m*k)
        {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : bloomDay)
        {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int ans = -1;
        while(min <= max)
        {
            int guess = min + (max - min)/2;
            if(check(guess, bloomDay, m, k))
            {
                ans = guess;
                max = guess-1;
            }
            else
            {
                min = guess+1;
            }
        }
        return ans;
    }
    private boolean check(int guess, int[] bloomDay, int m, int k)
    {
        int segments = 0;
        int current = 0;
        int n = bloomDay.length;
        for(int i=0; i<n;)
        {
            if(bloomDay[i] > guess)
            {
                i++;
                current = 0;
                continue;
            }
            int j = i;
            while(j < n && current < k)
            {
                if(bloomDay[j] > guess)
                {
                    break;
                }
                j++;
                current++;
            }
            if(current == k)
            {
                segments++;
            }
            current = 0;
            i = j;
        }
        return segments >= m;
    }
}