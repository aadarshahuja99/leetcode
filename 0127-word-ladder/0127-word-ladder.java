class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean isPresent = false;
        int endIndex = 1;
        for(String word : wordList)
        {
            if(word.equals(endWord))
            {
                isPresent = true;
                break;
            }
            endIndex++;
        }
        if(!isPresent)
        {
            // System.out.println("exit 1");
            return 0;
        }
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=wordList.size(); i++)
        {
            adjList.add(new ArrayList<Integer>());
        }
        for(int i=0;i<wordList.size();i++)
        {
            if(check(beginWord,wordList.get(i)))
            {
                if(endIndex == i+1)
                {
                    return 2;
                }
                adjList.get(0).add(i+1);
                adjList.get(i+1).add(0);
            }
        }
        for(int i=0;i<wordList.size();i++)
        {
            for(int j=0;j<wordList.size();j++)
            {
                if(j==i)
                {
                    continue;
                }
                if(check(wordList.get(i),wordList.get(j)))
                {
                    adjList.get(j+1).add(i+1);
                    adjList.get(i+1).add(j+1);
                }
            }
        }
        LinkedList<QueueElement> q = new LinkedList<>();
        int[] distances = new int[wordList.size()+1];
        Arrays.fill(distances,Integer.MAX_VALUE);
        distances[0] = 0;
        q.addLast(new QueueElement(0,0));
        while(q.size() > 0)
        {
            QueueElement top = q.removeFirst();
            for(int node : adjList.get(top.getIndex()))
            {
                if(distances[node] > top.getDistance() + 1)
                {
                    distances[node] = top.getDistance() + 1;
                    // System.out.println("distance of node : " + wordList.get(node-1) + " from src = " + distances[node]);
                    q.addLast(new QueueElement(node,distances[node]));
                }
            }
        }
        if(distances[endIndex] == Integer.MAX_VALUE)
        {
            System.out.println("exit 2");
            return 0;
        }
        return distances[endIndex] + 1;
    }
    class QueueElement
    {
        private int index;
        private int dist;
        public QueueElement(int i, int d)
        {
            index = i;
            dist = d;
        }
        public void setDistance(int d)
        {
            dist = d;
        }
        public int getDistance()
        {
            return dist;
        }
        public int getIndex()
        {
            return index;
        }
    }
    private boolean check(String src, String dest)
    {
        int i=0;
        int count=0;
        while(i<src.length())
        {
            if(src.charAt(i) != dest.charAt(i))
            {
                count++;
            }
            if(count > 1)
            {
                return false;
            }
            i++;
        }
        return true;
    }
}