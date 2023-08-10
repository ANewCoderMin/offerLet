package offer.asteroidCollision735;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public int[] asteroidCollision(int[] asteroids) {

        int i = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        while (i < asteroids.length){
            if (stack.isEmpty()){
                stack.push(asteroids[i]);
                i++;
                continue;
            }
            int item = stack.peek();
            int next = asteroids[i];
            if (item >>> 31 == next >>> 31) {
                stack.push(next);
                i++;
            }else {
                if (item < 0){
                    stack.push(next);
                    i++;
                }else {
                    if (Math.abs(item) > Math.abs(next)){
                        i++;
                    }else if (Math.abs(item) < Math.abs(next)){
                        stack.pop();
                    }else {
                        stack.pop();
                        i++;
                    }
                }
            }
        }
        int[] result = new int[stack.size()];
        int size = stack.size();
        for (int j = 0; j < size; j++) {
            result[size - j - 1] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.asteroidCollision(new int[]{5,10,-5});
    }
}
