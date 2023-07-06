package huawei;

/**
 * @author Min
 * @create 2021-04-21 20:33
 */
public class LastWordLength {


    public int lastWordLength(String words){

        int index = words.length();
        int length = 0;
        while (words.charAt(index)!= ' ' && index >= 0){
            length++;
            index--;
        }
        return length;
    }
}
