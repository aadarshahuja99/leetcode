class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int q = queries.length;
        int[] ans = new int[q];
        HashMap<Integer,Integer> colorsToBalls = new HashMap<>();
        HashMap<Integer,Integer> ballCol = new HashMap<>();
        int idx = 0;
        for(int[] qu : queries)
        {
            int ball = qu[0];
            int col = qu[1];
            if(!colorsToBalls.containsKey(col))
            {
                colorsToBalls.put(col, 0);
            }
            if(ballCol.getOrDefault(ball, 0) == 0)
            {
                ans[idx] = colorsToBalls.size();
                idx++;
                ballCol.put(ball, col);
                colorsToBalls.put(col, colorsToBalls.get(col)+1);
                continue;
            }
            else if(ballCol.get(ball) == col)
            {
                ans[idx] = ans[idx-1];
                idx++;
                continue;
            }
            colorsToBalls.put(col, colorsToBalls.get(col)+1);
            colorsToBalls.put(ballCol.get(ball), colorsToBalls.get(ballCol.get(ball)) - 1);
            if(colorsToBalls.get(ballCol.get(ball)) == 0)
            {
                colorsToBalls.remove(ballCol.get(ball));
            }
            ballCol.put(ball, col);
            ans[idx] = colorsToBalls.size();
            idx++;
        }
        return ans;
    }
}