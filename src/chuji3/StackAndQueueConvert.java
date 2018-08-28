package chuji3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: idea代码
 * @description: 栈实现队列和队列实现栈
 * 		a. 两个队列，想要实现栈，先将进去队列里的进入到另一个队列，剩下一个元素再出，这样就实现了后进先出
i. 数用于只进a队列，出的时候只要a.size大于1，就把数据放入b队列，之后将a队列出来，还有个swap,将两个栈互换一下
b. 两个栈实现队列，将a中的数据都压入b中，从b出就实现了队列 ，
i. 要求：a中压数据压入b中一次压完
如果b中有东西，a中一定不要压
 * @author: Hailong
 * @create: 2018-08-28 23:24
 **/
public class StackAndQueueConvert {
    public static class TwoStacksQueue {//两个栈实现队列
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue() {//实现两个栈
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void push(int pushInt) {
            stackPush.push(pushInt);//一定在PUSH中压入数据
        }

        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());//给pop栈中压入push中的元素
                }
            }
            return stackPop.pop();//一定在pop中出数据，并且一次性出完
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }

    public static class TwoQueuesStack {//两个队列实现栈
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueuesStack() {
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int pushInt) {
            queue.add(pushInt);
        }

        public int peek() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (queue.size() != 1) {//当队列不等于1的时候一直将数据放入help中，好让最后一个元素出，
                //这个函数只是原来的数还都在
                help.add(queue.poll());
            }
            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }

        public int pop() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            while (queue.size() > 1) {//当队列不等于1的时候一直将数据放入help中，好让最后一个元素出，
                help.add(queue.poll());
            }
            int res = queue.poll();//最后一个元素出
            swap();                 //交换两个栈
            return res;
        }

        private void swap() {
            Queue<Integer> tmp = help;
            help = queue;
            queue = tmp;
        }

    }

}
