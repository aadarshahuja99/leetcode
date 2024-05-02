class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[n];
        int currentTimeStamp = -1;
        for(String log : logs)
        {
            String[] components = log.split(":");
            int id = Integer.parseInt(components[0]);
            int status = components[1].equals("end") ? 1 : 0;
            int timeStamp = Integer.parseInt(components[2]);
            if(!stack.isEmpty())
            {
                // end of a function call
                if(status == 1)
                {
                    ans[stack.peek()[0]] += timeStamp - currentTimeStamp + 1;
                    // System.out.println("1: " + (timeStamp - currentTimeStamp) + " added to " + stack.peek()[0]);
                    stack.pop();
                    currentTimeStamp = timeStamp + 1;
                }
                else
                {
                    ans[stack.peek()[0]] += timeStamp - currentTimeStamp;
                    // System.out.println("2: " + (timeStamp - currentTimeStamp) + " added to " + stack.peek()[0]);
                    stack.push(new int[] { id, status, timeStamp });
                    currentTimeStamp = timeStamp;
                }
            }
            else
            {
                stack.push(new int[] { id, status, timeStamp });
                currentTimeStamp = timeStamp;
            }
        }
        return ans;
    }
}