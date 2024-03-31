class Solution {
    public int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        int[][] countMap = new int[n][26];
        for(int it = 0; it < n; it++)
        {
            String sticker = stickers[it];
            for(int i=0; i<sticker.length(); i++)
            {
                int index = sticker.charAt(i) - 97;
                countMap[it][index]++;
            }
        }
        int maxState = (int)Math.pow(2, target.length()) - 1;
        int[][] dp = new int[target.length()][maxState+1];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        int ans = getAns(0, maxState, target, stickers, countMap, dp);
        if(ans > 15)
        {
            return -1;
        }
        return ans;
    }
    private int getAns(int current, int state, String target, String[] stickers, int[][] countMap, int[][] dp)
    {
        if(current == target.length())
        {
            return state == 0 ? 0 : 16;
        }
        if(dp[current][state] != -1)
        {
            return dp[current][state];
        }
        if((state&(1<<current)) == 0)
        {
            return getAns(current+1, state, target, stickers, countMap, dp);
        }
        int ans = 16;
        for(int i=0; i<stickers.length; i++)
        {
            int[] counts = new int[26];
            for(int j=0; j<26; j++)
            {
                counts[j] = countMap[i][j];
            }
            int newState = state;
            for(int idx = current; idx < target.length(); idx++)
            {
                int alphabet = target.charAt(idx) - 97;
                if(counts[alphabet] > 0 && (newState&(1<<idx)) > 0)
                {
                    counts[alphabet]--;
                    newState = (newState^(1<<idx));
                    // System.out.println("taking an alphabet: "+target.charAt(idx)+ " from "+stickers[i]+" newState "+newState);
                }
            }
            if(newState != state)
            {
                // System.out.println("calling for newstate: "+newState+" from "+state);
                ans = Math.min(1 + getAns(current+1, newState, target, stickers, countMap, dp), ans);
            }
        }
        return dp[current][state] = ans;
    }
}