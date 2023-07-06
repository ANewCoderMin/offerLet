package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Min
 * @create 2021-04-21 22:10
 */
public class SplitWordsEveryEightChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder ;
        String line;
        List<String> list = new ArrayList<String>();
        while(scanner.hasNext()){
            line = scanner.nextLine();
            builder = new StringBuilder(line);
            int length = 8 - builder.length()%8;
            for(int i = 0;i<length;i++){
                builder.append('0');
            }
            String str = builder.toString();
            int circulateTime = str.length()/8;
            for (int i = 0;i<circulateTime;i++){
                System.out.println(str.substring(i*8,8*(i+1)));
            }

        }
        scanner.close();
    }

}
