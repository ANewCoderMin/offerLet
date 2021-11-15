package offer;

/**
 * @author Min
 * @create 2021-05-09 17:27
 */
public class MinArray {
    public static void main(String[] args) {
        MinArray minArray = new MinArray();
        int[] numbers = new int[]{3,4,5,1,2};
        System.out.println(minArray.minArray(numbers));
    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，
     * 该数组的最小值为1。  
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers){
        int low=0,pivot,high=numbers.length-1;
        while (low < high){
            System.out.println(low + " " + high);
            pivot = (low + high) /2;
            if(numbers[pivot] < numbers[high]){
                high = pivot;
            }else if(numbers[pivot] > numbers[high]){
                low = pivot + 1;
            }else {
                high -= 1;
            }
        }
        return numbers[high];
    }
}
