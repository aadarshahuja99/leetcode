class Solution {
    public List<String> commonChars(String[] words) {
        int[] counts = new int[26];
        int[] countWords = new int[26];
        for(String word : words)
        {
            int[] currentCount = new int[26];
            for(char c : word.toCharArray())
            {
                currentCount[c-'a']++;
            }
            for(int i=0; i<26; i++)
            {
                if(currentCount[i] > 0)
                {
                    if(counts[i] == 0)
                    {
                        counts[i] = currentCount[i];
                    }
                    else
                    {
                        counts[i] = Math.min(counts[i], currentCount[i]);
                    }
                    countWords[i]++;
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for(int i=0; i<26; i++)
        {
            if(countWords[i] == words.length)
            {
                String current = String.valueOf((char)(i + 97));
                for(int j=0; j<counts[i]; j++)
                {
                    ans.add(current);
                }
            }
        }
        return ans;
    }
}