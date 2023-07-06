package offer.maximumEvenSplit2178;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> result = new ArrayList<>();
        if ((finalSum & 1) == 1){
            return result;
        }
        long tmp = 2;
        while (finalSum - tmp > tmp){
            result.add(tmp);
            finalSum = finalSum - tmp;
            tmp = tmp + 2;
        }
        result.add(finalSum);
        return result;
    }

    public static void main(String[] args) {
        System.out.printf(String.valueOf(3 & 1));
    }
}
