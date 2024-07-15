class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        int[] ans = new int[arrival.length];
        //timer
        int time = 0;
        //build 2 queues;
        Queue<Integer> enterQ = new LinkedList<>();
        Queue<Integer> exitQ = new LinkedList<>();
        // Handle the 4th rule:If multiple persons want to go in the same direction, the person with the smallest index goes first.
        for (int i = 0; i < state.length; i++) {
            if (state[i] == 0) {
                enterQ.add(i);
            } else {
                exitQ.add(i);
            }
        }
        // handle the 1st rule at time = 0;
        int prev = 1;
        // timer start
        while (!enterQ.isEmpty() && !exitQ.isEmpty()) {
            //Two or more person at the door, handle 2nd and 3rd rule;
            if (arrival[enterQ.peek()] <= time && arrival[exitQ.peek()] <= time) {
                if (prev == 0) {
                    int index = enterQ.poll();
                    ans[index] = time;                    
                } else {
                    int index = exitQ.poll();
                    ans[index] = time;
                }
            //Only one person at the door to enter;
            } else if (arrival[enterQ.peek()] <= time && arrival[exitQ.peek()] > time) {
                int index = enterQ.poll();
                ans[index] = time;
                prev = 0;
            //Only one person at the door to exit;
            } else if (arrival[enterQ.peek()] > time && arrival[exitQ.peek()] <= time){
                int index = exitQ.poll();
                ans[index] = time;
                prev = 1;
            //No one at the door now, handle the 1st rule;
            } else {
                prev = 1;
            }
            time++;
        }
        //clear queues
        while (!enterQ.isEmpty()) {
            int index = enterQ.poll();
            ans[index] = Math.max(arrival[index], time);
            time = Math.max(arrival[index], time) + 1;
        }
        while (!exitQ.isEmpty()) {
            int index = exitQ.poll();
            ans[index] = Math.max(arrival[index], time);
            time = Math.max(arrival[index], time) + 1;
        }
        
        return ans;
    }
}