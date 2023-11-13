package cn.itcast.algorithm.test.sortTest;

import cn.itcast.algorithm.sort.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SortCompare {

    public static void main(String[] args) {
        //1.创建一个Arraylist集合，保存读取出来的整数。
        ArrayList<Integer> list = new ArrayList<>();
        //2.创建一个缓存读取流，并保存在list中。
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (SortCompare.class.getClassLoader()
                        .getResourceAsStream("reverse_arr.txt")));

        try {
            String line = null;
            while((line=reader.readLine())!=null){
                //line为字符串,需要把line转换为Integer，使用parseInt(),存储在集合中
                int i = Integer.parseInt(line);
                list.add(i);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //把ArrayList转换为数组.
        Integer[] a = new Integer[list.size()];
        list.toArray(a);

//        //插入排序测试最坏的十万条数据用时30153毫秒
//        testInsert(a);
//        //冒泡排序测试最坏的十万条数据用时27800毫秒
//        testBubble(a);
//        //希尔排序测试最坏的十万条数据用时12毫秒
//          testShell(a);
//        //归并排序测试最坏的十万条数据用时11毫秒
//        testMerge(a);
        //快速排序测试最坏的十万条数据用时
        testQuick(a);
    }

    public static void testShell(Integer[] a){
        long start = System.currentTimeMillis();
        Shell.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("希尔排序的时间:"+(end-start)+"毫秒");

    }
    public static void testInsert(Integer[] a){
        long start = System.currentTimeMillis();
        Insertion.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("插入排序的时间:"+(end-start)+"毫秒");
    }
    public static void testBubble(Integer[] a){
        long start = System.currentTimeMillis();
        Bubble.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序的时间:"+(end-start)+"毫秒");
    }

    public static void testMerge(Integer[] a){
        long start = System.currentTimeMillis();
        Merge.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("归并排序的时间:"+(end-start)+"毫秒");
    }
    public static void testQuick(Integer[] a){
        long start = System.currentTimeMillis();
        Quick.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("快速排序的时间:"+(end-start)+"毫秒");
    }
}
