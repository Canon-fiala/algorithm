package cn.itcast.algorithm.test.listTest;

import cn.itcast.algorithm.linear.Node;

public class NodeTest {

    public static void main(String[] args) {
        //构建结点
        Node<Integer> first = new Node<Integer>(11,null);
        Node<Integer> second = new Node<Integer>(13,null);
        Node<Integer> third = new Node<Integer>(12,null);
        Node<Integer> fourth = new Node<Integer>(8,null);
        Node<Integer> fifth = new Node<Integer>(9,null);

        //每个结点的下一个结点   生成链表
        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
    }
}
