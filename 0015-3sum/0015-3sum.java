class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int n = nums.length;
        return kSumHelper(0, n-1, 0, 3, clone);
        // ArrayList<List<Integer>> ans = new ArrayList<>();
        // for(int i=0; i<n;)
        // {
        //     int j=i+1;
        //     int k=n-1;
        //     int target = clone[i];
        //     while(j < k)
        //     {
        //         if(clone[j] + clone[k] + target == 0)
        //         {
        //             //valid candidate found
        //             var list = new ArrayList<Integer>();
        //             list.add(clone[i]);
        //             list.add(clone[j]);
        //             list.add(clone[k]);
        //             ans.add(list);
        //             // look for a value other than clone[k]
        //             int temp = k-1;
        //             while(temp >= 0 && clone[temp] == clone[k])
        //             {
        //                 temp--;
        //             }
        //             k = temp;
        //             // look for a value other than clone[j]
        //             temp = j+1;
        //             while(temp < n && clone[temp] == clone[j])
        //             {
        //                 temp++;
        //             }
        //             j = temp;
        //         }
        //         else if(clone[j] + clone[k] + target < 0)
        //         {
        //             // move to the next value that is greater than clone[j] as there can be duplicates with the same value as clone[j]
        //             int temp = j+1;
        //             while(temp < n && clone[temp] == clone[j])
        //             {
        //                 temp++;
        //             }
        //             j = temp;
        //         }
        //         else
        //         {
        //             // move to the next value that is lesser than clone[k] as there can be duplicates with the same value as clone[k]
        //             int temp = k-1;
        //             while(temp >= 0 && clone[temp] == clone[k])
        //             {
        //                 temp--;
        //             }
        //             k = temp;
        //         }
        //     }
        //     // once all the valid combinations are found for the current value of clone[i], skip all other elements with the same value to avoid duplicate processing
        //     int t = i+1;
        //     while(t < n && clone[t] == clone[i])
        //     {
        //         t++;
        //     }
        //     i = t;
        // }
        // return ans;
    }
    private List<List<Integer>> kSumHelper(int start, int end, int target, int k, int[] nums)
    {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(start == end)
        {
            return ans;
        }
        if(k == 2)
        {
            return twoSumHelper(start, end, target, nums);
        }
        int n = nums.length;
        for(int i=0; i<n; i++)
        {
            if(i > start && nums[i] == nums[i-1])
            {
                continue;
            }
            var subsets = kSumHelper(i+1, end, target - nums[i], k-1, nums);
            System.out.println(subsets.size()+" for i = "+i+" nums[i] = "+nums[i]);
            // add current element to all valid subsets that meet the criteria
            for(var subset : subsets)
            {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.addAll(subset);
                ans.add(list);
            }
        }
        return ans;
    }
    private List<List<Integer>> twoSumHelper(int start, int end, int target, int[] nums)
    {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        int j=start;
        int k=end;
        while(j < k)
        {
            int current = nums[j]+nums[k];
            if(current == target)
            {
                // we have a candidate
                ans.add(Arrays.asList(nums[j], nums[k]));
                j++;
                while(j < k && nums[j] == nums[j-1])
                {
                    j++;
                }
                k--;
                while(j < k && nums[k] == nums[k+1])
                {
                    k--;
                }
            }
            else if(current < target)
            {
                j++;
            }
            else
            {
                k--;
            }
        }
        return ans;
    }
}