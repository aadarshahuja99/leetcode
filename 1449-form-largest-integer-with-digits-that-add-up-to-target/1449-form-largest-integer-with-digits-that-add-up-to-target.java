class Solution {
    public String largestNumber(int[] cost, int target) {
        int[] cache = new int[target+1];
        for(int i=1; i<=target; i++)
        {
            cache[i] = -10000; // initially we do not know the longest length of the word that can be formed with the target as i
            for(int j=0; j<=8; j++)
            {
                if(cost[j] <= i)
                {
                    cache[i] = Math.max(cache[i], 1 + cache[i - cost[j]]);
                }
            }
        }
        // System.out.println(cache[target]);
        if(cache[target] < 0)
        {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for(int i=8; i>=0; i--)
        {
            while(target >= cost[i] && cache[target] == cache[target - cost[i]] + 1)
            {
                ans.append(i+1);
                target -= cost[i];
            }
        }
        return ans.toString();
    }
}