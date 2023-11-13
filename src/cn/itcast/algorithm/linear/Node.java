package cn.itcast.algorithm.linear;

public class Node <T>{
    //存储数据
    public T item;
    //指向下一个结点
    public Node next;

    public Node(T item,Node next){
        this.item=item;
        this.next=next;
    }
}
