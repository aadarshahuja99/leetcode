class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int mindiff = Integer.MAX_VALUE;
        int n = nums1.length;
        for(int i=0; i<n; i++)
        {
            min = Math.min(nums1[i] - nums2[i] + diff, min);
            max = Math.max(nums1[i] - nums2[i] + diff, max);
            mindiff = Math.min(mindiff, nums1[i] - nums2[i]);
        }
        int start = Math.min(min, mindiff);
        BIT bit = new BIT(max + Math.abs(start) + 1);
        long ans = 0l;
        for(int i=0; i<n; i++)
        {
            int val = nums1[i] - nums2[i] + diff;
            int countLower = bit.getSum(val + Math.abs(start));
            ans += countLower;
            bit.add(nums1[i] - nums2[i] + Math.abs(start));
        }
        return ans;
    }
    class BIT
    {
        int size;
        int[] arr;
        public BIT(int n)
        {
            size = n+2;
            arr = new int[n+2];
        }
        public int getSum(int idx)
        {
            int val = idx+1;
            int sum = 0;
            while(val > 0)
            {
                sum += arr[val];
                val = val - (val&(-val));
            }
            return sum;
        }
        public void add(int idx)
        {
            int val = idx+1;
            // System.out.println("adding 1 from "+idx);
            while(val < size)
            {
                arr[val] += 1;
                val = val +(val&(-val));
            }
        }
    }
}