class Solution {
    public boolean validWordSquare(List<String> words) {
        int rows = words.size();
        int columns = 0;
        for(String word : words)
        {
            columns = Math.max(columns, word.length());
        }
        for(int i=0; i<rows; i++)
        {
            String rowWord = words.get(i);
            if(i >= columns)
            {
                return false;
            }
            int idx = 0;
            int colIndex = i;
            while(idx < rowWord.length())
            {
                if(idx >= rows)
                {
                    return false;
                }
                if(colIndex >= words.get(idx).length() || (words.get(idx).charAt(colIndex) != words.get(colIndex).charAt(idx)))
                {
                    return false;
                }
                idx++;
            }
        }
        return true;
    }
}