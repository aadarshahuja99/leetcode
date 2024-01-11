public class Solution {
    public bool IsBipartite(int[][] graph) {
        int[] color = new int[graph.Length];
        for(int i=0; i<color.Length; i++)
        {
            color[i]=-1;
        }
        Queue<int> bfs = new();
        int current = 0;
        int remaining = graph.Length;
        while(remaining > 0 && current < graph.Length)
        {
            if(color[current] == -1)
            {
                bfs.Enqueue(current);
                color[current] = 0;
                remaining--;
                current++;
                while(bfs.Count > 0)
                {
                    var top = bfs.Dequeue();
                    foreach(int node in graph[top])
                    {
                        if(color[node] == -1)
                        {
                            if(color[top] == 1)
                            {
                                color[node] = 0;
                            }
                            else
                            {
                                color[node] = 1;
                            }
                            bfs.Enqueue(node);
                            remaining--;
                        }
                        else
                        {
                            if(color[node] == color[top])
                            {
                                return false;
                            }
                        }
                    }
                }
            }
            else
            {
                current++;
            }
        }
        return true;
    }
}