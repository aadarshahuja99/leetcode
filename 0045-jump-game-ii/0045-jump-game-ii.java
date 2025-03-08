class Solution {
    public int jump(int[] nums) {
        // bfs based solution is the only acceptable one
        int currentLevelStart = 0;
        int currentLevelEnd = 0;
        int n = nums.length;
        int steps = 0;
        while(currentLevelEnd < n-1)
        {
            steps++;
            int farthestFromCurrentLevel = currentLevelEnd;
            int it = currentLevelStart;
            while(it <= currentLevelEnd)
            {
                farthestFromCurrentLevel = Math.max(farthestFromCurrentLevel, it + nums[it]);
                it++;
            }
            currentLevelStart = currentLevelEnd+1;
            currentLevelEnd = farthestFromCurrentLevel;
        }
        return steps;
    }
}