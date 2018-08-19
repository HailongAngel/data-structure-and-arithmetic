import java.util.Arrays;

/**
 * @program: idea代码
 * @description: 堆排序
 * @author: Hailong
 * @create: 2018-08-19 22:36
 **/
public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);    //将一个数组从开始到结束去组成一个大根堆
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    public static void heapInsert(int[] arr, int index) {//将数组组成大根堆
        while (arr[index] > arr[(index - 1) / 2]) {   //如果插入的节点大于父节点就去交换，如果是0位置，就和自己交换，去跳出循环
            swap(arr, index, (index - 1) / 2);        //子节点小于父节点，去交换
            index = (index - 1) / 2;                  //看看交换的父节点是否小于上一个父节点
        }
    }

    public static void heapify(int[] arr, int index, int size) { //size是堆得长度，因为有可能这个堆的大小不是数组的大小
        //index是新插入的数的坐标
        int left = index * 2 + 1;  //左孩子
        while (left < size) {       //确保左孩子没有越界
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;  //右孩子没有越界的情况下两个孩子的最大值
            largest = arr[largest] > arr[index] ? largest : index;  //父节点和最大的孩子比较，哪个大哪个就作为largest的下标
            if (largest == index) {  //如果我本身就变成更大的，就不用往下交换了
                break;
            }
            swap(arr, largest, index);  //和最大的孩子交换之后继续向下
            index = largest;            //将孩子的坐标赋值给新的父节点
            left = index * 2 + 1;       //继续重复
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
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

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }
}
