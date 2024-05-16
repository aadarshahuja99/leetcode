class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        // bfs question. The state of the system is defined by the water in each jug: x1, y1
        // From each state we can make 6 possible moves
        // 1. fill jug x completely
        // 2. fill jug y completely
        // 3. fill jug y to the top with water from jug x
        // 4. fill jug x to the top with water from jug y
        // 5. empty jug x
        // 6. empty jug y
        // perform a bfs from the state 0,0 and try to reach a state such that x1 + y1 = z
        // WellsFargo, Google and many firms love this question
        Queue<int[]> queue = new LinkedList<>();
        // use the matrix based key formation for converting the system state to a key
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        queue.add(new int[] { 0,0 });
        while(queue.size() > 0)
        {
            int[] top = queue.poll();
            int xAmount = top[0];
            int yAmount = top[1];
            visited.add(xAmount*(y+1) + yAmount);

            if(xAmount + yAmount == target)
            {
                return true;
            }

            // fill x completely
            int newX, newY;
            newX = x;
            newY = yAmount;
            pushElementToQueue(newX, newY, visited, queue, y);

            // fill y completely
            newX = xAmount;
            newY = y;
            pushElementToQueue(newX, newY, visited, queue, y);
            

            // fill x from y
            int amountToBeTransferredToX = Math.min(x - xAmount, yAmount);
            newX = xAmount + amountToBeTransferredToX;
            newY = yAmount - amountToBeTransferredToX;
            pushElementToQueue(newX, newY, visited, queue, y);
            

            // fill y from x
            int amountToBeTransferredToY = Math.min(y - yAmount, xAmount);
            newX = xAmount - amountToBeTransferredToY;
            newY = yAmount + amountToBeTransferredToY;
            pushElementToQueue(newX, newY, visited, queue, y);

            // empty x
            newX = 0;
            newY = yAmount;
            pushElementToQueue(newX, newY, visited, queue, y);
            
            // empty y
            newX = xAmount;
            newY = 0;
            pushElementToQueue(newX, newY, visited, queue, y);
        }
        return false;
    }
    private void pushElementToQueue(int newX, int newY, HashSet<Integer> visited, Queue<int[]> queue, int y)
    {
        if(!visited.contains(newX*(y+1) + newY))
        {
            // System.out.println("2: " + newX+" "+newY);
            queue.add(new int[] { newX, newY });
        }
    }
}