class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        int sum = 0;
        for(int i=0; i<n; i++)
        {
            sum += chalk[i];
            if(sum > k)
            {
                return i;
            }
        }
        int remaining = k%sum;
        for(int i=0; i<n; i++)
        {
            if(remaining < chalk[i])
            {
                return i;
            }
            remaining -= chalk[i];
        }
        return -1;
    }
}