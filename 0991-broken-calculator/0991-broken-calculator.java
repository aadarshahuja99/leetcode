class Solution {
    public int brokenCalc(int startValue, int target) {
        // work backwards: if target is greater than start:
        // if it is even, then we can divide by 2
        // else we will need to make it even by adding 1 to it
        // once it is <= start, we will need to return start-target + ops as (start-target) increments will be needed to target
        int ans = 0;
        while(target > startValue)
        {
            if(target%2 == 0)
            {
                target = target/2;
            }
            else
            {
                target++;
            }
            ans++;
        }
        return ans + (startValue - target);
    }
}