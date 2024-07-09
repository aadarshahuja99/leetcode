class Solution {
    public double averageWaitingTime(int[][] customers) {
        int currentEnd = 0;
        long total = 0;
        for(int[] customer : customers)
        {
            currentEnd = Math.max(customer[0], currentEnd) + customer[1];
            total += currentEnd - customer[0];
        }
        return (double)total/customers.length;
    }
}