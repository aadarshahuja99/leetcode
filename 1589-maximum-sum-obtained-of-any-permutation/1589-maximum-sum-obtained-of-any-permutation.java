class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        Arrays.sort(requests, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        int n = nums.length;
        int it = 0;
        int currentEnd = -1;
        int length = 0;
        while(it < requests.length)
        {
            int j = it+1;
            int start = requests[it][0];
            currentEnd = requests[it][1];
            while(j < requests.length && requests[j][0] <= currentEnd)
            {
                currentEnd = Math.max(currentEnd, requests[j][1]);
                j++;
            }
            it = j;
            length += currentEnd - start + 1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return a - b;
        });
        for(int num : nums)
        {
            pq.add(num);
            if(pq.size() > length)
            {
                pq.poll();
            }
        }
        int[] counts = new int[n+1];
        for(int[] req : requests)
        {
            counts[req[0]]++;
            counts[req[1] + 1]--;
        }
        int total = 0;
        for(int i=1; i<n; i++)
        {
            counts[i] += counts[i-1];
        }
        Arrays.sort(counts);
        long ans = 0l;
        int mod = 1_000_000_007;
        it = n - length + 1;
        while(pq.size() > 0)
        {
            // System.out.println(pq.peek()+" "+counts[it]);
            ans = (ans%mod + (((1l*counts[it])%mod)*((pq.poll()*1l)%mod))%mod)%mod;
            it++;
        }
        return (int)ans;
    }
}