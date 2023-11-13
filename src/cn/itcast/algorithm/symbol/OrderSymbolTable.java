package cn.itcast.algorithm.symbol;

/**
 * 有序符号表
 * @param <Key>
 * @param <Value>
 */
public class OrderSymbolTable<Key extends Comparable<Key>,Value> {

    private Node head;
    private int N;

    /**
     * 构造方法，初始化
     */
    public OrderSymbolTable(){
        this.head = new Node(null,null,null);
        this.N=0;
    }
    /**
     * 获取大小
     * @return
     */
    public int size(){
        return N;
    }
    /**
     * 获取值
     * @param key
     * @return
     */
    public Value get(Key key){
        Node n = head;
        while(n.next!=null){
            n=n.next;
            if(n.key.equals(key)){
                return (Value) n.value;
            }
        }
        return null;
    }

    /**
     * 插入值
     * @param key
     * @param value
     */
    public void put(Key key,Value value){
        //定义两个Node变量，分别记录当前节点和当前结点的上一个结点
        Node curr = head.next;
        Node pre = head;
        while (curr!=null&&key.compareTo(curr.key)>0){
            //变换当前结点和前一个结点即可
            pre=curr;
            curr=curr.next;
        }
        if(curr!=null&&key.compareTo(curr.key)==0){
            //如果当前结点curr的键和要插入的key一样，则替换
            curr.value=value;
            return;
        }
        //如果当前结点curr的键和要插入的key不一样，则把新的结点插入到curr之前
        Node newNode = new Node(key, value, curr);
        pre.next=newNode;
        N++;
    }

    /**
     *
     * @param key
     */
    public void delete(Key key){
        Node n = head;
        while(n.next!=null){
            if(n.next.key.equals(key)){
                n.next=n.next.next;
                N--;
                return;
            }
            //变换n
            n=n.next;
        }
    }

    private class Node{
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next){
            this.key = key;
            this.value=value;
            this.next=next;
        }
    }
}
