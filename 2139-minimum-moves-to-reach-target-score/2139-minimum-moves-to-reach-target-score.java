class Solution {
    public int minMoves(int target, int maxDoubles) {
        int ans = 0;
        while(target > 1)
        {
            if(target%2 == 1)
            {
                target--;
                ans++;
            }
            else
            {
                if(maxDoubles > 0)
                {
                    target = target/2;
                    ans++;
                    maxDoubles--;
                }
                else
                {
                    return ans + target - 1;
                }
            }
        }
        return ans;
    }
}