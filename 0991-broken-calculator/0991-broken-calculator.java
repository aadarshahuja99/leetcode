class Solution {
    public int brokenCalc(int startValue, int target) {
        if(startValue > target)
        {
            return startValue - target;
        }
        if(startValue == target)
        {
            return 0;
        }
        int count = 0;
        while(target > startValue)
        {
            if(target%2 == 0)
            {
                target /= 2;
                count++;
            }
            else
            {
                target += 1;
                count++;
            }
        }
        return count + (startValue - target);
    }

    // public int getAns(int current, int target, HashMap<Integer,Integer> dp) {
    //     // System.out.println(current+" "+target);
    //     if (current == target) {
    //         return 0;
    //     }
    //     if (current < target) {
    //         return target - current;
    //     }
    //     int div = (current / target);
    //     if (current % target == 0 && ((Math.log(div) / Math.log(2)) % 1) == 0) {
    //         return (int) (Math.log(div) / Math.log(2));
    //     }
    //     if(dp.containsKey(current))
    //     {
    //         return dp.get(current);
    //     }
    //     if (current % 2 == 0) {
    //         int ans = 1 + Math.min(getAns(current + 1, target, dp), getAns(current / 2, target, dp));
    //         dp.put(current,ans);
    //         return ans;
    //     }
    //     int ans = 1 + getAns(current + 1, target, dp);
    //     dp.put(current,ans);
    //     return ans;
    // }
}