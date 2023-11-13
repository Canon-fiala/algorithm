package cn.itcast.algorithm.queue;

import java.util.Iterator;

/**
 * 队列
 */
public class Queue<T> implements Iterable<T>{

    private Node head;
    private int N;
    private Node last;

    public Queue(){
        this.head=new Node(null,null);
        this.last=null;
        this.N=0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    /**
     * 插入结点（尾结点插入）
     * @param t
     */
    public void enqueue(T t){
        if(last==null){//如果尾结点为null
            last=new Node(t,null);
            head.next=last;
        }else {
            //当前尾结点不为null
            Node oldLast = last;
            last=new Node(t,null);
            oldLast.next=last;
        }
        N++;
    }

    /**
     * 队列中取出元素(头部取)
     * @return
     */
    public T dequeue(){

        if(isEmpty()){
            return null;
        }
        Node oldFirst = head.next;
            head.next = oldFirst.next;
            N--;
            if(isEmpty()){
                last=null;
            }
        return oldFirst.item;
    }

    private class Node{
        public T item;
        public Node next;

        public Node(T item,Node next){
            this.item=item;
            this.next=next;
        }
    }

    @Override
    public Iterator iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator{
        private Node n;

        public QIterator(){
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
