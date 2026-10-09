import java.util.*;

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        
        // Maps each number to its index for quick lookup
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indexMap.put(arr[i], i);
        }
        
        long[] dp = new long[arr.length];
        Arrays.fill(dp, 1); // Each element itself forms at least 1 single-node tree
        
        long MOD = 1_000_000_007;
        long totalTrees = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            
            // Look only for factors that are actually present in our sorted array
            for (int j = 0; j < i; j++) {
                int factor = arr[j];
                
                // Optimized breaking condition
                if ((long) factor * factor > num) {
                    break;
                }
                
                // If factor divides num perfectly and the matching quotient is also in the array
                if (num % factor == 0 && indexMap.containsKey(num / factor)) {
                    int otherFactor = num / factor;
                    int otherIndex = indexMap.get(otherFactor);
                    
                    // Commutative tree options multiplier
                    long multiplier = (factor == otherFactor) ? 1 : 2;
                    
                    // Safely compute the product variations under modulo
                    long combinations = (dp[j] * dp[otherIndex]) % MOD;
                    combinations = (combinations * multiplier) % MOD;
                    
                    // Add safely to DP array under modulo
                    dp[i] = (dp[i] + combinations) % MOD;
                }
            }
            // Add the final total for this root element to the overall answer
            totalTrees = (totalTrees + dp[i]) % MOD;
        }
        
        return (int) totalTrees;
    }
}
