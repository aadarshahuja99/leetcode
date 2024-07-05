class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int days : bloomDay)
        {
            max = Math.max(max, days);
            min = Math.min(min, days);
        }
        int ans = -1;
        while(min <= max)
        {
            int mid = min + (max - min)/2;
            if(check(mid, m, k, bloomDay))
            {
                ans = mid;
                max = mid - 1;
            }
            else
            {
                min = mid + 1;
            }
        }
        return ans;
    }
    private boolean check(int guess, int m, int k, int[] bloomDay)
    {
        int index = 0;
        int count = 0;
        int n = bloomDay.length;
        while(index < n)
        {
            // System.out.println("loop: "+index+" "+count);
            if(bloomDay[index] <= guess)
            {
                if(k == 1)
                {
                    count++;
                    if(count == m)
                    {
                        return true;
                    }
                    index++;
                    continue;
                }
                int j = index+1;
                while(j < n && bloomDay[j] <= guess)
                {
                    if(j-index+1 == k)
                    {
                        count++;
                        j++;
                        break;
                    }
                    j++;
                }
                index=j;
            }
            else
            {
                index++;
            }
            if(count == m)
            {
                // System.out.println(guess);
                return true;
            }
        }
        // System.out.println(guess+" "+count);
        return false;
    }
}