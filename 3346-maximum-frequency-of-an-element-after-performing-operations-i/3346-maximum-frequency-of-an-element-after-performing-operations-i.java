class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int max = 0;
        for(int num : nums)
        {
            max = Math.max(max, num);
        }
        int n = max + k + 1;
        int[] frequency = new int[n];
        for(int num : nums)
        {
            frequency[num]++;
        }
        int[] numberOfElements = new int[n];
        for(int i=1; i<n; i++)
        {
            numberOfElements[i] = numberOfElements[i-1] + frequency[i];
        }
        int maxFrequencySoFar = 0;
        // any element in the range of 0 to max+k can be the answer
        for(int i=0; i<n; i++)
        {
            int maxLimitForCurrentElement = Math.min(i+k, n-1);
            int minLimitForCurrentElement = Math.max(i-k, 0);
            int totalElementsInLimits = numberOfElements[maxLimitForCurrentElement];
            if(minLimitForCurrentElement > 0)
            {
                totalElementsInLimits -= numberOfElements[minLimitForCurrentElement-1]; // remove counts of all elements < minLimitForCurrentElement
            }
            // System.out.println("for "+i+": "+numOperations+" "+(totalElementsInLimits - frequency[i]));
            maxFrequencySoFar = Math.max(maxFrequencySoFar, frequency[i] + Math.min(numOperations, totalElementsInLimits - frequency[i]));
        }
        return maxFrequencySoFar;
    }
}