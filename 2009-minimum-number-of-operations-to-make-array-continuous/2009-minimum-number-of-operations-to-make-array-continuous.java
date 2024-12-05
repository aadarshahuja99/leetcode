class Solution {
    public int minOperations(int[] nums) {
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums)
        {
            set.add(num);
        }
        for(int num : set)
        {
            list.add(num);
        }
        Collections.sort(list);
        int len = nums.length;
        int idx = 0;
        for(int num : list)
        {
            if(idx == len-1)
            {
                continue;
            }
            int end = num + len - 1;
            int floorIdx = getFloorIdx(list, end);
            int segmentLength = floorIdx - idx + 1;
            int changesNeeded = len - segmentLength;
            // System.out.println(num+","+end+" changes needed: "+changesNeeded);
            min = Math.min(min, changesNeeded);
            idx++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    private int getFloorIdx(List<Integer> nums, int t)
    {
        int s = 0;
        int e = nums.size()-1;
        int ans = -1;
        while(s <= e)
        {
            int mid = s + (e - s)/2;
            if(nums.get(mid) <= t)
            {
                ans = mid;
                s = mid+1;
            }
            else
            {
                e = mid-1;
            }
        }
        return ans;
    }
}