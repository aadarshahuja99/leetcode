class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] count = new int[spells.length];
        int idx = 0;
        for(int spell : spells)
        {
            int required = (int)Math.ceil((double)success/spell);
            int start = 0;
            int end = potions.length-1;
            int ceil = -1;
            while(start <= end)
            {
                int mid = start + (end-start)/2;
                if(potions[mid] >= required)
                {
                    ceil = mid;
                    end = mid-1;
                }
                else
                {
                    start = mid+1;
                }
            }
            if(ceil == -1)
            {
                count[idx] = 0;
            }
            else
            {
                count[idx] = potions.length - ceil;
            }
            idx++;
        }
        return count;
    }
}