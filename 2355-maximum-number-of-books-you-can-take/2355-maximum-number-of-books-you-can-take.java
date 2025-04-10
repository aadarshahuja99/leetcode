class Solution {
    
    long[] cache;
    public long maximumBooks(int[] books) {
        cache = new long[books.length];

        Stack<Integer> booksShelvesToCheck = new Stack<>();
        long max = books[0];
        cache[0] = books[0];
        for (int i = 1; i < books.length; i++) {
            if (books[i] == 0) {
                // special case when value = 0 so we can instantly return 0
                cache[i] = 0L;                
            } else if (books[i - 1] < books[i]) {
                // current element higher than the previous one
                cache[i] = cache[i - 1] + books[i];
            } else {   
                // current element lower than the previous one, we can take (books[cur])(books[cur]+1)/2 in the best case but we need to find the limiting element
                int left = -1; // index of element that should be taken from dp, this will be the limiting element
                while (!booksShelvesToCheck.isEmpty()) {
                    int shelveToCheck = booksShelvesToCheck.peek();
                    if (books[shelveToCheck] < books[i] - (i - shelveToCheck)) {
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
                    
                    // cache[i] = dp(3) + ssum(books[5]) - ssum(books[5] - (i - left))
                    // cache[i] = dp(3) + ssum(7) - ssum(7 - (5 - 2))
                    // cache[i] = dp(3) + ssum(7) - ssum(7 - 3)
                    // cache[i] = dp(3) + ssum(7) - ssum(4)
                    cache[i] = cache[left] + ssum(books[i]) - ssum(books[i] - (i - left));
                } else {
                    // Input:
                    // * left = -1
                    // * i = 5

                    // index:          0 1 2 3 4 5                    
                    // value:          7 7 7 7 7 7
                    // books taken:    2 3 4 5 6 7  

                    // cache[i] = ssum(books[5]) - ssum(books[5] - i - 1)
                    // cache[i] = ssum(7) - ssum(7 - 5 - 1)
                    // cache[i] = ssum(7) - ssum(1)
                    cache[i] = ssum(books[i]) - ssum(books[i] - i - 1);
                }
            }
            booksShelvesToCheck.push(i);
            max = Math.max(max, cache[i]);
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