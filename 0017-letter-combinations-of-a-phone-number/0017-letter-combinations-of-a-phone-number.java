class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.equals(""))
        {
            return new ArrayList<String>();
        }
        HashMap<Integer,List<Character>> numberMap = new HashMap<>();
        numberMap.put(2, Arrays.asList('a','b','c'));
        numberMap.put(3, Arrays.asList('d','e','f'));
        numberMap.put(4, Arrays.asList('g','h','i'));
        numberMap.put(5, Arrays.asList('j','k','l'));
        numberMap.put(6, Arrays.asList('m','n','o'));
        numberMap.put(7, Arrays.asList('p','q','r','s'));
        numberMap.put(8, Arrays.asList('t','u','v'));
        numberMap.put(9, Arrays.asList('w','x','y','z'));
        ArrayList<String> answer = new ArrayList<String>();
        getAllCombinations(0, digits, "", answer, numberMap);
        return answer;
    }
    private void getAllCombinations(int currentIndex, String digits, String currentString, ArrayList<String> answer, HashMap<Integer,List<Character>> numberMap)
    {
        if(currentIndex == digits.length())
        {
            answer.add(currentString);
            return;
        }
        int currentDigit = digits.charAt(currentIndex) - 48;
        for(char c : numberMap.get(currentDigit))
        {
            getAllCombinations(currentIndex+1, digits, currentString+c, answer, numberMap);
        }
    }
}