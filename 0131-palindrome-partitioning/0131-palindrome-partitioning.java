class Solution {
    ArrayList<List<String>> ans = new ArrayList<List<String>>();
    LinkedList<String> list = new LinkedList<String>();
    public List<List<String>> partition(String s) {
        compute(0,s,0);
        return ans;
    }
    private void compute(int current, String s, int addedLength)
    {
        if(current == s.length())
        {
            if(addedLength != s.length())
            {
                return;
            }
            ans.add(new ArrayList<String>(list));
        }
        String temp = "";
        for(int k=current; k<s.length(); k++)
        {
            temp += s.charAt(k);
            if(isPalindrome(temp))
            {
                // take
                list.addLast(temp);
                addedLength += k-current+1;
                compute(k+1,s,addedLength);
                // revert
                list.removeLast();
                addedLength -= k-current+1;
            }
        }
    }
    private boolean isPalindrome(String s)
    {
        if(s.length() == 1)
        {
            return true;
        }
        int i=0;
        int j=s.length()-1;
        while(i<j && s.charAt(i) == s.charAt(j))
        {
            i++;
            j--;
        }
        return i>=j;
    }
}