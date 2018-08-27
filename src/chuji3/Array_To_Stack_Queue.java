package chuji3;

/**
 * @program: idea代码
 * @description: 用数组结构实现大小固定的队列和栈
 *
 * 	1. 用数组结构实现大小固定的队列和栈
a. 栈（在超前的位置上操作）
i. 不触犯边界的情况下，加一个数index++,减一个数--index
b. 队列（start和end没有关系）--->在当前位置下操作
i. 入：数组大小为3，如果size小于三，将用户给的数放到end上去，size+1
1) end:只要到了底就回到开头
出：如果size不等于0，把start位置上的数给用户,size-1
 * @author: Hailong
 * @create: 2018-08-27 21:44
 **/
public class Array_To_Stack_Queue {
    public static class ArrayStack {
        private Integer[] arr;
        private Integer size;

        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];//新创建一个数组，大小是初始化给的
            size = 0;
        }

        public Integer peek() {//只是返回一个栈顶元素
            if (size == 0) {
                return null;
            }
            return arr[size - 1];
        }

        public void push(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            arr[size++] = obj;//将值赋给size后size加一，因为size所指的位置是可以加入的位置
        }

        public Integer pop() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            return arr[--size];//先减后再返回
        }
    }

    public static class ArrayQueue {//它的两个指针是循环的
        private Integer[] arr;
        private Integer size;
        private Integer first;
        private Integer last;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
            first = 0;
            last = 0;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[first];
        }

        public void push(int obj) {
            if (size == arr.length) {//如果等与队列长度，还想加的话会出错
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size++;
            arr[last] = obj;//将值赋值给last指向的位置上
            last = last == arr.length - 1 ? 0 : last + 1;//跟新：如果到了最后就回到开头
        }

        public Integer poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int tmp = first;//开始的位置用tmp记录一下
            first = first == arr.length - 1 ? 0 : first + 1;//start 跟新：如果到了最后就回到开头
            return arr[tmp];//返回开始的位置
        }
    }

    public static void main(String[] args) {

    }

}
