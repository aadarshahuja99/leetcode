class Solution {
    public int countCollisions(String directions) {
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        for(char c : directions.toCharArray())
        {
            if(stack.size() == 0)
            {
                stack.push(c);
            }
            else if(stack.size() > 0)
            {
                if(stack.peek() == 'S' && c == 'L')
                {
                    stack.push('S');
                    ans++;
                }
                else if(stack.peek() == 'R' && c == 'L')
                {
                    ans += 2;
                    stack.pop();
                    while(stack.size() > 0 && stack.peek() == 'R')
                    {
                        ans++;
                        stack.pop();
                    }
                    stack.push('S');
                }
                else if(stack.peek() == 'R' && c == 'S')
                {
                    while(stack.size() > 0 && stack.peek() == 'R')
                    {
                        ans++;
                        stack.pop();
                    }
                    stack.push('S');
                }
                else
                {
                    stack.push(c);
                }
            }
        }
        return ans;
    }
}