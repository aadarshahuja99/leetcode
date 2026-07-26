class Solution {
    public int hIndex(int[] citations) {
        // a slight modification to standard BS
        int numberOfPapers = citations.length;
        int start = 0;
        int end = numberOfPapers-1;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(citations[mid] == numberOfPapers - mid)
            {
                return citations[mid];
            }
            else if(citations[mid] < numberOfPapers - mid)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        // case: [100], ans = 1
        // 3 cases: too many citations: [100,100,100] or too less citations [0,0,0] or start is inside the array [1,2]
        return numberOfPapers - start;
    }
}