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
        HashSet<Integer> letters = new HashSet<>();
        HashSet<Integer> otherLetters = new HashSet<>(); 
        int[] indegree = new int[26];
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
                int firstIndex = firstWord.charAt(j) - 'a';
                int secondIndex = secondWord.charAt(k) - 'a';
                if(firstIndex != secondIndex)
                {
                    adjList.get(firstIndex).add(secondIndex);
                    indegree[secondIndex]++;
                    otherLetters.remove(firstIndex);
                    otherLetters.remove(secondIndex);
                    letters.add(firstIndex);
                    letters.add(secondIndex);
                    break;
                }
                // System.out.println("adding "+firstWord.charAt(j)+" to other letters for being the same");
                otherLetters.add(firstIndex);
                j++;
                k++;
            }
            if(j < firstWordLength && k == secondWordLength)
            {
                return "";
            }
            while(j < firstWordLength)
            {
                // System.out.println("adding "+firstWord.charAt(j)+" to other letters for being extra");
                otherLetters.add(firstWord.charAt(j) - 'a');
                j++;
            }
            while(k < secondWordLength)
            {
                // System.out.println("adding "+secondWord.charAt(k)+" to other letters for being extra");
                otherLetters.add(secondWord.charAt(k) - 'a');
                k++;
            }
        }
        Queue<Integer> bfsQueue = new LinkedList<>();
        for(int key : letters)
        {
            if(indegree[key] == 0)
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
            sb.append((char)(top+'a'));
            for(int node : adjList.get(top))
            {
                indegree[node]--;
                if(indegree[node] == 0)
                {
                    bfsQueue.add(node);
                }
            }
        }
        if(visited < letters.size())
        {
            return "";
        }
        for(int node : otherLetters)
        {
            if(!letters.contains(node))
            {
                // System.out.println("Adding "+(char)(node + 'a')+ " to ans for being extra");
                sb.append((char)(node + 'a'));
            }
        }
        return sb.toString();
    }
}