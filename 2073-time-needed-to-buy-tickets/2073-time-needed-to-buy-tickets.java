class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int candidate = tickets[k];
        int ans = 0;
        for(int i=0; i<tickets.length; i++)
        {
            if(i <= k)
            {
                ans += Math.min(candidate, tickets[i]);
            }
            else
            {
                if(candidate > tickets[i])
                {
                    ans += tickets[i];
                }
                else
                {
                    ans += candidate-1;
                }
            }
        }
        return ans;
    }
}