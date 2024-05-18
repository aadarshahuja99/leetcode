class Solution {
    public int numberOfGoodPartitions(int[] nums) {
        int mod = 1000000007;
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();
        int idx = 0;
        for(int num : nums)
        {
            if(!first.containsKey(num))
            {
                first.put(num, idx);
                last.put(num, idx);
            }
            else
            {
                last.replace(num, idx);
            }
            idx++;
        }
        List<int[]> intervals = new ArrayList<int[]>();
        for(var entry : first.entrySet())
        {
            int[] current = new int[2];
            int key = entry.getKey();
            current[0] = entry.getValue();
            current[1] = last.get(key);
            intervals.add(current);
        }
        Collections.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                return a[0] - b[0];
            }
        });
        int partitions = 0;
        int i=0;
        int n = intervals.size();
        while(i < n)
        {
            int currentStart = intervals.get(i)[0];
            int currentEnd = intervals.get(i)[1];
            int j = i;
            while(j < n && intervals.get(j)[0] <= currentEnd)
            {
                currentEnd = Math.max(currentEnd, intervals.get(j)[1]);
                j++;
            }
            partitions++;
            i = j;
        }
        int ans = 1;
        for(int it=0; it<partitions-1; it++)
        {
            ans = (int)(((long)((2%mod)*(ans%mod)))%mod);
        }
        return ans;
    }
}