public class Solution {
    public int FindMaxLength(int[] nums) {
        if(nums.Length == 1)
        {
            return 0;
        }
        int max = 0;
        int sum = 0;
        Dictionary<int,int> map=new();
        for(int i=0;i<nums.Length;i++)
        {
            if(nums[i]==0)
            {
                sum--;
            }
            else
            {
                sum++;
            }
            if(!map.ContainsKey(sum) && sum != 0)
            {
                 map.Add(sum,i);
            }
            else if(map.ContainsKey(sum))
            {
                max = Math.Max(max,i-map[sum]);
            }
            else if(sum==0)
            {
                max = Math.Max(max,i+1);
            }
        }
        return max;
    }
}