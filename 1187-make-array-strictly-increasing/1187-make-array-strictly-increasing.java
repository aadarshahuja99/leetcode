class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        HashMap<Integer,HashMap<Integer,Integer>> cache = new HashMap<>();
        int ans = getAns(0, arr1, arr2, 0, cache);
        return ans == 2001 ? -1 : ans;
    }
    private int getAns(int currentIndex1, int[] arr1, int[] arr2, int prev, HashMap<Integer,HashMap<Integer,Integer>> cache)
    {
        int n = arr1.length;
        if(currentIndex1 == n)
        {
            return 0;
        }
        if(cache.containsKey(currentIndex1) && cache.get(currentIndex1).containsKey(prev))
        {
            return cache.get(currentIndex1).get(prev);
        }
        if(!cache.containsKey(currentIndex1))
        {
            cache.put(currentIndex1, new HashMap<>());
        }
        int moveAhead = 2001;
        if(prev-1 < arr1[currentIndex1])
        {
            moveAhead = getAns(currentIndex1 + 1, arr1, arr2, arr1[currentIndex1] + 1, cache);
        }
        int floor = findCeil(arr2, prev-1);
        int swap = 2001;
        if(floor != -1)
        {
            swap = 1 + getAns(currentIndex1+1, arr1, arr2, arr2[floor] + 1, cache);
        }
        int ans = Math.min(swap, moveAhead);
        cache.get(currentIndex1).put(prev, ans);
        return ans;
    }

    private int findCeil(int[] arr, int target)
    {
        int start = 0;
        int end = arr.length-1;
        int ans = -1;
        while(start <= end)
        {
            int mid = start + (end- start)/2;
            if(arr[mid] > target)
            {
                ans = mid;
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return ans;
    }
}