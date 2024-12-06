class Solution {
    public int maxCount(int[] banned, int n, long maxSum) {
        // math
        Arrays.sort(banned);
        int len = banned.length;
        int start = 0;
        int end = 0;
        LinkedList<long[]> list = new LinkedList<>();
        int lastEnd = -1;
        while(end < len && lastEnd < n)
        {
            int j = end+1;
            while(j < len && banned[j] == banned[j-1]+1)
            {
                j++;
            }
            int rangeStart = (banned[j-1] + 1);
            int rangeEnd = Math.min(j < len ? banned[j] - 1 : n, n);
            end = j;
            lastEnd = rangeEnd;
            // System.out.println("candidate: "+rangeStart+","+rangeEnd);
            if(rangeStart > rangeEnd || (rangeStart == 0 || rangeEnd == 0))
            {
                continue;
            }
            list.addLast(new long[] { rangeStart*1l, rangeEnd*1l });
        }
        if(banned[0] != 1)
        {
            list.addFirst(new long[] { 1l, (banned[0]-1)*1l });
        }
        long rem = maxSum;
        int ans = 0;
        while(list.size() > 0)
        {
            long[] interval = list.poll();
            // System.out.println(interval[0]+" "+interval[1]);
            long total = (1l*(interval[1]-interval[0]+1)*1l*(interval[0] + interval[1]))/(2l);
            if(total <= rem)
            {
                rem -= total;
                ans += (interval[1]-interval[0]+1);
            }
            else
            {
                long a = interval[0];
                if(a > rem)
                {
                    break;
                }
                long length = (long)Math.floor(((1 - 2*a) + Math.sqrt(Math.pow(2*a - 1, 2) + 8*rem))/(2l));
                long sumWithHigher = (length+1)*(2*a + length)/2l;
                // System.out.println(length+" "+a+" "+rem+" "+ans);
                if(sumWithHigher <= rem)
                {
                    ans += length + 1;
                }
                else
                {
                    ans += length;
                }
                break;
            } 
        }
        return ans;
    }
}