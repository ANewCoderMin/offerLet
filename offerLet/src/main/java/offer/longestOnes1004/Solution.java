package offer.longestOnes1004;

public class Solution {


    public static void main(String[] args) {
        Solution so = new Solution();

        so.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2);
    }


    public int longestOnes(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int start = 0;
        int end = 0;
        int max = 0;
        int count = 0;



        while (end >= start && end < nums.length){
            if (count < k){
                if (nums[end] == 0){
                    count++;
                    if (count <= k){
                        max = Math.max(max, end - start + 1);
                    }
                }else {
                    max = Math.max(max, end - start + 1);
                }
                end++;
            }else {
                if (nums[end] == 0){
                    if (nums[start] == 0){
                        start++;

                        count = count < 1 ? 0 : count - 1;
                    }else {
                        start++;
                    }
                    if (end < start){
                        end++;
                    }
                }else {
                    max = Math.max(max, end - start + 1);
                    end++;
                }
            }
        }
        return max;
    }


}
