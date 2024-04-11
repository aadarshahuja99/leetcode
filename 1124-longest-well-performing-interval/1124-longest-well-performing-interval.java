class Solution {
    public int longestWPI(int[] hours) {
        // hashmap based qn
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        int runningSum = 0;
        int numberOfDays = hours.length;
        int longestInterval = 0;
        for(int i=0; i<numberOfDays; i++)
        {
            if(hours[i] > 8)
            {
                runningSum++;
            }
            else
            {
                runningSum--;
            }
            if(runningSum > 0)
            {
                longestInterval = Math.max(longestInterval, i+1);
            }
            else
            {
                if(sumMap.containsKey(runningSum - 1))
                {
                    longestInterval = Math.max(longestInterval, i - sumMap.get(runningSum-1));
                }
            }
            if(!sumMap.containsKey(runningSum))
            {
                sumMap.put(runningSum, i);
            }
        }
        return longestInterval;
    }
}