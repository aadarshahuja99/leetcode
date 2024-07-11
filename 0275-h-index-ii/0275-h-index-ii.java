class Solution {
    public int hIndex(int[] citations) {
        // a slight modification to standard BS
        int numberOfCitations = citations.length;
        int start = 0;
        int end = numberOfCitations-1;
        int hIndex = -1;
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(citations[mid] == numberOfCitations - mid)
            {
                return citations[mid];
            }
            else if(citations[mid] < numberOfCitations - mid)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return hIndex == -1 ? numberOfCitations - start : hIndex;
    }
}