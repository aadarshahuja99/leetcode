class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        // 1. Build Max Heap
        for (int idx = 1; idx < n; idx++) {
            int j = idx;
            while (j > 0) {
                int parentIdx = (j - 1) / 2;
                if (nums[parentIdx] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[parentIdx];
                    nums[parentIdx] = temp;
                    j = parentIdx;
                } else {
                    break;
                }
            }
        }

        // 2. Extract elements from heap
        int deletes = 0;
        while (deletes < n - 1) {
            int size = n - deletes;
            
            // Swap root with last element of current heap
            int temp = nums[0];
            nums[0] = nums[size - 1];
            nums[size - 1] = temp;
            
            // Reduce heap size
            size--; 

            // Heapify down
            int i = 0;
            while (i < size) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int maxIdx = i; // Assume parent is the largest initially

                if (left < size && nums[left] > nums[maxIdx]) {
                    maxIdx = left;
                }
                if (right < size && nums[right] > nums[maxIdx]) {
                    maxIdx = right;
                }

                // If a child is larger, swap and continue down
                if (maxIdx != i) {
                    temp = nums[i];
                    nums[i] = nums[maxIdx];
                    nums[maxIdx] = temp;
                    i = maxIdx;
                } else {
                    break; // Parent is in the correct position
                }
            }
            deletes++;
        }
        return nums;
    }
}
