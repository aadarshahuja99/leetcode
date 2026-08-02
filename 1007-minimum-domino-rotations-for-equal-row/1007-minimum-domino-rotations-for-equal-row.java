class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int ans = n+1;
        for(int number=1; number<=6; number++)
        {
            boolean status = true;
            int countTops = 0;
            int countBottoms = 0;
            for(int i=0; i<n; i++)
            {
                if(tops[i] != number && bottoms[i] != number)
                {
                    status = false;
                    break;
                }
                else if(tops[i] == bottoms[i])
                {
                    continue;
                }
                else if(tops[i] == number)
                {
                    countTops++;
                }
                else
                {
                    countBottoms++;
                }
            }
            if(status)
            {
                ans = Math.min(ans, Math.min(countTops, countBottoms));
            }
        }
        return ans == n+1 ? -1 : ans;
    }
}