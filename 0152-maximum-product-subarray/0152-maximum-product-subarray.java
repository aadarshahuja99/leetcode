class Solution {
    public int maxProduct(int[] nums) {
        int prefixProd = 1;
        int suffixProd = 1;
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        // intuition:
        // 1. Ans will always be a subarray from start or subarray from end because of these 3 cases:
        // a. If all positive, ans = prod of the complete array
        // b. If even negative, ans = prod of the complete array
        // c. If odd negative, ans = prod of the subarray from either start or either end excluding one of the negative numbers
        // If zeroes are present, then we solve individually for each of the non-zero including segments, this is achieved by setting prefixProd, suffixProd to 1 (if they ever become zero) 
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