/**
 * @program: idea代码
 * @description: 插入排序
 * @author: Hailong
 * @create: 2018-08-13 19:34
 **/
import  java.util.Arrays;

import static util.swap.swap;

public class InsertSort {
    public static void main(String[] args) {
        int arr[] = {1,3,2,8,6,9};
        if (arr == null || arr.length<2){
            return;
        }
        else {
            for (int i=1;i<arr.length;i++){  //从第二个数开始插，插完了
                for (int j=i-1;j>0&&arr[j]>arr[j+1];j--){  //从前向后比较，底线是j>0，有前面的数比自己大的就交换
                    swap(arr,j,j+1);
                }
            }
        }
        for (int i=0;i<arr.length;i++)
        System.out.println(arr[i]);
    }

}
