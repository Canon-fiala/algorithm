package cn.itcast.algorithm.test.stackQueueTest;

import cn.itcast.algorithm.queue.Queue;

/**
 * 队列测试
 */
public class QueueTest {

    public static void main(String[] args) {
        //创建队列对象
        Queue<String> q = new Queue<>();
        //测试队列的enqueue
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        q.enqueue("d");

        for(String str:q){
            System.out.println(str);
        }

        System.out.println("-----------------------------");
        //测试队列的dequeue
        System.out.println("出队列的元素的为："+q.dequeue());
    }
}
