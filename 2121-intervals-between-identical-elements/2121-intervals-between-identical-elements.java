class Solution {
    public long[] getDistances(int[] arr) {
        HashMap<Integer, long[]> front = new HashMap<>();
        HashMap<Integer, long[]> back = new HashMap<>();
        
        int n = arr.length;
        long[] ans = new long[n];
        for(int i=0; i<n; i++)
        {
            if(front.containsKey(arr[i]))
            {
                ans[i] = 1l*i*front.get(arr[i])[1] - front.get(arr[i])[0];
                front.get(arr[i])[0] += i;
                front.get(arr[i])[1]++;
            }
            else
            {
                front.put(arr[i], new long[] { i*1l, 1l });
            }
        }

        for(int i=n-1; i>=0; i--)
        {
            if(back.containsKey(arr[i]))
            {
                ans[i] += (back.get(arr[i])[0] - 1l*i*back.get(arr[i])[1]);
                back.get(arr[i])[0] += i;
                back.get(arr[i])[1]++;
            }
            else
            {
                back.put(arr[i], new long[] { i*1l, 1l });
            }
        }
        return ans;
    }
}