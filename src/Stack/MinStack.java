package Stack;

import java.util.Stack;

//155 Min Stack
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minstack;

    public MinStack() {
        stack=new Stack<>();
        minstack=new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(!minstack.isEmpty()){
            //after peek, minstack is empty
            int min=minstack.peek();
            if(val<=min){
                minstack.push(val);
            }
        }
        else{
            minstack.push(val);
        }

    }
    
    public void pop() {
        int val=stack.pop();
        if(!minstack.isEmpty()){
            if(val==minstack.peek()){
                minstack.pop();
            }
        }

    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}
