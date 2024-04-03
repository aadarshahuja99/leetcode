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
            moves++;
            for(int idx = 0; idx < size; idx++)
            {
                String currentGene = queue.poll();
                if(currentGene.equals(endGene))
                {
                    return moves-1;
                }
                char[] charArray = currentGene.toCharArray();
                for(int i=0; i<8; i++)
                {
                    char originalChar = charArray[i];
                    for(int charIndex = 0; charIndex < 4; charIndex++)
                    {
                        if(originalChar == chars[charIndex])
                        {
                            continue;
                        }
                        charArray[i] = chars[charIndex];
                        String updatedGene = new String(charArray);
                        if(visited.contains(updatedGene) || !allowedGenes.contains(updatedGene))
                        {
                            continue;
                        }
                        visited.add(updatedGene);
                        queue.add(updatedGene);
                    }
                    charArray[i] = originalChar;
                }
            }
        }
        return -1;
    }
}