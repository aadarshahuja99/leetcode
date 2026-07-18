class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] costs = new long[26][26];
        for(int i=0; i<26; i++)
        {
            for(int j=0; j<26; j++)
            {
                if(i==j)
                {
                    costs[i][j] = 0;
                }
                else
                {
                    costs[i][j] = Long.MAX_VALUE;
                }
            }
        }
        for(int i=0; i<original.length; i++)
        {
            int from = ((int)original[i])-97;
            int to = ((int)changed[i])-97;
            costs[from][to] = Math.min(cost[i],costs[from][to]);
            // System.out.println()
        }
        for(int k=0; k<26; k++)
        {
            for(int i=0; i<26; i++)
            {
                int from = i;
                for(int j=0; j<26; j++)
                {
                    int to = j;
                    int via = k;
                    if(costs[from][via] == Long.MAX_VALUE || costs[via][to] == Long.MAX_VALUE)
                    {
                        continue;
                    }
                    costs[from][to] = Math.min(costs[from][to], costs[from][via] + costs[via][to]);
                    // System.out.println("cost of "+from+" to "+to+" = "+costs[from][to]);
                }
            }
        }
        long ans = 0L;
        for(int i=0; i<source.length(); i++)
        {
            if(source.charAt(i) != target.charAt(i))
            {
                if(costs[((int)source.charAt(i))-97][((int)target.charAt(i))-97] == Long.MAX_VALUE)
                {
                    return -1;
                }
                ans += costs[((int)source.charAt(i))-97][((int)target.charAt(i))-97];
            }
        }
        return ans;
    }
}