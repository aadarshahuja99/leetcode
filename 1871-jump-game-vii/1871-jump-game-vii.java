class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if(s.charAt(n-1) != '0')
        {
            return false;
        }
        // bfs from 0th index. Similar to min number of taps, jump game 2, 
        int farthestFromCurrentLevel = 0;
        // using a queue here as the nodes in a level are not adjacent elements of the array (only nodes with val 0 are pushed into the queue)
        Queue<Integer> bfs = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        bfs.add(0);
        visited.add(0);
        while(bfs.size() > 0)
        {
            int top = bfs.poll();
            if(top == n-1)
            {
                return true;
            }
            // System.out.println(Math.max(farthestFromCurrentLevel, top+minJump)+" "+Math.min(top+maxJump, n-1));
            for(int i=Math.max(farthestFromCurrentLevel, top+minJump); i <= Math.min(top+maxJump, n-1); i++)
            {
                if(s.charAt(i) == '0' && !visited.contains(i))
                {
                    // System.out.println("adding "+i+ " to queue");
                    visited.add(i);
                    bfs.add(i);
                }
            }
            farthestFromCurrentLevel = Math.max(farthestFromCurrentLevel, top+maxJump);
        }
        return false;
    }
}