class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a,b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        int n = properties.length;
        int maxDefence = 0;
        int ans = 0;
        for(int i=n-1; i>=0; i--)
        {
            if(maxDefence <= properties[i][1])
            {
                maxDefence = properties[i][1];
            }
            else
            {
                ans++;
            }
        }
        return ans;
    }
}