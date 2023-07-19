package offer.maxOperations1679;

import java.util.*;

public class Solution {

    public int maxOperations(int[] nums, int k) {
        if (nums == null) return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }
        for (int num : nums) {
            if (map.containsKey(num) && map.get(num) > 0 && map.containsKey(k -num) && map.get(k - num) > 0){
                map.put(num, map.get(num) - 1);
                if (map.containsKey(k -num) && map.get(k - num) > 0){
                    map.put(k - num, map.get(k - num) - 1);
                    count++;
                }else {
                    map.put(num, map.get(num) + 1);
                }
            }
        }
        return count;
    }
}
