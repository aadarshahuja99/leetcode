class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        HashSet<Integer> forbiddenSet = new HashSet<>();
        for(int position : forbidden)
        {
            forbiddenSet.add(position);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0, 1 }); // position, moves, wasLastJumpBackward
        HashSet<String> visited = new HashSet<>();
        while(queue.size() > 0)
        {
            var top = queue.poll();
            int position = top[0];
            int moves = top[1];
            int wasLastJumpBackward = top[2];
            String key = position + "_" + wasLastJumpBackward;
            if(position == x)
            {
                return moves;
            }
            if(visited.contains(key))
            {
                continue;
            }
            visited.add(key);
            if(wasLastJumpBackward == 1)
            {
                if(position+a > x && (position+a) >= 6000)
                {
                    // can not jump forward either
                    continue;
                }
                if(!forbiddenSet.contains(position+a))
                {
                    queue.add(new int[] { position+a, moves+1, 0 });
                }
            }
            else
            {
                if(position-b >= 0 && !forbiddenSet.contains(position-b))
                {
                    queue.add(new int[] { position-b, moves+1, 1 });
                }
                if((position+a <= x || (position+a) < 6000) && !forbiddenSet.contains(position+a))
                {
                    queue.add(new int[] { position+a, moves+1, 0 });
                }
            }
        }
        return -1;
    }
}