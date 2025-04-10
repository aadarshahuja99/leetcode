class Solution {
    public int minOperations(int[] target, int[] arr) {
        // LCS is the initial thought but tc wont allow it, convert it to LIS as follows:
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<target.length; i++)
        {
            map.put(target[i], i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        int idx = 0;
        for(int num : arr)
        {
            if(map.containsKey(arr[idx]))
            {
                // System.out.println("adding to list "+map.get(arr[idx])+ " for "+arr[idx]+","+idx);
                list.add(map.get(arr[idx]));
            }
            idx++;
        }
        if(list.size() == 0)
        {
            return target.length;
        }
        // find lis in nlogn
        int ans = 1;
        int[] lis = new int[list.size()];
        lis[0] = list.get(0);
        for(int i=1; i<list.size(); i++)
        {
            System.out.println(list.get(i));
            if(list.get(i) > lis[ans-1])
            {
                lis[ans] = list.get(i);
                ans++;
            }
            else
            {
                int ceil = findCeil(list.get(i), lis, ans);
                // System.out.println(ceil+" for "+list.get(i));
                if(ceil != -1)
                {
                    // System.out.println("setting lis's "+ceil+" to "+list.get(i));
                    lis[ceil] = list.get(i);
                }
            }
        }
        System.out.println(ans);
        return target.length - ans;
    }
    private int findCeil(int t, int[] nums, int n)
    {
        int s = 0;
        int ans = -1;
        int e = n-1;
        while(s <= e)
        {
            int m = s + (e - s)/2;
            if(nums[m] >= t)
            {
                ans = m;
                e = m-1;
            }
            else
            {
                s = m+1;
            }
        }
        return ans;
    }
}