package cn.itcast.algorithm.symbol;

/**
 * 符号表
 * @param <Key>
 * @param <Value>
 */
public class SymbolTable<Key,Value> {

    private Node head;
    private int N;

    /**
     * 构造方法，初始化
     */
    public SymbolTable(){
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
        //符号表中已经存在了键为key的键值对，那么只需要找到该节点，替换为value即可
        Node n = head;
        while(n.next!=null){
            n=n.next;
            if(n.key.equals(key)){
                n.value=value;
                return;
            }
        }
        //如果符号表中不存在键为key的键值对，只需要创建新的结点，保存要插入的键值对，把新结点插入到链表的头部，head.next=新结点即可
        Node newNode = new Node(key,value,null);
        Node oldFirst=head.next;
        newNode.next=oldFirst;
        head.next=newNode;
        N++;
        //元素个数+1
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

        public Node(Key key,Value value,Node next){
            this.key = key;
            this.value=value;
            this.next=next;
        }
    }
}
