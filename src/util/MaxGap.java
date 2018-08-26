package util;

import java.util.Arrays;

/**
 * @program: idea代码
 * @description: 桶排序
 * @author: Hailong
 * @create: 2018-08-26 23:06
 * 		c. 题目：给定一个数组，求如果排序之后相邻两个数之间的最大差值，要求时间复杂度N，不能基于基本排序
i. 有N个数，准备N+1个桶，遍历数组，求最大和最小数的差值，等分为N+1份，分别放到属于自己的桶里，
ii. 0号桶一定有数，N号桶一定有数，所以肯定会至少空下一个空桶，所以相差最大的一定不是相邻的桶
设置三个值flag(是否为空值)max(这个桶中最大值)min(这个桶中最小值)/
iii. 查看每个非空桶的左面离他最近的非空桶，左面非空桶的最大值和本身非空桶的最小值，求差值，用全局变量跟新一下，找到最大的（空桶两侧不一定最大）

 **/
public class MaxGap {
    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {//数组为空或者长度为1的话返回
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;  //为了寻找最小值，先设为系统最大的，方便找出比他小的求得最小值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {//找到数组里面的最大最小值，方便分桶
            min = Math.min(min, nums[i]);//寻找最小值
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];//第一个变量，看看数组里面是否为空
        int[] maxs = new int[len + 1];//每个桶里面的最大值
        int[] mins = new int[len + 1];//每个桶里面的最小值
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max);  //将每个数放到相应的桶里
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];//求出桶中的最小值
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];//求出桶中的最大值
            hasNum[bid] = true;//判断是否为空
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);//全局变量找两个桶的最大值
                lastMax = maxs[i];//左面非空桶的最大值
            }
        }
        return res;
    }

    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));//求得每个数应该放在哪个桶里面
    }

    // for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
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
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (maxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
