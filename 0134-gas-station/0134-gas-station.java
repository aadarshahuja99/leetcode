class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost = 0;
        int totalEarned = 0;
        int start = -1;
        int current = 0;
        for(int i=0; i<gas.length; i++)
        {
            current += gas[i] - cost[i];
            totalEarned += gas[i];
            totalCost += cost[i];
            if(current >= 0 && start == -1)
            {
                start = i;
            }
            else if(current < 0)
            {
                current = 0;
                start = -1;
            }
        }
        return totalCost > totalEarned ? -1 : start;
    }
}