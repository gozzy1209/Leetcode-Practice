package Stack;

import java.util.Stack;

//150class Solution 
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                stack.add(stack.pop()+stack.pop());
            }
            else if(tokens[i].equals("-")){
                int b = stack.pop();
				int a = stack.pop();
				stack.add(a-b);
            }
            else if(tokens[i].equals("*")){
                stack.add(stack.pop()*stack.pop());
            }
            else if(tokens[i].equals("/")){
                int b = stack.pop();
				int a = stack.pop();
				stack.add(a / b);
            }
            else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
