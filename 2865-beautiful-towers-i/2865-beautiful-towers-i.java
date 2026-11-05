class Solution {
    public long maximumSumOfHeights(int[] maxHeights) {
        int n = maxHeights.length;
        long[] leftSum = new long[n];
        long[] rightSum = new long[n];
        
        // Monotonic stack stores indices
        Stack<Integer> stack = new Stack<>();
        
        // 1. Compute leftSum[i]: Max sum of non-decreasing subarray ending at index i
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && maxHeights[stack.peek()] > maxHeights[i]) {
                stack.pop();
            }
            
            // j is the index of the nearest smaller element to the left
            int j = stack.isEmpty() ? -1 : stack.peek();
            
            // Elements from (j + 1) to i are all capped at maxHeights[i]
            long count = i - j;
            leftSum[i] = count * maxHeights[i] + (j == -1 ? 0 : leftSum[j]);
            
            stack.push(i);
        }
        
        // Clear stack to reuse for the right side
        stack.clear();
        
        // 2. Compute rightSum[i]: Max sum of non-increasing subarray starting at index i
        for (int i = n - 1; i >= -1; i--) { // looping backward
            if (i == -1) break; // guard condition
            
            while (!stack.isEmpty() && maxHeights[stack.peek()] > maxHeights[i]) {
                stack.pop();
            }
            
            // j is the index of the nearest smaller element to the right
            int j = stack.isEmpty() ? n : stack.peek();
            
            // Elements from i to (j - 1) are all capped at maxHeights[i]
            long count = j - i;
            rightSum[i] = count * maxHeights[i] + (j == n ? 0 : rightSum[j]);
            
            stack.push(i);
        }
        
        // 3. Find the maximum mountain sum by trying every element as the peak
        long maxTotalSum = 0;
        for (int i = 0; i < n; i++) {
            long totalSumIfPeak = leftSum[i] + rightSum[i] - maxHeights[i];
            maxTotalSum = Math.max(maxTotalSum, totalSumIfPeak);
        }
        
        return maxTotalSum;
    }
}