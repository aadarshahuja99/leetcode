class Solution {
    public int videoStitching(int[][] clips, int time) {
        int n = clips.length;
        int[] maxes = new int[n];
        Arrays.sort(clips, (a,b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        if(clips[0][0] > 1)
        {
            return -1;
        }
        int res = 0;
        for (int i = 0, st = 0, end = 0; st < time; st = end, ++res) {
            for (; i < n && clips[i][0] <= st; ++i)
            {
                end = Math.max(end, clips[i][1]);
            }
            if (st == end) return -1;
        }
        return res;
    }
}