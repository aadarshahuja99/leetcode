class Solution {
    public boolean parseBoolExpr(String expression) {
        if(expression.length() == 1)
        {
            return expression.charAt(0) == 't';
        }
        Stack<Pair<Character, Integer>> operators = new Stack<>();
        Stack<Pair<Boolean, Integer>> results = new Stack<>();
        int idx = 0;
        for(char c : expression.toCharArray())
        {
            if(c == '!' || c == '&' || c == '|')
            {
                operators.push(new Pair<>(c, idx));
            }
            else if(c == '(' || c == ',')
            {
                continue;
            }
            else if(c == ')')
            {
                if(operators.peek().getKey() == '!')
                {
                    var top = results.pop();
                    results.push(new Pair<>(!top.getKey(), top.getValue()));
                    operators.pop();
                }
                else
                {
                    boolean intermediateResult = false;
                    if(operators.peek().getKey() == '&')
                    {
                        intermediateResult = true;
                    }
                    else
                    {
                        intermediateResult = false;
                    }
                    while(!results.isEmpty() && results.peek().getValue() > operators.peek().getValue())
                    {
                        if(operators.peek().getKey() == '&')
                        {
                            intermediateResult = intermediateResult & results.peek().getKey();
                            results.pop();
                        }
                        else
                        {
                            intermediateResult = intermediateResult | results.peek().getKey();
                            results.pop();
                        }
                    }
                    results.push(new Pair<>(intermediateResult, idx));
                    operators.pop();
                }
            }
            else
            {
                results.push(new Pair<>(c == 't', idx));
            }
            idx++;
        }
        return results.peek().getKey();
    }
}