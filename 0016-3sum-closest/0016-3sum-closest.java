class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ansDiff = Integer.MAX_VALUE;
        int ans = 0;
        int n = nums.length;
        int[] clone = nums.clone();
        Arrays.sort(clone);
        for(int i=0; i<n;)
        {
            int j=i+1;
            int k=n-1;
            int current = clone[i];
            while(j < k)
            {
                int sum = clone[j] + clone[k] + current;
                if(sum == target)
                {
                    return sum;
                }
                int diff = sum - target;
                if(ansDiff > Math.abs(diff))
                {
                    ansDiff = Math.abs(diff);
                    ans = sum;
                }
                if(diff > 0)
                {
                    // move k to the next unique value
                    int temp = k-1;
                    while(temp > j && clone[temp] == clone[k])
                    {
                        temp--;
                    }
                    k = temp;
                }
                else
                {
                    // move to the next value that is greater than clone[j] as there can be duplicates with the same value as clone[j]
                    int temp = j+1;
                    while(temp < k && clone[temp] == clone[j])
                    {
                        temp++;
                    }
                    j = temp;
                }
            }
            // once all the valid combinations are found for the current value of clone[i], skip all other elements with the same value to avoid duplicate processing
            int t = i+1;
            while(t < n && clone[t] == clone[i])
            {
                t++;
            }
            i = t;
        }
        return ans;
    }
}