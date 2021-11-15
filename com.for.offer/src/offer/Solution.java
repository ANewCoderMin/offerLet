package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Min
 * @create 2021-05-07 20:45
 */
public class Solution {

    public static List<List<Integer>> lists = new ArrayList<List<Integer>>();
    public static ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
    public static List<Integer> list ;
    public static void itGetTwo(int[] arrays,int num){
        recursion(arrays,0,num);
    }

    public static void recursion(int[] arrays,int startIndex,int num){
        if(deque.size() == 2){
            Integer first = deque.peekFirst();
            Integer second = deque.peekLast();
            System.out.println(first + " " + second);
            if(first + second == num){
                list = new ArrayList<Integer>();
                list.add(first);
                list.add(second);
                lists.add(list);
            }
            return;
        }
        for(int i = startIndex;i<arrays.length;i++){
            deque.add(arrays[i]);
            recursion(arrays,i+1,num);
            deque.pollLast();
        }

    }
    public static void main(String[] args) {
        int[] arrays = new int[]{1,2,3,4,5,6,7,8};
        itGetTwo(arrays,9);
        for(int i = 0;i<lists.size();i++){
            System.out.println(lists.get(i).toString());
        }
    }
}
