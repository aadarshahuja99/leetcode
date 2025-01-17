class Solution {
    public String longestDupSubstring(String s) {
        var low = 0;
        var high = s.length();
        var prime = (1 << 31) - 1;
        var letterSize = 26;
        var longestDupSub = "";
        while (low <= high) {
            var mid = low + (high - low) / 2;
            var dupSub = search(s, mid, prime, letterSize);
            if (dupSub == null) {
                high = mid - 1;
            } else {
                if (dupSub.length() > longestDupSub.length())
                    longestDupSub = dupSub;
                low = mid + 1;
            }
        }
        return longestDupSub;
    }

    /**
    * @param s          The original string
    * @param windowSize rolling hash window size controlled by mid
    * @param Q          a big prime
    * @param L          letter size
    * @return duplicate substring if any else null
    */
    private String search(String s, int windowSize, int Q, int L) {
        // calculate hash of first window
        var winHash = 0L;
        for (var i = 0; i < windowSize; i++)
            winHash = (L * winHash + s.charAt(i)) % Q;

        var map = new HashMap<Long, List<Integer>>();
        map.put(winHash, new ArrayList<>(Collections.singletonList(0)));

        var E = 1L; // L ^ pattern length mod Q
        for (var i = 1; i < windowSize; i++)
            E = L * E % Q;

        for (int i = 1; i <= s.length() - windowSize; i++) {
            // remove first char
            winHash = (winHash - E * s.charAt(i - 1) % Q + Q) % Q;
            // left shift
            winHash = winHash * L % Q;
            // add new last char
            winHash = (winHash + s.charAt(i + windowSize - 1)) % Q;

            // hash collision
            if (map.containsKey(winHash))
                for (var start : map.get(winHash))
                    if (isEqual(s, start, i, windowSize))
                        return s.substring(i, i + windowSize);
            map.computeIfAbsent(winHash, k -> new ArrayList<>()).add(i);
        }
        return null;
    }

    private boolean isEqual(String s, int previous, int current, int windowSize) {
        for (var j = 0; j < windowSize; j++)
            if (s.charAt(previous++) != s.charAt(current++))
                return false;
        return true;
    }
}