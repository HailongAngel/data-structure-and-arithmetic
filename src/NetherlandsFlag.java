/**
 * @program: idea代码
 * @description: 荷兰国旗
 * @author: Hailong
 * @create: 2018-08-16 20:45
 **/
public class NetherlandsFlag {
    public static int[] partition(int[] arr, int l, int r, int p) {
        int less = l - 1;
        int more = r + 1;
        int current = l;
        while (current < more) { //当这个数没有到右边界的时候一直循环
            if (arr[current] < p) {  //当前的数小于输入的数
                swap(arr, ++less, current++);  //将这个数放到小于的边界里面
            } else if (arr[current] > p) {   //当前的数大于输入的数
                swap(arr, --more, current);     //将这个数放到大于的边界里面
            } else {
                current++;                      //给等于的数流出空间
            }
        }
        return new int[] { less + 1, more - 1 }; //这个边界里面的数都是等于输入的数
    }

    // for test
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static int[] generateArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 3);
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] test = generateArray();

        printArray(test);
        int[] res = partition(test, 0, test.length - 1, 1);
        printArray(test);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
}
