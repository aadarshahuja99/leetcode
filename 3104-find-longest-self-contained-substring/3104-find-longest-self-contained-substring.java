class Solution {
        public int maxSubstringLength(String s) {
        int n = s.length(), res = -1, totalCount[] = new int[26];
        for (int i = 0; i < n; i++) totalCount[s.charAt(i) - 'a']++; // Count total number of chars in the String
        for (int i = 1; i <= 26; i++) { // i is the number of unique chars in the sub
            int valid = 0, unique = 0, left = 0, count[] = new int[26];
            for (int right = 0; right < n; right++) {
                count[s.charAt(right) - 'a']++; // Add the char to the sub
                if (count[s.charAt(right) - 'a'] == 1) unique++; // we saw a new char
                if (count[s.charAt(right) - 'a'] == totalCount[s.charAt(right) - 'a']) valid++; // all of this char is in this sub
                // make the current window valid
                for(;unique > i;left++) {
                    count[s.charAt(left) - 'a']--; // Remove the char from sub
                    if (count[s.charAt(left) - 'a'] == 0) unique--; // We lost one of the new chars
                    if (count[s.charAt(left) - 'a'] == totalCount[s.charAt(left) - 'a'] - 1) valid--; // Not all of the char is in this sub anymore
                }
                if (valid == i && right - left + 1 != n) res = Math.max(res, right - left + 1); // make sure it is not the string itself
            }
        }
        return res;
    }
}