package util;

import java.util.Arrays;

/**
 * @program: idea代码
 * @description: 对数器
 * @author: Hailong
 * @create: 2018-08-13 21:56
 **/
public class Logarithm {
    public static void insertionSort(int[] arr) { //插入排序
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    //一个交换的方法
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }



    //好的但是不复杂的算法
    public static void comparator(int arr[]){
        Arrays.sort(arr);
    }

    //获得一个大小随机，值随机的数组，随机样本产生器
    public  static  int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr = new int[(int) ((maxSize+1)*Math.random())];
        for (int i = 0;i<arr.length;i++){
            arr[i] = (int)((maxValue + 1)*Math.random()) - (int)(maxValue*Math.random());

        }
        return  arr;
    }

    //实现比对的方法
    public  static  int[] copyArray(int[] arr){
        if (arr == null)
            return  null;
        int[] res = new int[arr.length];
        for (int i = 0; i<res.length;i++){
            res[i] = arr[i];
        }
        return res;
    }

    //查看两个数组是否相同，只有相同了，才可以比较出来自己的方法是否错误
    public  static  boolean isEqual(int[] arr1,int[] arr2){
        if ((arr1==null && arr2!=null) || (arr1!=null && arr2==null)){
            return  false;
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

    //输出错误的数组，为了查验自己的问题出在哪
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
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            insertionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
               printArray(arr3);  //打印出来错误的测试用例
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        insertionSort(arr);
        printArray(arr);

    }
}
