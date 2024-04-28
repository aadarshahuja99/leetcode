class DetectSquares {
    HashMap<Integer,HashMap<Integer, Integer>> coordinates;
    public DetectSquares() {
        coordinates = new HashMap<>();
    }
    
    public void add(int[] point) {
        if(!coordinates.containsKey(point[0]))
        {
            coordinates.put(point[0], new HashMap<>());
        }
        coordinates.get(point[0]).put(point[1], coordinates.get(point[0]).getOrDefault(point[1], 0) + 1);
    }
    
    public int count(int[] point) {
        int currentX = point[0];
        int currentY = point[1];
        int count = 0;
        for(Map.Entry<Integer,HashMap<Integer, Integer>> entry : coordinates.entrySet())
        {
            if(currentX == entry.getKey())
            {
                continue;
            }
            int newX = entry.getKey();
            for(var newYEntry : entry.getValue().entrySet())
            {
                int newY = newYEntry.getKey();
                if(newY == currentY || Math.abs(newX-currentX) != Math.abs(newY - currentY))
                {
                    continue;
                }
                int currentCount = newYEntry.getValue();
                if(coordinates.containsKey(newX) && coordinates.get(newX).containsKey(currentY) && coordinates.containsKey(currentX) && coordinates.get(currentX).containsKey(newY))
                {
                    currentCount = currentCount*coordinates.get(newX).get(currentY)*coordinates.get(currentX).get(newY);
                    count += currentCount;
                }
            }
        }
        return count;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */