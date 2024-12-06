class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        // math
        Arrays.sort(banned);
        int len = banned.length;
        int start = 0;
        int end = 0;
        LinkedList<int[]> list = new LinkedList<>();
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
            list.addLast(new int[] { rangeStart, rangeEnd });
        }
        if(banned[0] != 1)
        {
            list.addFirst(new int[] { 1, banned[0]-1 });
        }
        int rem = maxSum;
        int ans = 0;
        while(list.size() > 0)
        {
            int[] interval = list.poll();
            // System.out.println(interval[0]+" "+interval[1]);
            int total = ((interval[1]-interval[0]+1)*(interval[0] + interval[1]))/(2);
            if(total <= rem)
            {
                rem -= total;
                ans += interval[1]-interval[0]+1;
            }
            else
            {
                int current = interval[0];
                while(rem > 0 && current <= n)
                {
                    if(current > rem)
                    {
                        break;
                    }
                    rem -= current;
                    ans++;
                    current++;
                }
            }
        }
        return ans;
    }
}