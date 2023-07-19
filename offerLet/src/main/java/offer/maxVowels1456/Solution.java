package offer.maxVowels1456;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ibpbhixfiouhdljnjfflpapptrxgcomvnb";
        int k  = 33;
        int res = solution.maxVowels(s, k);
    }

    public int maxVowels(String s, int k) {
        if (s == null || s.isBlank()){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int start = 0;
        int end = 0;
        int max = 0;
        int count = 0;
        while (end >= start && end < s.length()){
            if (count == k) {
                return k;
            }else {
                if (end - start < k){
                    if (set.contains(s.charAt(end))){
                        count++;
                        max = Math.max(count, max);
                    }
                    end++;
                }else {
                    if (set.contains(s.charAt(end))){
                        count++;
                        if (set.contains(s.charAt(start))){
                            count--;
                        }
                        max = Math.max(count, max);
                    }else {
                        if (set.contains(s.charAt(start))){
                            count = (count <= 0? 0 : count - 1);
                        }
                        max = Math.max(count, max);
                    }
                    start++;
                    end++;
                }
            }

        }
        return max;
    }

}
