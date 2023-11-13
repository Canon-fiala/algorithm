package cn.itcast.algorithm.test.treeTest;

import cn.itcast.algorithm.queue.MaxPriorityQueue;

public class MaxPriorityQueueTest {

    public static void main(String[] args) {
        //创建优先队列
        MaxPriorityQueue<String> queue = new MaxPriorityQueue<>(10);
        //往队列中存储元素
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");

        //通过循环获取队列中的最大的元素
        while(!queue.isEmpty()){
            String max =queue.delMax();
            System.out.print(max+"  ");
        }
    }
}
