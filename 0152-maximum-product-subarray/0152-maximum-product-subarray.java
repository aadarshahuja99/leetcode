class Solution {
    public int maxProduct(int[] nums) {
        int prefixProd = 1;
        int suffixProd = 1;
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
        {
            prefixProd = nums[i]*prefixProd;
            suffixProd = nums[n-i-1]*suffixProd;
            ans = Math.max(ans, Math.max(prefixProd, suffixProd));
            if(prefixProd == 0)
            {
                prefixProd = 1;
            }
            if(suffixProd == 0)
            {
                suffixProd = 1;
            }
        }
        return ans;
    }
}