import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Free
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5};
        ArrayList<Integer> arrList = new ArrayList<>();

        arrList.add(1);
        arrList.add(2);
        arrList.add(3);
        arrList.add(4);
        arrList.add(5);

        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("arrList = " + arrList);

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(1);
        arrayDeque.add(2);
        arrayDeque.add(3);

        arrayDeque.add(4);
        arrayDeque.add(5);

        System.out.println("arrayDeque = " + arrayDeque);
    }
}
