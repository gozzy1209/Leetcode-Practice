package Stack;

import java.util.Stack;

//20. Valid Parentheses
/*Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type. */
public class ValidParentheses {
    public boolean isValid(String s) {
        //stack
        //遇到左括号就用stack push进对应的左括号类型
        //如果遍历到右括号就对stack进行弹出pop
        //最先弹出的右括号一定对应的是最后进入stack的左括号，即最最近对应最近
        //如果pop出的元素==遍历到的右括号，则暂时true，否则马上false
        Stack<Character> stack=new Stack<>();
        for(char i:s.toCharArray()){
            //对左括号进行处理，这思路简直无敌
            if(i=='['){
                stack.push(']');
            }
            else if(i=='{'){
                stack.push('}');
            }
            else if(i=='('){
                stack.push(')');
            }
            //遇到右括号的情况
            //stack.isEmpty()是为了判断右括号过多
            //stack.pop()!=i是为了防止左括号过多或者是不对应
            else if(stack.isEmpty()||stack.pop()!=i){
                return false;
            }
            }
            //这步不太懂，为什么不能直接return true
            //个人的想法是，最后一次弹出前并不是empty，但是弹出后跳出循环就是empty了
            return stack.isEmpty();
    }
    
}
class Solution_2ndtry {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') stack.add(')');
            else if(s.charAt(i)=='{') stack.add('}');
            else if(s.charAt(i)=='[') stack.add(']');
            else{
                //stack.isEmpty() is to prevent too much ] } or )
                if(stack.isEmpty()||stack.pop()!=s.charAt(i)) return false;
            }
        }
        ////stack.isEmpty() is to prevent too much { [ or (
        return stack.isEmpty();
    }
}
