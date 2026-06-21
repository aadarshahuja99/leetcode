class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int[] cloned = costs.clone();
        int ans = 0;
        int idx = 0;
        int n = cloned.length;
        Arrays.sort(cloned);
        while(idx < n)
        {
            if(coins < cloned[idx])
            {
                return ans;
            }
            ans++;
            coins -= cloned[idx];
            idx++;
        }
        return ans;
    }
}