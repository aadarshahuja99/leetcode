class Solution {
    public long minimumDifference(int[] nums) {
        // pq based, greedy approach
        // VVI. Minimize the sum of numbers in the 1st half and maximize it in second half
        // build a pref array which will have min sums till index n-1 to index 2n-1 (both incl)
        // build a suf array which will have max sums from index n to index 2n (both incl)
        // find the pre[pref_arr_index], suf[pref_arr_index+1] pair with the max difference in one loop
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            return b - a;
        });
        int n = nums.length/3;
        long[] pre = new long[n+1];
        long sum = 0l;
        for(int i=0; i<=n-1; i++)
        {
            sum += nums[i];
            pq.add(nums[i]);
        }
        pre[0] = sum;
        for(int i=n; i<=2*n-1; i++)
        {
            sum += nums[i];
            pq.add(nums[i]);
            sum -= pq.poll();
            pre[i-(n-1)] = sum;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> {
            return a - b;
        });
        long[] suf = new long[n+1];
        sum = 0l;
        for(int i=2*n; i<=3*n-1; i++)
        {
            sum += nums[i];
            minHeap.add(nums[i]);
        }
        suf[n] = sum;
        for(int i=2*n-1; i>=n; i--)
        {
            sum += nums[i];
            minHeap.add(nums[i]);
            sum -= minHeap.poll();
            suf[i-n] = sum;
        }
        long min = Long.MAX_VALUE;
        for(int i=0; i<n+1; i++)
        {
            // System.out.println(pre[i]+", "+suf[i]);
            long current = pre[i] - suf[i];
            min = Math.min(min, current);
        }
        return min;
    }
}