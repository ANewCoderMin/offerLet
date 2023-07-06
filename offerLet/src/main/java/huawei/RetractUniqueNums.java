package huawei;

import java.util.Scanner;
import java.util.concurrent.Executors;

/**
 * @author Min
 * @create 2021-04-22 22:25
 */
public class RetractUniqueNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        int[] nums = new int[10];
        int indexNum = 1;
        for(int i = 0;i<line.length();i++){
            int num = Integer.valueOf(line.charAt(line.length() - i - 1));
            if(nums[num] == 0){
                nums[num] = indexNum;
                indexNum++;
            }
        }
        int[] nums2 = new int[11];
        for(int i = 0 ;i < nums.length;i++){
            nums2[nums[i]] = i;
        }
        for (int i = 1;i<nums2.length;i++){

        }
    }

}
