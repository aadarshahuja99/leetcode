class Solution {
    public int minJumps(int[] arr) {
        if(arr.length == 1)
        {
            return 0;
        }
        System.out.println(arr.length);
        HashMap<Integer,HashSet<Integer>> adj = new HashMap<>();
        int idx = 0;
        for(int a : arr)
        {
            if(adj.containsKey(a))
            {
                adj.get(a).add(idx);
            }
            else
            {
                adj.put(a, new HashSet<Integer>());
                adj.get(a).add(idx);
            }
            idx++;
        }
        HashSet<Integer> visitedVals = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int distance = 0;
        int[] visited = new int[arr.length];
        visited[0] = 1;
        while(q.size() > 0)
        {
            distance++;
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                var top = q.poll();
                // System.out.println(top+" "+distance);
                if(top == arr.length-1)
                {
                    return distance-1;
                }
                if(!visitedVals.contains(arr[top]))
                {
                    for(int node : adj.get(arr[top]))
                    {
                        if(visited[node] == 0)
                        {
                            visited[node] = 1;
                            q.add(node);
                        }
                    }
                    visitedVals.add(arr[top]);
                }
                if(top-1 > 0 && !adj.get(arr[top]).contains(top-1) && visited[top-1] == 0)
                {
                    visited[top-1] = 1;
                    q.add(top-1);
                }
                if(top+1 < arr.length && !adj.get(arr[top]).contains(top+1) && visited[top+1] == 0)
                {
                    visited[top+1] = 1;
                    q.add(top+1);
                }
            }
            // System.out.println();
        }
        return 0;
    }
}