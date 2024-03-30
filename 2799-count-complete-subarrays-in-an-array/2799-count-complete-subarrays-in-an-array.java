class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> visited = new HashSet<Integer>();
        for(int num : nums)
        {
            visited.add(num);
        }
        int k = visited.size();
        int i=0;
        int j=0;
        HashMap<Integer,Integer> count = new HashMap<Integer,Integer>();
        int n= nums.length;
        int ans = 0;
        while(j<n)
        {
            if(count.size() < k)
            {
                count.put(nums[j], count.getOrDefault(nums[j],0) + 1);
                j++;
            }
            else if(count.size() == k)
            {
                int candidateLength = j-i;
                int rightRem = n-candidateLength-i;
                while(count.size() == k)
                {
                    ans = ans + rightRem + 1;
                    count.put(nums[i], count.get(nums[i]) - 1);
                    if(count.get(nums[i]) == 0)
                    {
                        count.remove(nums[i]);
                    }
                    i++;
                }
            }
        }
        if(count.size() == k)
        {
            int candidateLength = j-i;
            int rightRem = n-candidateLength-i;
            while(count.size() == k)
            {
                ans = ans + rightRem + 1;
                count.put(nums[i], count.get(nums[i]) - 1);
                if(count.get(nums[i]) == 0)
                {
                    count.remove(nums[i]);
                }
                i++;
            }
        }
        return ans;
    }
}