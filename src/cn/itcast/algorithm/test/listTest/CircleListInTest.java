package cn.itcast.algorithm.test.listTest;

/**
 * 有环链表入口问题
 */
public class CircleListInTest {
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
        Node entrance = getEntrance(first);
        System.out.println("first链表中环的入口结点元素为："+entrance.item);
    }

    public static Node getEntrance(Node<String> first) {
        Node<String> fast = first;
        Node<String> slow = first;
        Node<String> temp = null;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast.equals(slow)){
                temp =first;
                continue;
            }
            if(temp!=null){
                temp = temp.next;
                if(temp.equals(slow)){
                    break;
                }
            }
        }
        return slow;
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
