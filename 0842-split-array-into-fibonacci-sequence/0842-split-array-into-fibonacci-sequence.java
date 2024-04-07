class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        if(num.length() < 3)
        {
            return new ArrayList<Integer>();
        }
        List<Integer> numbers = new ArrayList<>();
        boolean ans = getSequence(1, num, num.charAt(0)*1l - 48*1l, -1, -1, numbers, new LinkedList<Integer>());
        return numbers;
    }
    private boolean getSequence(int currentIndex, String num, long current, int last, int lastToLast, List<Integer> answer, LinkedList<Integer> candidate)
    {
        if(currentIndex == num.length())
        {
            if(last != -1 && lastToLast != -1 && current == last + lastToLast)
            {
                candidate.addLast((int)current);
                answer.addAll(new ArrayList(candidate));
                return true;
            }
            // System.out.println("exit 1: "+last+" "+lastToLast+" "+current);
            return false;
        }
        if(current == 0)
        {
            if(last != -1 && lastToLast != -1 && (last + lastToLast != 0))
            {
                // System.out.println("exit 2: "+last+" "+lastToLast+" "+current);
                return false;
            }
            candidate.addLast((int)current);
            boolean ans = getSequence(currentIndex+1, num, (num.charAt(currentIndex)-48)*1l, 0, last, answer, candidate);
            if(ans)
            {
                return true;
            }
            candidate.removeLast();
            return false;
        }
        // selecting the first two numbers
        if(last == -1 || lastToLast == -1)
        {
            long updatedCurrent = current*10 + (num.charAt(currentIndex) - 48);
            boolean ans = false;
            if(updatedCurrent <= Integer.MAX_VALUE)
            {
                ans = ans || getSequence(currentIndex+1, num, updatedCurrent, last, lastToLast, answer, candidate);
                if(ans)
                {
                    return true;
                }
            }
            candidate.addLast((int)current);
            ans = ans || getSequence(currentIndex+1, num, (num.charAt(currentIndex)*1l - 48*1l), (int)current, last, answer, candidate);
            if(ans)
            {
                return true;
            }
            candidate.removeLast();
            return ans;
        }
        if(current > last + lastToLast || current > Integer.MAX_VALUE)
        {
            // System.out.println("exit 3: "+last+" "+lastToLast+" "+current);
            return false;
        }
        if(current == last + lastToLast)
        {
            candidate.addLast((int)current);
            boolean ans = getSequence(currentIndex+1, num, (num.charAt(currentIndex)*1l - 48*1l), (int)current, last, answer, candidate);
            if(ans)
            {
                return true;
            }
            candidate.removeLast();
            // System.out.println("exit 4: "+last+" "+lastToLast+" "+current);
            return false;
        }
        long updatedCurrent = current*10 + (num.charAt(currentIndex) - 48);
        return getSequence(currentIndex+1, num, updatedCurrent, last, lastToLast, answer, candidate);
    }
}