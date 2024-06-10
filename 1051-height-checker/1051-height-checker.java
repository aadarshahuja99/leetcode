class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] newArr = new int[n];
        int idx = 0;
        for(int h : heights)
        {
            newArr[idx] = h;
            idx++;
        }
        Arrays.sort(newArr);
        int ans = 0;
        for(int i=0; i<n; i++)
        {
            ans += (newArr[i] != heights[i]) ? 1 : 0;
        }
        return ans;
    }
}