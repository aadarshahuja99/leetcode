import java.util.*;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        // Step 1: Count standard frequencies
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: bucket[f] stores how many unique elements appear exactly 'f' times
        int[] bucket = new int[n + 1];
        for (int count : freqMap.values()) {
            bucket[count]++;
        }
        
        // Step 3: Track total remaining unique elements
        int remainingUnique = freqMap.size();
        
        // Step 4: Greedily eliminate elements starting from the smallest frequency (1)
        for (int freq = 1; freq <= n; freq++) {
            if (bucket[freq] == 0) continue;
            
            // How many elements with this frequency can we completely remove?
            int elementsToRemove = Math.min(k / freq, bucket[freq]);
            
            k -= elementsToRemove * freq;
            remainingUnique -= elementsToRemove;
            
            // If we don't have enough k left to remove even one whole element, stop
            if (k < freq) {
                break;
            }
        }
        
        return remainingUnique;
    }
}