package Stack;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int len=temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans= new int[len];
        for(int i=0;i<len;i++){
            //stack.peek():Looks at the object at the top of this stack without removing it from the stack.
            while(!stack.isEmpty()&&temperatures[stack.peek()]<temperatures[i]){
                ans[stack.peek()]=i-stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
