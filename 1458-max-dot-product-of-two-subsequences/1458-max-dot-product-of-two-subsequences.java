class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][][] cache = new int[n1][n2][2];
        for(int[][] outer : cache)
        {
            for(int[] row : outer)
            {
                Arrays.fill(row, -1);
            }
        }
        return getAns(0, 0, 0, nums1, nums2, cache);
    }
    private int getAns(int current1, int current2, int multiplications, int[] nums1, int[] nums2, int[][][] cache)
    {
        if(current1 == nums1.length || current2 == nums2.length)
        {
            return multiplications == 1 ? 0 : -1000001;
        }
        if(cache[current1][current2][multiplications] != -1)
        {
            return cache[current1][current2][multiplications];
        }
        return cache[current1][current2][multiplications] = Math.max(nums1[current1]*nums2[current2] + getAns(current1+1, current2+1, 1, nums1, nums2, cache),
        Math.max(getAns(current1, current2+1, multiplications, nums1, nums2, cache), getAns(current1+1, current2, multiplications, nums1, nums2, cache)));
    }
}