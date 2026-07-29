// APPROACH 1: TreeMap + line sweep on tree map keys, key is either starti or endi + 1 and value is the count
// class Solution {
//     public int[] fullBloomFlowers(int[][] flowers, int[] people) {
//         TreeMap<Integer,Integer> map = new TreeMap<>();
//         for(int[] flower : flowers)
//         {
//             map.put(flower[0], map.getOrDefault(flower[0],0) + 1);
//             map.put(flower[1] + 1, map.getOrDefault(flower[1] + 1,0) - 1);
//         }
//         int total = 0;
//         for(int key : map.keySet())
//         {
//             total += map.get(key);
//             map.put(key, total);
//         }
//         int[] ans = new int[people.length];
//         int idx = 0;
//         for(int person : people)
//         {
//             var floor = map.floorEntry(person);
//             if(floor == null || floor.getValue() == 0)
//             {
//                 ans[idx] = 0;
//                 idx++;
//             }
//             else
//             {
//                 ans[idx] = floor.getValue();
//                 idx++;
//             }
//         }
//         return ans;
//     }
// }


// Approach 2: Count the number of starts <= time_queries_i and number of ends <= time_queries_i using BS
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        List<Integer> starts = new ArrayList();
        List<Integer> ends = new ArrayList();
        
        for (int[] flower: flowers) {
            starts.add(flower[0]);
            ends.add(flower[1] + 1);
        }
        
        Collections.sort(starts);
        Collections.sort(ends);
        int[] ans = new int[people.length];
        
        for (int index = 0; index < people.length; index++) {
            int person = people[index];
            int s = findFloor(starts, person);
            int e = findFloor(ends, person);
            if(s == -1)
            {
                continue;
            }
            // System.out.println(s+" "+e+" for "+person);
            ans[index] = Math.max(0, (s+1) - (e+1));
        }
        return ans;
    }
    
    public int findFloor(List<Integer> arr, int target) {
        int s = 0;
        int e = arr.size()-1;
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s)/2;
            if(arr.get(mid) <= target)
            {
                ans = mid;
                s = mid+1;
            }
            else
            {
                e = mid-1;
            }
        }
        return ans;
    }
}