package cn.itcast.algorithm.linear;

import java.util.Iterator;

/**
 * 栈
 */
public class Stack<T> implements Iterable{

    private Node head;
    private int N;

    public Stack(){
        this.head=new Node(null,null);
        this.N=0;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return N==0;
    }

    /**
     * 获取大小
     * @return
     */
    public int size(){
        return N;
    }

    /**
     * 弹出栈元素
     * @return
     */
    public T pop(){
        Node oldFirst = head.next;
        if(oldFirst==null){
            return null;
        }
        Node newFirst = oldFirst.next;
        head.next = newFirst;
        N--;
        return oldFirst.item;
    }

    /**
     * 压入栈元素
     */
    public void push(T t){
        //找到首节点指向的第一个结点
        Node oldFirst = head.next;
        //创建新结点
        Node newNode =new Node(t,null);
        //让首节点指向新节点
        head.next=newNode;
        //让新结点指向第一个结点
        newNode.next=oldFirst;
        //结点数+1
        N++;
    }

    private class Node{
        private Node next;
        private T item;

        public Node(T item,Node next){
            this.item=item;
            this.next=next;
        }
    }

    @Override
    public Iterator iterator() {
        return new TIterator();
    }

    public class TIterator implements Iterator{

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
