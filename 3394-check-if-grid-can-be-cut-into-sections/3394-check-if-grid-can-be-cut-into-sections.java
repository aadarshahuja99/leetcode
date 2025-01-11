class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int numberOfRectangles = rectangles.length;
        int[][] xSegments = new int[numberOfRectangles][2];
        int[][] ySegments = new int[numberOfRectangles][2];
        int idx = 0;
        for(int[] rectangle : rectangles)
        {
            xSegments[idx] = new int[] { rectangle[0], rectangle[2] };
            ySegments[idx] = new int[] { rectangle[1], rectangle[3] };
            idx++;
        }
        Arrays.sort(xSegments, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });

        Arrays.sort(ySegments, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        
        int currentX = 0;
        int currentEnd = 0;
        int numXSegments = 0;
        while(currentX < numberOfRectangles)
        {
            currentEnd = xSegments[currentX][1];
            int j = currentX+1;
            while(j < numberOfRectangles && xSegments[j][0] < currentEnd)
            {
                currentEnd = Math.max(currentEnd, xSegments[j][1]);
                j++;
            }
            numXSegments++;
            currentX = j;
        }

        if(numXSegments >= 3)
        {
            // System.out.println("1");
            return true;
        }

        int numYSegments = 0;
        int currentY = 0;
        currentEnd = 0;
        while(currentY < numberOfRectangles)
        {
            currentEnd = ySegments[currentY][1];
            int j = currentY+1;
            while(j < numberOfRectangles && ySegments[j][0] < currentEnd)
            {
                currentEnd = Math.max(currentEnd, ySegments[j][1]);
                j++;
            }
            numYSegments++;
            currentY = j;
        }

        // System.out.println("2");
        return numYSegments >= 3;
    }
}