class Solution {
    public int largestIsland(int[][] grid) {
        HashMap<Integer,Integer> parentMap = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> sizeMap = new HashMap<Integer,Integer>();
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
                if(grid[i][j] == 1 && !parentMap.containsKey(i*grid[0].length + j))
                {
                    sizeMap.put(i*grid[0].length + j, 1);
                    parentMap.put(i*grid[0].length + j, i*grid[0].length + j);
                    dfs(grid,parentMap,sizeMap,i,j);
                }
            }
        }
        int max = 0;
        for (var entry : sizeMap.entrySet()) {
            // System.out.println("size: "+entry.getValue() + " for parent: "+entry.getKey());
            max = Math.max(max,entry.getValue());
        }
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
                if(grid[i][j] == 0)
                {
                    HashSet<Integer> set = new HashSet<Integer>();
                    int[] deltaR = { 1, 0, -1, 0 };
                    int[] deltaC = { 0, -1, 0, 1 };
                    int candidate = 1;
                    for(int k=0; k<4; k++)
                    {
                        int newR = i + deltaR[k];
                        int newC = j + deltaC[k];
                        int key = newR*grid[0].length + newC;
                        // System.out.println("for newR:  "+newR+" and newC: "+newC+" current key: "+key);
                        if(newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && parentMap.containsKey(key))
                        {
                            set.add(parentMap.get(key));
                        }
                    }
                    for(int p : set)
                    {
                        // System.out.println("adding "+sizeMap.get(p)+" to candidate " + "for parent : " + p);
                        candidate += sizeMap.get(p);
                    }
                    // System.out.println(i + " " + j + " c: " + candidate + " max: " + max);
                    max = Math.max(max,candidate);
                }
            }
        }
        return max;
    }
    private void dfs(int[][] grid, HashMap<Integer,Integer> parentMap, HashMap<Integer,Integer> sizeMap, int r, int c)
    {
        int[] deltaR = { 1, 0, -1, 0 };
        int[] deltaC = { 0, -1, 0, 1 };
        for(int i=0; i<4; i++)
        {
            int newR = r + deltaR[i];
            int newC = c + deltaC[i];
            if(newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && grid[newR][newC] == 1 && !parentMap.containsKey(newR*grid[0].length + newC))
            {
                parentMap.put(newR*grid[0].length + newC, parentMap.get(r*grid[0].length + c));
                int key=newR*grid[0].length+newC;
                // System.out.println("parent of: "+ key + " is = "+parentMap.get(r*grid[0].length + c));
                int val = sizeMap.get(parentMap.get(r*grid[0].length + c));
                sizeMap.replace(parentMap.get(r*grid[0].length + c),val+1);
                dfs(grid,parentMap,sizeMap,newR,newC);
            }
        }
    }
}