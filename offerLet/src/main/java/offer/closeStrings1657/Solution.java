package offer.closeStrings1657;

import java.util.HashMap;
import java.util.Map;

public class Solution {



    public boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length()){
            return false;
        }
        Map<Character, Integer> map1  = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
        }
        Map<Character, Integer> map2  = new HashMap<>();
        for (int i = 0; i < word2.length(); i++) {
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
        }
        if (map1.size() != map2.size()){
            return false;
        }else {
            for (Character character : map1.keySet()) {
                if (!map2.containsKey(character)){
                    return false;
                }
            }
            Map<Integer, Integer> word1Num = new HashMap<>();
            for (Integer value : map1.values()) {
                word1Num.put(value, word1Num.getOrDefault(value, 0) + 1 );
                if (!map2.containsValue(value)){
                    return false;
                }
            }
            Map<Integer, Integer> word2Num = new HashMap<>();
            for (Integer value : map2.values()) {
                word2Num.put(value, word2Num.getOrDefault(value, 0) + 1 );
            }
            for (Integer integer : word1Num.keySet()) {
                if (word1Num.get(integer) != word2Num.get(integer)){
                    return false;
                }
            }
        }
        return true;
    }
}
