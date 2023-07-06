package offer;

import java.util.HashSet;

/**
 * @author Min
 * @create 2021-04-16 21:57
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        int[] nums = {1,2,3,4,5,6,8,0,31,67,29,28,27,26,25,24,23,22,21};
        System.out.println(longestConsecutive.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums){
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums){
            numSet.add(num);
        }
        int longestStreak = 0;
        for (int num : numSet) {
            if(!numSet.contains(num - 1)){
                int currentStreak = 1;
                while(numSet.contains(num + 1)){
                    currentStreak += 1;
                    num++;
                }
                longestStreak = Math.max(currentStreak,longestStreak);
            }
        }
        return longestStreak;
    }
}
