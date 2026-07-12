class Solution {
    public int minScoreTriangulation(int[] values) {
        // Select first partition DP: we will first select a value k between i+1 to j-1, which will divide the triangle into 3 parts, polygon i, i+1, i+2, ..., k; triagle i,k,j and polygon k, k+1..., j
        // For any two adjacent start vertices (lets start with 0, n-1 as the vertices are in clockwise order and 0, n-1 will always be adjacent), this process can be repeated until we cant make more triangles for the two polygons that the i,k,j triangle creates. It is select first partition DP as we are performing the triangle creation first and then solving recursively for the other two parts. On the other hand, in select last partition DP, such as Burst ballooons and MCM questions, when we perform an operation using K, that operation affects the other operations as a result we keep the k operation for being performed in the end but we already know the answer to the question: what will be the cost of i,k,j operation if it is performed at the end. In select first, we know the answer to the question: what will be the cost of i,k,j operation if it is performed at the beginning.
        int n = values.length;
        int[][] cache = new int[n][n];
        for(int i=n-1; i>=0; i--)
        {
            for(int j=0; j<n; j++)
            {
                if(Math.abs(i-j) <= 1)
                {
                    continue;
                }
                int currentAns = Integer.MAX_VALUE;
                for(int k=i+1; k<j; k++)
                {
                    int cost = values[i]*values[j]*values[k];
                    currentAns = Math.min(currentAns, cost + cache[i][k] + cache[k][j]);
                }
                cache[i][j] = currentAns;
            }
        }
        return cache[0][n-1];
    }
}