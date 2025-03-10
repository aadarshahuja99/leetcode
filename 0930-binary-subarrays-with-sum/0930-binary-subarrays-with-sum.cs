public class Solution {
    public int NumSubarraysWithSum(int[] nums, int goal) {
        if(nums.Length == 1 && goal==nums[0])
        {
            return 1;
        }
        else if(nums.Length == 1 && goal != nums[0])
        {
            return 0;
        }
        if(goal==0)
        {
            int start=0;
            int end=0;
            int res=0;
            while(end<nums.Length)
            {
                while(start<nums.Length && nums[start] != 0)
                {
                    start++;
                }
                end=start;
                while(end < nums.Length && nums[end] == 0)
                {
                    end++;
                }
                res+=(end-start)*(end-start+1)/2;
                start=end;
            }
            return res;
        }
        int i=0;
        int j=0;
        int sum=0;
        int count=0;
        while(j<nums.Length)
        {
            sum+=nums[j];
            if(sum < goal)
            {
                j++;
            }
            else if(sum == goal)
            {
                int leadingZeros=0;
                while(nums[i] != 1)
                {
                    i++;
                    leadingZeros++;
                }
                count += 1+leadingZeros;
                int next = j+1;
                int trailingZeros=0;
                while(next < nums.Length && nums[next]==0)
                {
                    next++;
                    trailingZeros++;
                    count+=leadingZeros+1;
                }
                j=next;
            }
            else
            {
                while(nums[i] == 0)
                {
                    i++;
                }
                sum--;
                i++;
                int leadingZeros=0;
                while(nums[i] != 1)
                {
                    i++;
                    leadingZeros++;
                }
                count += 1+leadingZeros;
                int next = j+1;
                int trailingZeros=0;
                while(next < nums.Length && nums[next]==0)
                {
                    next++;
                    trailingZeros++;
                    count+=leadingZeros+1;
                }
                j=next;
            }
        }
        return count;
    }
}