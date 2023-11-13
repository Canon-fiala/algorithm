package cn.itcast.algorithm.test.listTest;

import cn.itcast.algorithm.linear.SequenceList;

/**
 * 线性表测试
 * 测试线性表扩容
 */
public class SequenceListTest2 {
    public static void main(String[] args) {
        SequenceList<String> s1 = new SequenceList<>(3);
        s1.insert("张三");
        s1.insert("李四");
        s1.insert("王五");
        s1.insert("赵六");
    }
}
