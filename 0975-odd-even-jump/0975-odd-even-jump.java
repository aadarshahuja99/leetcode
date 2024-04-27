class Solution {
    public int oddEvenJumps(int[] arr) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int ans = 1;
        int n = arr.length;
        int[] ceilings = new int[n];
        int[] floors = new int[n];
        Arrays.fill(ceilings, -1);
        Arrays.fill(floors, -1);
        map.put(arr[n-1], n-1);
        for(int i=n-2; i >= 0; i--)
        {
            var floor = map.floorEntry(arr[i]);
            var ceiling = map.ceilingEntry(arr[i]);
            if(floor != null)
            {
                floors[i] = floor.getValue();
            }
            if(ceiling != null)
            {
                ceilings[i] = ceiling.getValue();
            }
            map.put(arr[i], i);
        }
        boolean[][] dp = new boolean[arr.length][2];
        dp[n-1][0] = true;
        dp[n-1][1] = true;
        for(int i=n-2; i>=0; i--)
        {
            if(floors[i] != -1)
            {
                dp[i][1] = dp[floors[i]][0];
            }
            if(ceilings[i] != -1)
            {
                dp[i][0] = dp[ceilings[i]][1];
                if(dp[i][0])
                {
                    // System.out.println(i+" "+ceilings[i]);
                    ans++;
                }
            }
        }
        return ans;
    }
}