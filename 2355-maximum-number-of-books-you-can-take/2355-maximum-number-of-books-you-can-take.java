class Solution {
    
    long[] cache;
    public long maximumBooks(int[] books) {
        cache = new long[books.length];

        Stack<Integer> booksShelvesToCheck = new Stack<>();
        long max = 0;
        for (int i = 0; i < books.length; i++) {
            Long result = 0L;    

            if (i == 0) {
                // first index only
                result = new Long(books[i]);

            } else if (books[i] == 0) {
                // special case when value = 0 so we can instantly return 0
                result = 0L;                

            } else if (books[i - 1] < books[i]) {
                // current element higher than the previous one
                result = cache[i - 1] + books[i];

            } else {   
                // current element lower than the previous one
                int left = -1; // index of element that should be taken from dp, this will be the limiting element
                while (!booksShelvesToCheck.isEmpty()) {
                    int shelveToCheck = booksShelvesToCheck.peek();
                    if (books[shelveToCheck] <= books[i] - (i - shelveToCheck)) {
                        left = shelveToCheck;
                        break;
                    } else {
                        booksShelvesToCheck.pop();
                    }
                }                        

                if (left >= 0) {
                    // Input:
                    // * left = 2
                    // * i = 5
                
                    // index:          0 1 2 3 4 5                    
                    // value:          3 3 3 7 7 7
                    // books taken:        | 5 6 7  
                    //                    dp(3)
                    
                    // result = dp(3) + ssum(books[5]) - ssum(books[5] - (i - left))
                    // result = dp(3) + ssum(7) - ssum(7 - (5 - 2))
                    // result = dp(3) + ssum(7) - ssum(7 - 3)
                    // result = dp(3) + ssum(7) - ssum(4)
                    result = cache[left] + ssum(books[i]) - ssum(books[i] - (i - left));
                } else {
                    // Input:
                    // * left = -1
                    // * i = 5

                    // index:          0 1 2 3 4 5                    
                    // value:          7 7 7 7 7 7
                    // books taken:    2 3 4 5 6 7  

                    // result = ssum(books[5]) - ssum(books[5] - i - 1)
                    // result = ssum(7) - ssum(7 - 5 - 1)
                    // result = ssum(7) - ssum(1)
                    result = ssum(books[i]) - ssum(books[i] - i - 1);
                }                                                                            
            }             

            booksShelvesToCheck.add(i);
            cache[i] = result;
            max = Math.max(max, result);        
        }

        return max;
    }
     
    private long ssum(long n) {
        if (n < 0) {
            return 0;
        }        

        // #### Input n = 3 ####
        //   1 + 2 + 3 = 6
        // but it can also be calulated like:
        //   (3 * 4) / 2 = 6
        //
        // #### Input n = 4 ####
        //   1 + 2 + 3 + 4 = 10
        // but it can also be calulated like:
        //   (4 * 5) / 2 = 10     
        return (n * (n + 1)) / 2;
    } 
}