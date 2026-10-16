class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // approach: calculate the indegree of each value. if any value has an indegree of > 1 or if there are more than 1 values with indegree = 0, return false. Find the root (the node with indegree 0, and then apply bfs starting from root and check if any visited node is being visited again (ie if there is a cycle in the list))
        int[] indegree = new int[n];
        int root = -1;
        for(int i=0; i<n; i++)
        {
            if(leftChild[i] != -1)
            {
                indegree[leftChild[i]] += 1;
                if(indegree[leftChild[i]] > 1)
                {
                    return false;
                }
            }
            if(rightChild[i] != -1)
            {
                indegree[rightChild[i]] += 1;
                if(indegree[rightChild[i]] > 1)
                {
                    return false;
                }
            }
        }
        for(int i=0; i<n; i++)
        {
            if(indegree[i] == 0)
            {
                if(root != -1)
                {
                    return false;
                }
                root = i;
            }
        }
        if(root == -1)
        {
            return false;
        }
        Queue<Integer> bfs = new LinkedList();
        bfs.add(root);
        int count = 0;
        boolean[] visited = new boolean[n];
        while(bfs.size() > 0)
        {
            int size = bfs.size();
            for(int idx=0; idx<size; idx++)
            {
                var top = bfs.poll();
                if(visited[top])
                {
                    return false;
                }
                visited[top] = true;
                count++;
                if(leftChild[top] != -1)
                {
                    bfs.add(leftChild[top]);
                }
                if(rightChild[top] != -1)
                {
                    bfs.add(rightChild[top]);
                }
            }
        }
        // if count < n then there is a cycle in the tree
        return count == n;
    }
}