class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        // kahn's algorithm
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int[] relation : relations)
        {
            adjList.get(relation[0]-1).add(relation[1]-1);
            indegree[relation[1] - 1]++;
        }
        Queue<Integer> bfsQueue = new LinkedList<>();
        int semesters = 0;
        for(int i=0; i<n; i++)
        {
            if(indegree[i] == 0)
            {
                // System.out.println("adding "+i+" to bfsQueue.");
                bfsQueue.add(i);
            }
        }
        if(bfsQueue.size() == 0)
        {
            return -1;
        }
        int courses = 0;
        while(bfsQueue.size() > 0)
        {
            int size = bfsQueue.size();
            for(int i=0; i<size; i++)
            {
                int top = bfsQueue.poll();
                courses++;
                for(int node : adjList.get(top))
                {
                    indegree[node]--;
                    if(indegree[node] == 0)
                    {
                        bfsQueue.add(node);
                    }
                }
            }
            semesters++;
        }
        if(courses < n)
        {
            return -1;
        }
        return semesters;
    }
}