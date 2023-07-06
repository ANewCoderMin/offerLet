package offer;

import java.util.Stack;

/**
 * @author Min
 * @create 2021-04-17 21:08
 */
public class StackQueue {
    public static void main(String[] args) {

    }

    private Stack<String> stack1,stack2;
    public StackQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public void appendTail (String str){
        stack1.push(str);
    }

    public String getHead(){
        if (stack1.isEmpty())return null;

        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
