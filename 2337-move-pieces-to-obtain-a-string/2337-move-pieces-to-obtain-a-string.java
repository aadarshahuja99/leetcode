class Solution {
    public boolean canChange(String start, String target) {
        // 2 pointers. Intuition:
        // 1. L can only move to the left. R can only move to the Right
        // 2. Every L in source should come after or at the same position as the last L in target (so that we can move the source L to the left)
        // 3. Evert R in source should come before or at the same position as the last R in target (so that we can move the source L to the left)
        // 4. L and R can not cross eachother
        int sourcePointer = 0;
        int targetPointer = 0;
        int n = start.length();
        while(sourcePointer < n && targetPointer < n)
        {
            if(start.charAt(sourcePointer) == '_')
            {
                sourcePointer++;
                continue;
            }
            if(target.charAt(targetPointer) == '_')
            {
                targetPointer++;
                continue;
            }
            if(start.charAt(sourcePointer) != target.charAt(targetPointer))
            {
                return false;
            }
            if(start.charAt(sourcePointer) == 'L' && sourcePointer < targetPointer)
            {
                return false;
            }
            if(start.charAt(sourcePointer) == 'R' && sourcePointer > targetPointer)
            {
                return false;
            }
            sourcePointer++;
            targetPointer++;
        }
        while(sourcePointer < n && start.charAt(sourcePointer) == '_')
        {
            sourcePointer++;
        }
        while(targetPointer < n && target.charAt(targetPointer) == '_')
        {
            targetPointer++;
        }
        return sourcePointer == n && targetPointer == n;
    }
}