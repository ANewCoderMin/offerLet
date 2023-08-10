package offer.predictPartyVictory649;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {


    public String predictPartyVictory(String senate) {
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R'){
                rQueue.offer(i);
            }else {
                dQueue.offer(i);
            }
        }
        while (!rQueue.isEmpty() && !dQueue.isEmpty()){
            Integer r = rQueue.poll();
            Integer d = dQueue.poll();
            if (r < d){
                rQueue.offer(r + senate.length());
            }else {
                dQueue.offer(d + senate.length());
            }
        }
        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}
