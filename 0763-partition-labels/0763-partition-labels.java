class Solution {
    public List<Integer> partitionLabels(String s) {
        int[][] intervals = new int[26][2];
        for(int i=0; i<26; i++)
        {
            intervals[i][0] = Integer.MAX_VALUE;
        }
        int idx = 0;
        int uniqueCharacterCount = 0;
        for(char c : s.toCharArray())
        {
            int alphabetIndex = c-97;
            if(intervals[alphabetIndex][0] == Integer.MAX_VALUE)
            {
                intervals[alphabetIndex][0] = idx;
                uniqueCharacterCount++;
            }
            intervals[alphabetIndex][1] = idx;
            idx++;
        }
        // idx = 0;
        // for(int[] interval : intervals)
        // {
        //     System.out.println(interval[0]+" "+interval[1]+" for "+(idx));
        //     idx++;
        // }
        Arrays.sort(intervals, (a,b) -> {
            return a[0] - b[0];
        });
        int i=0;
        int currentStart = 0;
        List<Integer> answer = new ArrayList<>();
        while(i < uniqueCharacterCount)
        {
            int j = i+1;
            int currentEnd = intervals[i][1];
            // System.out.println(currentStart + " " + currentEnd);
            while(j < uniqueCharacterCount && intervals[j][0] < currentEnd)
            {
                currentEnd = Math.max(intervals[j][1], currentEnd);
                // System.out.println("updated currentEnd to: "+currentEnd);
                j++;
            }
            answer.add(currentEnd - currentStart + 1);
            if(j < uniqueCharacterCount)
            {
                currentStart = intervals[j][0];
            }
            i=j;
        }
        return answer;
    }
}