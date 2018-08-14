package util;

/**
 * @program: idea代码
 * @description: 交换函数
 * @author: Hailong
 * @create: 2018-08-13 19:55
 **/
public class swap {
    public static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
