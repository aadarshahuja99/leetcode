public class Solution {
    public int SubarraysDivByK(int[] nums, int k) {
        int sum = nums[0];
        int ans = 0;
        Dictionary<int,int> remainderMap = new();
        if(sum%k == 0)
        {
            ans++;
        }
        remainderMap.Add(mod(sum,k),1);
        // Console.WriteLine($"{mod(sum,k)}");
        for(int i=1; i<nums.Length; i++)
        {
            sum+=nums[i];
            // Console.WriteLine($"{mod(sum,k)} rem for {nums[i]}");
            if(mod(sum,k) == 0)
            {
                ans++;
            }
            if(remainderMap.ContainsKey(mod(sum,k)))
            {
                ans+=remainderMap[mod(sum,k)];
                remainderMap[mod(sum,k)]++;
            }
            else
            {
                remainderMap.Add(mod(sum,k),1);
            }
        }
        return ans;
    }
    private int mod(int x, int m)
    {
        return (x%m + m)%m;
    }
}