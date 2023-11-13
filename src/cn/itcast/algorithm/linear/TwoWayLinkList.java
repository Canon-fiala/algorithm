package cn.itcast.algorithm.linear;

import java.util.Iterator;

/**
 * 双向链表
 * 查找指定位置处的元素的时间复杂度为O(n)
 * 插入方法的时间复杂度为O(n)
 * 删除方法的时间复杂度为O(n)
 * @param <T>
 */
public class TwoWayLinkList<T> implements Iterable<T>{

    private Node head;
    private Node last;
    private int N;

    public TwoWayLinkList(){
        this.head = new Node(null,null,null);
        this.last=null;
        this.N=0;
    }


    private class Node{
        public T item;
        public Node next;
        public Node pre;

        public Node(T item,Node pre,Node next) {
            this.next = null;
            this.pre = null;
            this.item = item;
        }
    }

    public void clear(){
        this.head.next=null;
        this.head.pre=null;
        this.head.item=null;
        this.last=null;
        this.N=0;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int length(){
        return N;
    }
    public void insert(T t){
        if(isEmpty()){
            //如果链表为空
            //创建新的结点
            Node newNode = new Node(t,head,null);
            //让新的接地那称为尾结点
            last=newNode;
            //让头结点指向尾结点
            head.next=last;
        }else{
            Node oldLast = last;
            Node newNode = new Node(t, oldLast, null);
            oldLast.next=newNode;
            last = newNode;
        }
        N++;
    }
    //向指定位置i处插入元素
    public void insert(int i,T t){
        Node pre = head;
        for(int index=0;index<i;index++){
            pre=pre.next;
        }
        Node curr = pre.next;
        Node newNode = new Node(t,pre,curr);
        pre.next=newNode;
        curr.pre=newNode;
        N++;
    }
    public T remove(int i){
        //找到前一个结点
        Node pre = head;
        for(int index=0;index<i;index++){
            pre=pre.next;
        }
        //找到i位置当前位置
        Node curr = pre.next;
        //找到后一个结点
        Node currNext = curr.next;
        //前一个结点指向当前结点的后一个结点
        currNext.pre=null;
        currNext.next=null;
        pre.next=currNext;
        //i位置的下一个结点指向i位置的上一个结点
        currNext.pre=pre;
        //返回值
        N--;
        return curr.item;
    }
    public T get(int i){
        Node curr = head.next;
        for(int index=0;index<i;index++){
            curr=curr.next;
        }
        return curr.item;
    }
    public int indexOf(T t){
        Node curr = head.next;
        for(int index=0;curr.next!=null;index++){
            if(curr.item.equals(t)){
                return index;
            }
            curr=curr.next;
        }
        return -1;
    }
    public T getFirst(){
        if(isEmpty()){
            return null;
        }
        return head.next.item;
    }
    public T getLast(){
        if(isEmpty()){
            return null;
        }
        return last.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator{
        private Node n;
        public TIterator(){
            this.n=head;
        }
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.item;
        }
    }
}
