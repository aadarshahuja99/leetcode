class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // apply a simple BFS/DFS. each argument of each equation can act as a node. Add a reverse edge to support reverse queries
        HashMap<String,ArrayList<Pair<String,Double>>> adjList = new HashMap<>();
        for(int i=0; i<values.length; i++)
        {
            var equation = equations.get(i);
            double value = values[i];
            double inverse = 1.0/values[i];
            String numerator = equation.get(0);
            String denomenator = equation.get(1);
            if(adjList.containsKey(numerator))
            {
                adjList.get(numerator).add(new Pair<String,Double>(denomenator,value));
            }
            else
            {
                var list = new ArrayList<Pair<String,Double>>();
                list.add(new Pair<String,Double>(denomenator,value));
                adjList.put(numerator,list);
            }

            if(adjList.containsKey(denomenator))
            {
                adjList.get(denomenator).add(new Pair<String,Double>(numerator,inverse));
            }
            else
            {
                var list = new ArrayList<Pair<String,Double>>();
                list.add(new Pair<String,Double>(numerator,inverse));
                adjList.put(denomenator,list);
            }
        }
        double[] answers = new double[queries.size()];
        for(int i=0; i<queries.size(); i++)
        {
            HashSet<String> visited = new HashSet<>();
            String queryNumerator = queries.get(i).get(0);
            String queryDenomenator = queries.get(i).get(1);
            if(!adjList.containsKey(queryNumerator) || !adjList.containsKey(queryDenomenator))
            {
                answers[i] = -1.0;
                continue;
            }
            answers[i] = dfs(queryNumerator,queryDenomenator,1.0,adjList,visited);
        }
        return answers;
    }
    private double dfs(String current, String target, double resultSoFar, HashMap<String,ArrayList<Pair<String,Double>>> adjList, HashSet<String> visited)
    {
        // System.out.println(current+" "+resultSoFar);
        if(current.equals(target))
        {
            return resultSoFar;
        }
        visited.add(current);
        for(var node : adjList.get(current))
        {
            String next = node.getKey();
            Double value = node.getValue();
            if(visited.contains(next))
            {
                continue;
            }
            // System.out.println("moving to next from current "+next+", "+current);
            double currentResult = dfs(next,target,value*resultSoFar,adjList,visited);
            if(currentResult >= 0.0)
            {
                return currentResult;
            }
        }
        return -1.0;
    }
}