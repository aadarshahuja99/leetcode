class Solution {
    public int findMinArrowShots(int[][] points) {
        // not a range sum problem
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                if(a[1] == b[1])
                {
                    return Long.compare(a[0],b[0]);
                }
                return Long.compare(a[1],b[1]);
            }
        });
        Stack<int[]> stack = new Stack<>();
        stack.push(points[0]);
        System.out.println(points[0][0] + " " + points[0][1]);
        for(int i=1; i<points.length; i++)
        {
            int[] current = points[i];
            if(stack.peek()[1] >= current[0])
            {
                int lower = Math.max(current[0], stack.peek()[0]);
                int upper = Math.min(current[1], stack.peek()[1]);
                var top = stack.pop();
                top[0] = lower;
                top[1] = upper;
                stack.push(top);
            }
            else
            {
                stack.push(current);
            }
        }
        return stack.size();
    }
}