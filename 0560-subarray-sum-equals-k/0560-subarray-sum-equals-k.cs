public class Solution {
    public int SubarraySum(int[] nums, int k) {
        if(nums.Length == 1)
        {
            return nums[0]==k ? 1 : 0;
        }
        int[] pre = new int[nums.Length];
        Dictionary<int, int> sumMap = new();
        pre[0]=nums[0];
        sumMap.Add(pre[0],1);
        int ans=0;
        if(pre[0]==k)
        {
            ans++;
        }
        for(int i=1;i<nums.Length;i++)
        {
            pre[i]=nums[i]+pre[i-1];
            // Console.WriteLine($"pre[{i}]: {pre[i]}");
            if(pre[i] == k)
            {
                ans++;
            }
            if(sumMap.ContainsKey(pre[i]-k))
            {
                // Console.WriteLine($"in 1 {sumMap[pre[i]-k]}");
                ans+=sumMap[pre[i]-k];
            }
            if(!sumMap.ContainsKey(pre[i]))
            {
                sumMap.Add(pre[i],1);
            }
            else
            {
                sumMap[pre[i]]++;
            }
        }
        return ans;
    }
}