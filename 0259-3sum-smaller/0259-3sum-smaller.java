class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int n = nums.length;
        int[] clone = Arrays.copyOf(nums, n);
        Arrays.sort(clone);
        for(int num : clone)
        {
            System.out.println(num);
        }
        int ans = 0;
        for(int i=n-1; i>=2; i--)
        {
            int j=0;
            int k=i-1;
            int t = target - clone[i];
            while(j < k)
            {
                while(j < k && clone[j] + clone[k] < t)
                {
                    ans += k - j;
                    j++;
                }
                k--;
            }
        }
        return ans;
    }
}