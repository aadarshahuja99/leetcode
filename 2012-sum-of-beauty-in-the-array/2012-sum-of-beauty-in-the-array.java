class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int maxSoFar = nums[0];
        Arrays.fill(answer, -1);
        for(int i=1; i<=n-2; i++)
        {
            if(nums[i] <= maxSoFar)
            {
                answer[i] = nums[i] > nums[i-1] && nums[i] < nums[i+1] ? 1 : 0;
            }
            else
            {
                maxSoFar = nums[i];
                // System.out.println("i is the new maximum: "+nums[i]);
                answer[i] = -2; // tentatively storing -2 as we dont know the next elements
            }
            // System.out.println(answer[i]+" for "+i+" "+nums[i]+" "+maxSoFar);
        }
        int minSoFar = nums[n-1];
        int sum = 0;
        for(int i=n-2; i>=1; i--)
        {
            if(nums[i] >= minSoFar)
            {
                answer[i] = nums[i] < nums[i+1] && nums[i] > nums[i-1] ? 1 : 0;
            }
            else
            {
                minSoFar = nums[i];
                answer[i] = answer[i] == -2 ? 2 : nums[i] > nums[i-1] ? 1 : 0;
            }
            // System.out.println("post: " + answer[i]+" for "+i+" "+minSoFar+" "+nums[i]);
            sum += answer[i];
        }
        return sum;
    }
}