package cn.itcast.algorithm.test.listTest;

public class CircleListCheckTest {
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
        //产生环
        seven.next=third;

        //查找是否有环
        boolean mid = isCircle(first);
        System.out.println("链表是否有环为："+mid);
    }

    public static boolean isCircle(Node<String> first) {
        Node<String> fast = first;
        Node<String> slow = first;
        for(int index=0;fast!=null&fast.next!=null;index++){
            fast=fast.next.next;
            slow=slow.next;
            while(fast.equals(slow)){
                return true;
            }
        }
        return false;
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
