class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int start = 0;
        int end = 0;
        int n = nums.length;
        int currentProduct = 1;
        while(end < n)
        {
            currentProduct = currentProduct*nums[end];
            end++;
            if(currentProduct < k)
            {
                count += (end - start);
                // System.out.println("added "+(end-start)+" to count "+end+","+start+","+currentProduct);
            }
            else
            {
                while(start < end && currentProduct >= k)
                {
                    currentProduct = currentProduct/nums[start];
                    start++;
                }
                count += (end - start);
            }
        }
        return count;
    }
}