class Solution {
    public String alienOrder(String[] words) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int n = words.length;
        if(n == 1)
        {
            StringBuilder sb = new StringBuilder();
            HashSet<Character> set = new HashSet<>();
            for(char c : words[0].toCharArray())
            {
                if(set.contains(c))
                {
                    continue;
                }
                set.add(c);
                sb.append(c);
            }
            return sb.toString();
        }

        for(int i=0; i<26; i++)
        {
            adjList.add(new ArrayList<>());
        }
        HashMap<Integer,Integer> indegree = new HashMap<>();
        HashSet<Integer> otherLetters = new HashSet<>(); 
        for(int i=0; i<n-1; i++)
        {
            int j=0;
            int k=0;
            int firstWordLength = words[i].length();
            int secondWordLength = words[i+1].length();
            String firstWord = words[i];
            String secondWord = words[i+1];
            while(j < firstWordLength && k < secondWordLength)
            {
                int firstIndex = firstWord.charAt(j) - 97;
                int secondIndex = secondWord.charAt(k) - 97;
                if(firstWord.charAt(j) != secondWord.charAt(k))
                {
                    adjList.get(firstIndex).add(secondIndex);
                    indegree.put(firstIndex, indegree.getOrDefault(firstIndex, 0));
                    indegree.put(secondIndex, indegree.getOrDefault(secondIndex, 0) + 1);
                    otherLetters.remove(firstIndex);
                    otherLetters.remove(secondIndex);
                    break;
                }
                otherLetters.add(firstIndex);
                otherLetters.add(secondIndex);
                j++;
                k++;
            }
            if(j < firstWordLength && k == secondWordLength)
            {
                return "";
            }
            while(j < firstWordLength)
            {
                otherLetters.add(firstWord.charAt(j) - 97);
                j++;
            }

            while(k < secondWordLength)
            {
                otherLetters.add(secondWord.charAt(k) - 97);
                k++;
            }
        }
        Queue<Integer> bfsQueue = new LinkedList<>();
        for(int key : indegree.keySet())
        {
            if(indegree.get(key) == 0)
            {
                bfsQueue.add(key);
            }
        }
        int visited = 0;
        StringBuilder sb = new StringBuilder();
        while(bfsQueue.size() > 0)
        {
            var top = bfsQueue.poll();
            visited++;
            sb.append((char)(top+97));
            for(int node : adjList.get(top))
            {
                if(indegree.get(node) == 0)
                {
                    continue;
                }
                indegree.put(node, indegree.get(node) - 1);
                if(indegree.get(node) == 0)
                {
                    bfsQueue.add(node);
                }
            }
        }
        for(int node : otherLetters)
        {
            if(!indegree.containsKey(node))
            {
                sb.append((char)(node + 97));
            }
        }
        if(visited < indegree.size())
        {
            return "";
        }
        return sb.toString();
    }
}