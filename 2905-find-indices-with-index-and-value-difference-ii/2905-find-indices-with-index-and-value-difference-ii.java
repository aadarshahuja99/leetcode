class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        if(indexDifference == 0 && valueDifference == 0)
        {
            return new int[] { 0, 0 };
        }
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for(int i=indexDifference; i < nums.length; i++)
        {
            if(!map.containsKey(nums[i-indexDifference]))
            {
                map.put(nums[i-indexDifference], i-indexDifference);
            }
            Map.Entry<Integer,Integer> floor = map.floorEntry(nums[i]-valueDifference);
            if(floor != null)
            {
                return new int[] { floor.getValue(), i };
            }
            Map.Entry<Integer,Integer> ceiling = map.ceilingEntry(nums[i]+valueDifference);
            if(ceiling != null)
            {
                return new int[] { ceiling.getValue(), i };
            }
        }
        return new int[] { -1, -1 };
    }
}