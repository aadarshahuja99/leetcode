class Solution {
    public boolean canJump(int[] nums) {
        // bfs based solution is the only acceptable one
        int currentLevelStart = 0;
        int currentLevelEnd = 0;
        int n = nums.length;
        while(currentLevelEnd < n-1)
        {
            int farthestFromCurrentLevel = currentLevelEnd;
            int it = currentLevelStart;
            while(it <= currentLevelEnd)
            {
                farthestFromCurrentLevel = Math.max(farthestFromCurrentLevel, it + nums[it]);
                it++;
            }
            currentLevelStart = currentLevelEnd+1;
            currentLevelEnd = farthestFromCurrentLevel;
            if(currentLevelStart > currentLevelEnd)
            {
                return false;
            }
        }
        return true;
    }
}