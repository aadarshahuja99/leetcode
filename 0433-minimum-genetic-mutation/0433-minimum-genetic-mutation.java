class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> allowedGenes = new HashSet<>();
        for(String gene : bank)
        {
            allowedGenes.add(gene);
        }
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        int moves = 0;
        char[] chars = new char[] { 'A','C','G','T' };
        while(queue.size() > 0)
        {
            int size = queue.size();
            for(int idx = 0; idx < size; idx++)
            {
                String currentGene = queue.poll();
                if(currentGene.equals(endGene))
                {
                    return moves;
                }
                for(String gene : bank)
                {
                    if(checkIfGenesDifferByOne(currentGene, gene) && !visited.contains(gene))
                    {
                        visited.add(gene);
                        queue.add(gene);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
    private boolean checkIfGenesDifferByOne(String s, String t)
    {
        int diff = 0;
        for(int i=0; i<8; i++)
        {
            if(s.charAt(i) != t.charAt(i))
            {
                diff++;
                if(diff > 1)
                {
                    return false;
                }
            }
        }
        return diff == 1;
    }
}