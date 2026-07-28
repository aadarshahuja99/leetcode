import java.util.*;
import java.util.Map.Entry;
class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        TreeMap<Integer, Long> map = new TreeMap<>();
        for(int segment[]: segments) {
            map.put(segment[0], map.getOrDefault(segment[0], 0L) + segment[2]);
            map.put(segment[1], map.getOrDefault(segment[1], 0L) - segment[2]);
        }
        List<List<Long>> result = new ArrayList<>();
        int prev = 0;
        long sum = 0;
        // every single segment point (either start or end will be making its own contribution to the colour running "sum", so we only focus on the starts and ends of segments to compute answer based on running sum till the current start or end point)
        for(int key: map.keySet()) {
            if(sum != 0) { // Ignore the unpainted interval
                result.add(Arrays.asList(1l*prev, 1l*key, sum)); // Add the interval
            }
            sum += map.get(key);
            prev = key;
        }
        return result;
    }
}