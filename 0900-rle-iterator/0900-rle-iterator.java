class RLEIterator {
    int currentIndex;
    int[] encodingCopy;
    public RLEIterator(int[] encoding) {
        encodingCopy = encoding;
        currentIndex = 0;
        while(currentIndex < encodingCopy.length && encodingCopy[currentIndex] == 0)
        {
            currentIndex += 2;
        }
    }
    
    public int next(int n) {
        int encodingLength = encodingCopy.length;
        if(currentIndex >= encodingLength)
        {
            return -1;
        }
        int remaining = n;
        int lastElement = -1;
        while(currentIndex < encodingLength && remaining > 0)
        {
            if(remaining <= encodingCopy[currentIndex])
            {
                encodingCopy[currentIndex] -= remaining;
                lastElement = encodingCopy[currentIndex+1];
                remaining = 0;
            }
            else
            {
                remaining -= encodingCopy[currentIndex];
                encodingCopy[currentIndex] = 0;
                currentIndex += 2;
            }
        }
        // System.out.println(remaining+" "+currentIndex+" "+n);
        if(remaining > 0)
        {
            return -1;
        }
        return lastElement;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */