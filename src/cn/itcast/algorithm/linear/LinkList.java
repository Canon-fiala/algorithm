package cn.itcast.algorithm.linear;

import java.util.Iterator;

/**
 * 单链表
 * 查找指定位置处的元素的时间复杂度为O(n)
 * 插入方法的时间复杂度为O(n)
 * 删除方法的时间复杂度为O(n)
 * @param <T>
 */
public class LinkList <T> implements Iterable<T>{
    //定义头结点
    private Node head;
    //记录链表长度
    private int N;


    //定义结点
    private class Node{
        //存储数据
        public T item;
        //指向下一个结点
        public Node next;

        public Node(T item, Node next){
            this.item=item;
            this.next=next;
        }
    }
    //初始化结点
    public LinkList(){
        this.head=new Node(null,null);
        this.N=0;
    }
    /**
     * 清空链表
     */
    public void clear(){
        head.next = null;
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
     * 获取长度
     * @return
     */
    public int length(){
        return N;
    }
    /**
     * 查找某个位置上的元素
     * @param i
     * @return
     */
    public T get(int i){
        Node n =head.next;
        for(int index=0;index<i;index++){
            n=n.next;
        }
        return n.item;
    }
    /**
     * 尾插法
     * @param t
     */
    public void insert(T t){
        //找到当前元素的最后一个节点
        Node n=head;
        while(n.next!=null){
            n=n.next;
        }
        //创建新节点，保存元素t
        Node newNode = new Node(t, null);
        //让当前最后一个节点指向新的结点
        n.next=newNode;
        //元素的个数+1
        N++;
    }
    /**
     * 链表中某个结点后插入
     * @param i
     * @param t
     */
    public void insert(int i,T t){
        //找到i位置前一个结点
        Node pre=head;
        for(int index=0;index<i-1;index++){
            pre=pre.next;
        }
        //找到i位置的结点
        Node curr = pre.next;
        //创建新的结点,并且新的结点需要指向原来i位置的结点
        Node newNode = new Node(t, curr);
        //原来i位置的前一个结点指向新节点皆可
        pre.next = newNode;

        //元素的个数+1
        N++;
    }
    /**
     * 删除链表结点
     * @param i
     * @return
     */
    public T remove(int i){
        Node pre = head;
        //找到i位置的前一个结点
        for(int index=0;index<i-1;index++){
            pre=pre.next;
        }
        //找到i位置的结点
        Node curr = pre.next;
        //找到i位置的下一个结点
        Node currNext = curr.next;
        pre.next = pre.next.next;
        //元素的个数-1
        N--;
        return curr.item;
    }
    /**
     * 索引某一个值的位置
     * @param t
     * @return
     */
    public int indexOf(T t){
        Node n = head;
        for(int index=0;n.next!=null;index++){
            n=n.next;
            if(n.item.equals(t)){
                return index;
            }
        }
        return -1;
    }


    /**
     * 反转整个链表
     */
    public void reverse(){
        if(isEmpty()){
            return;
        }
        reverse(head.next);
    }

    /**
     * 反转指定结点
     * @param curr
     */
    public Node reverse(Node curr){
        if(curr.next==null){
            head.next=curr;
            return curr;
        }
        //递归的反转当前节点的下一个结点
        Node pre = reverse(curr.next);
        pre.next=curr;
        curr.next=null;
        return curr;
    }

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }
    private class LIterator implements Iterator{

        private Node n;

        public LIterator(){
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
