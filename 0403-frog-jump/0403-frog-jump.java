class Solution {
    public boolean canCross(int[] stones) {
        if(stones[1] != 1)
        {
            return false;
        }
        Boolean[][] cache = new Boolean[stones.length][stones.length];
        return check(1, 1, stones, cache);
    }
    private boolean check(int current, int lastJump, int[] stones, Boolean[][] cache)
    {
        if(current == stones.length-1)
        {
            return true;
        }
        if(cache[current][lastJump] != null)
        {
            return cache[current][lastJump];
        }
        boolean kJump = false;
        boolean kPlusJump = false;
        boolean kMinusJump = false;
        int pos = stones[current];
        int kth = find(pos + lastJump, stones);
        int next = find(pos + lastJump + 1, stones);
        int prev = find(pos + lastJump - 1, stones);
        if(kth != -1)
        {
            kJump = check(kth, lastJump, stones, cache);
        }
        if(next != -1)
        {
            kPlusJump = check(next, lastJump+1, stones, cache);
        }
        if(lastJump > 1 && prev != -1)
        {
            kMinusJump = check(prev, lastJump-1, stones, cache);
        }
        return cache[current][lastJump] = kJump || kPlusJump || kMinusJump;
    }

    private int find(int target, int[] stones)
    {
        int start = 0;
        int end = stones.length-1;
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(stones[mid] == target)
            {
                return mid;
            }
            else if(stones[mid] < target)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return -1;
    }
}