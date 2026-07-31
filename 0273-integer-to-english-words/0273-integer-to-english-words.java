class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        
        StringBuilder words = new StringBuilder();
        
        // Find the starting scale (e.g., Billion, Million, etc.)
        int maxScale = 0;
        int temp = num;
        while (temp >= 1000) {
            temp /= 1000;
            maxScale++;
        }

        // Process from left to right using regular appends
        for (int i = maxScale; i >= 0; i--) {
            // Extract the specific 3-digit chunk for the current scale
            int divisor = (int) Math.pow(1000, i);
            int chunk = num / divisor;
            
            if (chunk != 0) {
                words.append(helper(chunk));
                if (i > 0) {
                    words.append(THOUSANDS[i]).append(" ");
                }
            }
            
            // Keep the remainder for the next loops
            num %= divisor;
        }

        return words.toString().trim();
    }

    private String helper(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return LESS_THAN_20[num] + " ";
        else if (num < 100)
            return TENS[num / 10] + " " + helper(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }
}
