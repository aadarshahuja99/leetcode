class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        BIT bit = new BIT(nums.length);
        for(int i=1; i<nums.length-1; i++)
        {
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1])
            {
                bit.update(1, i+1);
            }
        }
        for(int[] q : queries)
        {
            if(q[0] == 1)
            {
                if(q[2] - q[1] <= 1)
                {
                    list.add(0);
                    continue;
                }
                if(q[2] > nums.length-1)
                {
                    q[2] = nums.length-1;
                }
                int ans = bit.get(q[2]) - bit.get(q[1]+1);
                list.add(ans);
            }
            else
            {
                int idx = q[1];
                if(idx == 0)
                {
                    if(nums[1] > nums[2] && nums[1] > nums[0] && q[2] >= nums[1])
                    {
                        // System.out.println("removing 1 from "+(1));
                        bit.update(-1, 2);
                    }
                    else if(nums[1] > nums[2] && nums[1] <= nums[0] && q[2] < nums[1])
                    {
                        // System.out.println("adding 1 to "+(1));
                        bit.update(1, 2);
                    }
                    nums[idx] = q[2];
                }
                else if(idx == nums.length-1)
                {
                    if(nums[nums.length-1] < nums[nums.length-2] && nums[nums.length-2] > nums[nums.length-3] && q[2] >= nums[nums.length-2])
                    {
                        // System.out.println("adding 1 to "+(idx-1));
                        bit.update(-1, nums.length-1);
                    }
                    else if(nums[nums.length-1] >= nums[nums.length-2] && nums[nums.length-2] > nums[nums.length-3] && q[2] < nums[nums.length-2])
                    {
                        // System.out.println("removing 1 from "+(idx-1));
                        bit.update(1, nums.length-1);
                    }
                    nums[idx] = q[2];
                }
                else
                {
                    if(nums[idx] > nums[idx-1] && nums[idx] > nums[idx+1] && (q[2] <= nums[idx+1] || q[2] <= nums[idx-1]))
                    {
                        // idx was the peak
                        nums[idx] = q[2];
                        // System.out.println("removing 1 from "+idx+" old peak ");
                        bit.update(-1, idx+1);
                        if(idx > 1 && nums[idx-1] > nums[idx-2] && nums[idx-1] > nums[idx])
                        {
                            // System.out.println("adding 1 to "+(idx-1));
                            bit.update(1, idx);
                        }
                        if(idx < nums.length-2 && nums[idx+1] > nums[idx+2] && nums[idx+1] > nums[idx])
                        {
                            // System.out.println("adding 1 to "+(idx+1));
                            bit.update(1, idx+2);
                        }
                    }
                    else if(nums[idx] > nums[idx-1] && nums[idx] > nums[idx+1])
                    {
                        // idx continues to be the peak
                        nums[idx] = q[2];
                        // no updates needed
                    }
                    else
                    {
                        // System.out.println(nums[idx]+" was not the peak");
                        // idx was not the peak
                        int prev = nums[idx];
                        nums[idx] = q[2];
                        if(nums[idx] > nums[idx-1] && nums[idx] > nums[idx+1])
                        {
                            // System.out.println("adding 1 to "+(idx)+" new peak ");
                            bit.update(1, idx+1);
                        }
                        if(idx > 1 && nums[idx-1] > prev && nums[idx-1] > nums[idx-2] && nums[idx-1] <= nums[idx])
                        {
                            // System.out.println("removing 1 from "+(idx-1));
                            bit.update(-1, idx);
                        }
                        if(idx < nums.length-2 && nums[idx+1] > nums[idx+2] && nums[idx+1] > prev && nums[idx+1] <= nums[idx])
                        {
                            // System.out.println("removing 1 from "+(idx+1));
                            bit.update(-1, idx+2);
                        }
                        if(idx > 1 && nums[idx-1] > nums[idx-2] && nums[idx-1] <= prev && nums[idx-1] > nums[idx])
                        {
                            // System.out.println("adding 1 to "+(idx-1));
                            bit.update(1, idx);
                        }
                        if(idx < nums.length-2 && nums[idx+1] > nums[idx+2] && nums[idx+1] <= prev && nums[idx+1] > nums[idx])
                        {
                            // System.out.println("adding 1 to "+(idx+1));
                            bit.update(1, idx+2);
                        }
                    }
                }
            }
        }
        return list;
    }
    class BIT
    {
        int[] tree;
        public BIT(int n)
        {
            tree = new int[n+1];
        }
        public int get(int idx)
        {
            int s = 0;
            while(idx > 0)
            {
                s += tree[idx];
                idx -= (idx&(-idx));
            }
            return s;
        }
        public void update(int diff, int idx)
        {
            while(idx < tree.length)
            {
                tree[idx] += diff;
                idx += (idx&(-idx));
            }
        }
    }
}