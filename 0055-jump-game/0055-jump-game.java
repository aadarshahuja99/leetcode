class Solution {
    public boolean canJump(int[] nums) {
        // bfs based solution is the only acceptable one
        int currentLevelStart = 0;
        int currentLevelEnd = 0;
        int n = nums.length;
        while(currentLevelEnd <= n-1)
        {
            int farthestFromCurrentLevel = currentLevelEnd;
            while(currentLevelStart <= currentLevelEnd)
            {
                farthestFromCurrentLevel = Math.max(farthestFromCurrentLevel, currentLevelStart + nums[currentLevelStart]);
                currentLevelStart++;
            }
            currentLevelStart = currentLevelEnd+1;
            currentLevelEnd = farthestFromCurrentLevel;
            if(currentLevelEnd >= n-1)
            {
                return true;
            }
            if(currentLevelStart > currentLevelEnd)
            {
                return false;
            }
        }
        return false;
    }
}