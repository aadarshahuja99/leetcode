class Solution {
    public int addRungs(int[] rungs, int dist) {
        int current = rungs[rungs.length-1];
        int ans = 0;
        int idx = rungs.length-2;
        while(idx >= 0)
        {
            if(current - rungs[idx] > dist)
            {
                if((current-rungs[idx])%dist == 0)
                {
                    ans += ((current-rungs[idx])/dist)-1;
                }
                else
                {
                    ans += (current-rungs[idx])/dist;
                }
                // System.out.println("ans: "+ans+" after current: "+current);
            }
            current = rungs[idx];
            idx--;
        }
        current = rungs[0];
        if(current > dist)
        {
            if((current%dist)==0)
            {
                return ans + ((current/dist)-1);
            }
            return ans + (current/dist);
        }
        return ans;
    }
    private int search(int start, int end, int key, int[] arr)
    {
        int ans = -1;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(arr[mid] == key)
            {
                return mid;
            }
            else if(arr[mid] > key)
            {
                end = mid-1;
                ans = mid;
            }
            else
            {
                start = mid+1;
            }
        }
        return ans;
    }
}