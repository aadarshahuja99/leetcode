class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        // a kahn's algorithm based bfs can be done. At each level, there should only be one node
        int n = nums.length;
        int[] indegree = new int[n+1];
        HashSet<Integer> uniqueElements = new HashSet<>();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<=n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(List<Integer> seq : sequences)
        {
            uniqueElements.add(seq.get(0));
            if(seq.size() == 1)
            {
                continue;
            }
            for(int i=1; i<seq.size(); i++)
            {
                uniqueElements.add(seq.get(i));
                adjList.get(seq.get(i-1)).add(seq.get(i));
                indegree[seq.get(i)]++;
            }
        }
        if(n != uniqueElements.size())
        {
            // System.out.println("e1");
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++)
        {
            if(indegree[i] == 0)
            {
                queue.add(i);
                if(queue.size() > 1)
                {
                    // System.out.println("e2");
                    return false;
                }
            }
        }
        List<Integer> sequence = new ArrayList<>();
        while(queue.size() > 0)
        {
            int size = queue.size();
            if(size > 1)
            {
                // System.out.println("e3");
                return false;
            }
            var top = queue.poll();
            sequence.add(top);
            for(int node : adjList.get(top))
            {
                indegree[node]--;
                if(indegree[node] == 0)
                {
                    queue.add(node);
                }
            }
        }
        if(sequence.size() != n)
        {
            // System.out.println("e4");
            return false;
        }
        for(int i=0; i<n; i++)
        {
            if(sequence.get(i) != nums[i])
            {
                // System.out.println("e5");
                return false;
            }
        }
        return true;
    }
}