class Solution {
    int max = 0;
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[][] dp = new int[satisfaction.length+1][satisfaction.length+1];
        int[] next = new int[satisfaction.length+1];
        for(int current = satisfaction.length-1; current >= 0; current--)
        {
            int[] present = new int[satisfaction.length+1];
            for(int count = satisfaction.length-1; count >= 0; count--)
            {
                present[count] = Math.max((count+1)*satisfaction[current] + next[count+1], next[count]);
            }
            next = present;
        }
        return next[0];
        // return getMaxSatisfaction(0,0,satisfaction);
    }
    private int getMaxSatisfaction(int current, int count, int[] satisfaction)
    {
        if(current == satisfaction.length)
        {
            return 0;
        }
        return Math.max((count+1)*satisfaction[current] + getMaxSatisfaction(current+1,count+1,satisfaction), getMaxSatisfaction(current+1,count,satisfaction));
    }
}