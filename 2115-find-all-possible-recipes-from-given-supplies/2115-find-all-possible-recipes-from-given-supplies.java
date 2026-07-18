class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String,ArrayList<String>> adjMap = new HashMap<>();
        HashMap<String,Integer> indegree = new HashMap<>();
        for(int i=0; i<recipes.length; i++)
        {
            for(int j=0; j<ingredients.get(i).size(); j++)
            {
                if(!adjMap.containsKey(ingredients.get(i).get(j)))
                {
                    adjMap.put(ingredients.get(i).get(j), new ArrayList<String>());
                }
                adjMap.get(ingredients.get(i).get(j)).add(recipes[i]);
            }
            indegree.put(recipes[i],ingredients.get(i).size());
        }
        Queue<String> q = new LinkedList<String>();
        List<String> ans = new ArrayList<String>();
        for(String s : supplies)
        {
            if(adjMap.containsKey(s))
            {
                q.add(s);
            }
        }
        while(q.size() > 0)
        {
            var top = q.poll();
            if(indegree.containsKey(top))
            {
                ans.add(top);
            }
            for(String node : adjMap.getOrDefault(top, new ArrayList<>()))
            {
                indegree.put(node, indegree.get(node)-1);
                if(indegree.get(node) == 0)
                {
                    q.add(node);
                }
            }
        }
        return ans;
    }
}