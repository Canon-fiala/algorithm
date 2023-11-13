package cn.itcast.algorithm.test.treeTest;

import cn.itcast.algorithm.heap.Heap;

public class HeapTest {
    public static void main(String[] args) {
        //创建堆对象
        Heap<String> heap = new Heap<>(10);
        //往堆中存入字符串数据
        heap.insert("a");
        heap.insert("b");
        heap.insert("c");
        heap.insert("d");
        heap.insert("e");
        heap.insert("f");
        heap.insert("g");
        //通过循环从堆中删除数据
        String result = null;
        while((result = heap.delMax())!=null){
            System.out.print(result+" ");
        }
    }
}
