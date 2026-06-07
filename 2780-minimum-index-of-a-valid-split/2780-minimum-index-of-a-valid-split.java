class Solution {
    public int minimumIndex(List<Integer> nums) {
        if(nums.size() == 1)
        {
            return -1;
        }
        int n = nums.size();
        int[] post = new int[n];
        HashMap<Integer,Integer> countMap = new HashMap<>();
        int cnt = 0;
        int max = 0;
        for(int i=n-1; i>0; i--)
        {
            countMap.put(nums.get(i), countMap.getOrDefault(nums.get(i), 0) + 1);
            if(nums.get(i) == max)
            {
                cnt++;
            }
            else
            {
                if(cnt == 0)
                {
                    max = nums.get(i);
                    cnt = 1;
                }
                else
                {
                    cnt--;
                }
            }
            if(cnt > 0 && countMap.get(max) > (n - i)/2)
            {
                post[i] = max;
            }
            else
            {
                post[i] = -1;
            }
            // System.out.println("Post for i="+i+" is "+post[i]);
        }
        max = 0;
        cnt = 0;
        HashMap<Integer,Integer> countMapFromStart = new HashMap<>();
        for(int i=0; i<n-1; i++)
        {
            countMapFromStart.put(nums.get(i), countMapFromStart.getOrDefault(nums.get(i), 0) + 1);
            if(nums.get(i) == max)
            {
                cnt++;
            }
            else
            {
                if(cnt == 0)
                {
                    max = nums.get(i);
                    cnt = 1;
                }
                else
                {
                    cnt--;
                }
            }
            if(cnt > 0 && countMapFromStart.get(max) > (i + 1)/2 && post[i+1] == max)
            {
                return i;
            }
        }
        return -1;
    }
}