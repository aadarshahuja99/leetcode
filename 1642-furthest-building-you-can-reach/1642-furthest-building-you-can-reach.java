class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // intuition: use bricks for smaller jumps and ladders for larger ones
        // using min-heap of size (L): assign the first k jumps a ladder and push these jumps on the pq.
        // Now, when the next jump comes in, check if it is > the peek of the queue, if yes, push the next jump on the queue and remove the peek of the queue which is smaller than the next jump
        // The above approach uses O(L) extra space.
        // Optimization: Binary Search
        int n = heights.length;
        int[][] list = new int[n-1][2];
        for(int i=0; i<n-1; i++)
        {
            int jump = Math.max(0, heights[i+1] - heights[i]);
            list[i][0] = jump;
            list[i][1] = i+1;
        }
        Arrays.sort(list, (a,b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        // for(int[] a : list)
        // {
        //     System.out.println(a[0]+","+a[1]);
        // }
        int start = 0;
        int end = n-1;
        int ans = 0;
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(check(mid, list, bricks, ladders))
            {
                ans = mid;
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        return ans;
    }
    private boolean check(int guess, int[][] list, int b, int l)
    {
        for(int i=0; i<list.length; i++)
        {
            if(list[i][1] > guess)
            {
                continue;
            }
            int current = list[i][0];
            if(b >= current)
            {
                // System.out.println("can jump using " + current + " bricks to "+list[i][1]);
                b -= current;
            }
            else if(l >= 1)
            {
                // System.out.println("can jump using ladder to "+list[i][0]);
                l--;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}