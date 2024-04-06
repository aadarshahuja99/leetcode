class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        for(String num : nums)
        {
            set.add(num);
        }
        return getAns(0,"",set);
    }
    private String getAns(int currentIndex, String currentString, HashSet<String> nums)
    {
        if(currentIndex == nums.size())
        {
            if(!nums.contains(currentString))
            {
                return currentString;
            }
            return "";
        }
        String addZero = getAns(currentIndex+1, currentString + "0", nums);
        if(!"".equals(addZero))
        {
            return addZero;
        }
        return getAns(currentIndex+1, currentString + "1", nums);
    }
}