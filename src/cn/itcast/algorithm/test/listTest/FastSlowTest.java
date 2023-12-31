package cn.itcast.algorithm.test.listTest;

/**
 * 快慢指针查找中间值算法问题
 */
public class FastSlowTest {
    public static void main(String[] args) {
        Node<String> first = new Node<String>("aa", null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> fourth = new Node<String>("dd", null);
        Node<String> fifth = new Node<String>("ee", null);
        Node<String> six = new Node<String>("ff", null);
        Node<String> seven = new Node<String>("gg", null);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;

        //查找中间值
        String mid = getMid(first);
        System.out.println("中间值为："+mid);
    }

    public static String getMid(Node<String> first) {
        Node<String> fast=first;
        Node<String> slow=first;
        for(int index=0;fast.next!=null&&fast.next.next!=null;index++){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow.item;
    }

    //结点类
    private static class Node<T>{
        //存储数据
        T item;
        //下一个结点
        Node next;
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }


}
