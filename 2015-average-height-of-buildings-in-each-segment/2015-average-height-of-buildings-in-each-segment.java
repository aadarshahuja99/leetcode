class Solution {
    public int[][] averageHeightOfBuildings(int[][] buildings) {
        TreeMap<Integer,int[]> map = new TreeMap<>();
        for(int[] building : buildings)
        {
            if(map.containsKey(building[0]))
            {
                int[] existing = map.get(building[0]);
                existing[0] += building[2];
                existing[1] += 1;
                map.put(building[0], existing);
            }
            else
            {
                map.put(building[0], new int[] { building[2], 1 });
            }
            if(map.containsKey(building[1]))
            {
                int[] existing = map.get(building[1]);
                existing[0] -= building[2];
                existing[1] -= 1;
                map.put(building[1], existing);
            }
            else
            {
                map.put(building[1], new int[] { -building[2], -1 });
            }
        }

        int runningSum = 0;
        int runningCount = 0;
        int prev = -1;
        int lastAverage = -1;
        ArrayList<int[]> intermediate = new ArrayList<>();
        for(int key : map.keySet())
        {
            int[] current = map.get(key);
            runningSum += current[0];
            runningCount += current[1];
            int currentAverage = -1;
            if(runningCount > 0)
            {
                currentAverage = runningSum/runningCount;
            }
            // System.out.println(currentAverage+" "+lastAverage+" "+key+" "+runningSum+" "+runningCount);
            if(currentAverage == lastAverage)
            {
                continue;
            }
            if(lastAverage >= 0)
            {
                intermediate.add(new int[] { prev, key, lastAverage });
            }
            prev = key;
            lastAverage = currentAverage;
        }
        int size = intermediate.size();
        int[][] ans = new int[size][3];
        int idx = 0;
        for(int[] list : intermediate)
        {
            ans[idx] = list;
            idx++;
        }
        return ans;
    }
}