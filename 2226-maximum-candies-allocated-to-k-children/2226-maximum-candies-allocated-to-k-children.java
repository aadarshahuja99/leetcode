class Solution {
    public int maximumCandies(int[] candies, long k) {
        // if(k <= candies.length)
        // {
        //     PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
        //         public int compare(Integer i1, Integer i2)
        //         {
        //             return i1-i2;
        //         }
        //     });
        //     for(int idx = 0; idx < candies.length; idx++)
        //     {
        //         pq.add(candies[idx]);
        //         if(pq.size() > k)
        //         {
        //             pq.poll();
        //         }
        //     }
        //     return pq.peek();
        // }
        int max = candies[0];
        long sum = candies[0];
        for(int i=1;i<candies.length;i++)
        {
            sum += candies[i];
            if(candies[i] > max)
            {
                max = candies[i];
            }
        }
        // System.out.println(max + " " + sum);
        if(sum < k)
        {
            return 0;
        }
        if(sum == k)
        {
            return 1;
        }
        int start = 1;
        int end = max;
        int ans = 0;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            // System.out.println("checking for mid = "+mid);
            if(check(candies,mid,k))
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
    private boolean check(int[] candies, int current, long k)
    {
        long numberOfChildrenCovered = 0;
        for(int i=0; i<candies.length; i++)
        {
            numberOfChildrenCovered += (long)candies[i]/(long)current;
            if(numberOfChildrenCovered >= k)
            {
                return true;
            }
        }
        return false;
    }
}