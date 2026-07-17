class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sr, sc });
        int[][] DIRS = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int initialColor = image[sr][sc];
        if(initialColor == color)
        {
            return image;
        }
        image[sr][sc] = color;
        while(q.size() > 0)
        {
            int[] top = q.poll();
            for(int[] d : DIRS)
            {
                int nr = top[0] + d[0];
                int nc = top[1] + d[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == initialColor)
                {
                    image[nr][nc] = color;
                    q.add(new int[] { nr, nc });
                }
            }
        }
        return image;
    }
}