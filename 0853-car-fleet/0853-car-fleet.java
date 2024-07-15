class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] info = new int[position.length][2];
        for(int i=0; i<position.length; i++)
        {
            int dist = target - position[i];
            info[i][0] = dist;
            info[i][1] = speed[i];
        }
        Arrays.sort(info, new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                return a[0] - b[0];
            }
        });
        Stack<Double> stack = new Stack<>();
        for(int i=0; i<info.length; i++)
        {
            double currentTime = (double)info[i][0]/(double)info[i][1];
            if(stack.size() == 0 || stack.peek() < currentTime)
            {
                stack.push(currentTime);
            }
        }
        return stack.size();
    }
}