class Solution {
    public int distributeCookies(int[] cookies, int k) {
        return check(0, k, 0, cookies, new int[cookies.length]);
    }
    private int check(int currentCookie, int k, int max, int[] cookies, int[] dist)
    {
        if(currentCookie == cookies.length)
        {
            return currentCookie == cookies.length ? max : 1000000;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<k; i++)
        {
            int currentChild = i;
            dist[currentChild] += cookies[currentCookie];
            int assign = check(currentCookie+1, k, Math.max(max, dist[currentChild]), cookies, dist);
            min = Math.min(min, assign);
            dist[currentChild] -= cookies[currentCookie];
        }
        return min;
    }
}