class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target)
        {
            return 0;
        }
        HashMap<Integer,ArrayList<Integer>> adjList = new HashMap<>();
        int busIndex = 0;
        for(int[] route : routes)
        {
            int length = route.length;
            for(int i=0; i<length-1; i++)
            {
                if(!adjList.containsKey(route[i]))
                {
                    adjList.put(route[i], new ArrayList<>());
                }
                adjList.get(route[i]).add(busIndex);
            }
            if(!adjList.containsKey(route[length-1]))
            {
                adjList.put(route[length-1], new ArrayList<>());
            }
            adjList.get(route[length-1]).add(busIndex);
            busIndex++;
        }
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int node : adjList.get(source))
        {
            visited.add(node);
            queue.add(node);
        }
        int buses = 1;
        while(queue.size() > 0)
        {
            int size = queue.size();
            for(int i=0; i<size; i++)
            {
                int top = queue.poll();
                for(int station : routes[top])
                {
                    if(station == target)
                    {
                        return buses;
                    }
                    for(int route : adjList.get(station))
                    {
                        if(!visited.contains(route))
                        {
                            visited.add(route);
                            queue.add(route);
                        }
                    }
                }
            }
            buses++;
        }
        return -1;
    }
}