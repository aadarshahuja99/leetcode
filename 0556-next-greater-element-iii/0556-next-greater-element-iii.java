class Solution {
    public int nextGreaterElement(int n) {
        // knuth's algorithm
        int peakIndex = -1;
        var digits = getDigits(n);
        int i = digits.size() - 1;
        while(i >= 0)
        {
            if(i > 0 && digits.get(i-1) < digits.get(i))
            {
                peakIndex = i;
                break;
            }
            i--;
        }
        if(peakIndex == -1)
        {
            return -1;
        }
        i = digits.size() - 1;
        int minGreaterIndex = -1;
        int minGreater = Integer.MAX_VALUE;
        while(i >= peakIndex)
        {
            // System.out.println(i+" "+digits.get(i)+" "+minGreater+" "+digits.get(peakIndex - 1));
            if(minGreater > digits.get(i) && digits.get(i) > digits.get(peakIndex - 1))
            {
                minGreaterIndex = i;
                minGreater = digits.get(i);
            }
            i--;
        }
        int temp = digits.get(minGreaterIndex);
        digits.set(minGreaterIndex, digits.get(peakIndex-1));
        digits.set(peakIndex - 1, temp);
        List<Integer> rightHalf = new ArrayList<>();
        for(int it = peakIndex; it < digits.size(); it++)
        {
            rightHalf.add(digits.get(it));
        }
        Collections.sort(rightHalf);
        for(int it = peakIndex; it < digits.size(); it++)
        {
            digits.set(it, rightHalf.get(it-peakIndex));
        }
        long val = 0;
        for(int it = 0; it < digits.size(); it++)
        {
            val = val*10 + digits.get(it);
        }
        System.out.println(val);
        if(val > Integer.MAX_VALUE)
        {
            return -1;
        }
        return (int)val;
    }
    private ArrayList<Integer> getDigits(int n)
    {
        LinkedList<Integer> intermediate = new LinkedList<>();
        while(n > 0)
        {
            intermediate.addFirst(n%10);
            n = n/10;
        }
        return new ArrayList<Integer>(intermediate);
    }
}