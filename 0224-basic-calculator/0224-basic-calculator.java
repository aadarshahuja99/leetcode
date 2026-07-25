class Solution {
    public int calculate(String s) {
        List<String> tokens = getTokens(s);
        List<String> postfix = getPostfix(tokens);
        return eval(postfix);
    }

    List<String> getTokens(String s) {
        int n = s.length();
        List<String> tokens = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(Character.isSpace(c)) continue;
            if(!Character.isDigit(c)) {
                tokens.add(String.valueOf(c));                
            } else {
                int number = 0;
                while(i < n && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                tokens.add(String.valueOf(number));                
            }
        }
        return tokens;
    }

    List<String> getPostfix(List<String> tokens) {        
        List<String> postfix = new ArrayList<>();
        Deque<String> opstack = new ArrayDeque<>();
        int operands = 0;
        int idx = -1;
        for(String token : tokens) {
            idx++;
            if(isOperator(token)) { // +, -                
                while(!opstack.isEmpty() && !opstack.peek().equals("(")) {
                    String x = opstack.pop();
                    System.out.println("Added " + x + " to postfix for idx "+idx);
                    postfix.add(x);
                }
                if("-".equals(token) && operands == 0) {
                    postfix.add("0");
                }
                opstack.push(token);
            } else if(isOperand(token)) { // numbers
                operands++;
                postfix.add(token);
            } else { // brackets
                if("(".equals(token)) {
                    operands = 0;
                    opstack.push(token);
                } else { // ")"
                    while(!opstack.isEmpty() && !opstack.peek().equals("(")) {
                        postfix.add(opstack.pop());
                    }
                    opstack.pop();
                }
            }
        }
        System.out.println(postfix);
        while(!opstack.isEmpty()) {
            postfix.add(opstack.pop());
        }

        return postfix;
    }

    int eval(List<String> postfix) {        
        int answer = 0;
        Deque<Integer> deq = new ArrayDeque<>();        
        for(String x : postfix) {
            if(isOperand(x)) {
                deq.push(Integer.parseInt(x));
            } else if(isOperator(x)) {
                if("+".equals(x)) {
                    int b = deq.pop();
                    int a = deq.pop();
                    deq.push(a + b);
                } else if("-".equals(x)) {
                    int b = deq.pop();
                    int a = deq.pop();
                    deq.push(a - b);
                }
            }
        }
        return deq.peek();
    }

    boolean isOperator(String str) {
        return "+".equals(str) || "-".equals(str);
    }

    boolean isOperand(String str) {
        try {
            Integer.parseInt(str);
        } catch(Exception e) {
            return false;
        }
        return true;
    }
}