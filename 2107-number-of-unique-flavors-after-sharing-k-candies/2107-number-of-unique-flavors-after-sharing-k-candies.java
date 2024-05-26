class Solution {
    public int shareCandies(int[] candies, int k) {
        int n = candies.length;
        int start = 0;
        int end = 0;
        HashMap<Integer,Integer> countMap = new HashMap<>();
        for(int i=0; i<n; i++)
        {
            countMap.put(candies[i], countMap.getOrDefault(candies[i], 0) + 1);
        }
        if(k == 0)
        {
            return countMap.size();
        }
        int zeroes = 0;
        int ans = 0;
        while(end < n)
        {
            if(end - start < k)
            {
                countMap.put(candies[end], countMap.get(candies[end]) - 1);
                if(countMap.get(candies[end]) == 0)
                {
                    zeroes++;
                }
                end++;
            }
            if(end - start == k)
            {
                ans = Math.max(ans, countMap.size() - zeroes);
                countMap.put(candies[start], countMap.get(candies[start]) + 1);
                if(countMap.get(candies[start]) == 1)
                {
                    zeroes--;
                }
                start++;
            }
        }
        if(end - start == k)
        {
            ans = Math.max(ans, countMap.size() - zeroes);
        }
        return ans;
    }
}