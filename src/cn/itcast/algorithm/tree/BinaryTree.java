package cn.itcast.algorithm.tree;


import cn.itcast.algorithm.queue.Queue;

public class BinaryTree<Key extends Comparable<Key>,Value>{

    //根节点
    private Node root;
    //记录结点数
    private int N;

    /**
     * 初始化构造方法
     */
    public BinaryTree(){
//        this.root=new Node(null,null,null,null);
//        this.N=1;
    }

    /**
     * 向树中添加元素
     * @param key
     * @param value
     */
    public void put(Key key,Value value){
        root = put(root,key,value);
    }

    /**
     * 向目标数中添加元素
     * @param x
     * @param key
     * @param value
     */
    public Node put(Node x,Key key,Value value){
        //如果x子树为空
        if(x==null){
            N++;
            return new Node(key,value,null,null);
        }
        //如果x子树不为空
            // 比较x结点的键和key的大小
        int cmp = key.compareTo(x.key);

        if(cmp>0) {
            //如果key大于x结点的键，则继续找x结点的右子树
            x.right=put(x.right,key,value);
        }else if(cmp<0){
            //如果key小于x结点的键，则继续找x结点的左子树
            x.left=put(x.left,key,value);
        }else{
            //如果key等于x结点的键，则替换x结点的键为value即可
            x.value=value;
        }
        return x;
    }

    /**
     * 根据键获取元素
     * @param key
     * @return
     */
    public Value get(Key key){
        return get(root,key);
    }

    /**
     * 根据结点和键获取元素
     * @param x
     * @param key
     * @return
     */
    public Value get(Node x,Key key){
        if(x==null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp>0){
            //如果key大于x结点的键，则继续找x结点的右子树
            return get(x.right,key);
        }else if(cmp<0){
            //如果key小于x结点的键，则继续找x结点的左子树
            return get(x.left,key);
        }else{
            //如果key等于x结点的键，则找到了键为key的结点，只需要返回x结点的值即可。
            return x.value;
        }
    }

    /**
     * 根据键删除元素
     * @param key
     */
    public void delete(Key key){
        delete(root,key);
    }

    /**
     * 根据目标结点和键删除元素
     * @param x
     * @param key
     */
    public Node delete(Node x,Key key){
        //x树为null
        if(x==null){
            return null;
        }
        //x树不为null
        int cmp = key.compareTo(x.key);
        if(cmp>0){
            x.right = delete(x.right,key);
        }else if(cmp<0){
            x.left = delete(x.left,key);
        }else{
            //如果key等于x结点的键，完成真正的删除结点动作，要删除的结点就是x；
            N--;
            //得找到右子树的最小的结点
            if(x.right==null){
                return x.left;
            }if(x.left==null){
                return  x.right;
            }

            Node minNode =x.right;
            while(minNode.left!=null){
                minNode=minNode.left;
            }

            //删除右子树的最小结点
            Node n = x.right;
            while(n.left!=null){
                if(n.left.left==null){
                    n.left=null;
                }else{
                    n=n.left;
                }
            }
            //让x的结点的左子树成为minNode结点的左子树
            minNode.left=x.left;
            //让x的结点的右子树成为minNode结点的右子树
            minNode.right=x.right;
            //让x的结点的父节点指向minNode
            x=minNode;
        }
        return x;
    }

    /**
     * 获取树的结点
     * @return
     */
    public int size(){
        return N;
    }

    /**
     * 找出树中最小的键
     * @return
     */
    public Key min(){
        return min(root).key;
    }

    /**
     * 找出指定树x中，最小键所在的结点
     * @param x
     * @return
     */
    public Node min(Node x){
        if(x.left!=null){
            return min(x.left);
        }else{
            return x;
        }
    }
    /**
     * 找出树中最大的键
     * @return
     */
    public Key max(){
        return max(root).key;
    }
    /**
     * 找出指定树x中，最大键所在的结点
     * @param x
     * @return
     */
    public Node max(Node x){
        if(x.right!=null){
            return max(x.right);
        }else{
            return x;
        }
    }

    /**
     * 前序遍历，获取整个树中所有的键
     * @return
     */
    public Queue<Key> preErgodic(){
        Queue<Key> keys = new Queue<>();
        preErgodic(root,keys);
        return keys;
    }

    /**
     * 使用前序遍历，把指定x中的所有键放入keys队列中
     * @param x
     * @param keys
     */
    private void preErgodic(Node x, Queue<Key> keys){
        if(x==null){
            return;
        }
        //把x结点的key放入到keys中
        keys.enqueue(x.key);
        //递归遍历x结点的左子树
        if(x.left!=null){
            preErgodic(x.left,keys);
        }
        //递归遍历x结点的右子树
        if(x.right!=null){
            preErgodic(x.right,keys);
        }
    }

    /**
     * 中序遍历
     * @return
     */
    public Queue<Key> midErgodic(){
        Queue<Key> keys = new Queue<>();
        midErgodic(root,keys);
        return keys;
    }

    /**
     * 中序遍历，把指定树x的所有键放入到keys队列中
     * @param x
     * @param keys
     */
    public void midErgodic(Node x,Queue<Key> keys){
        if(x==null){
            return;
        }
        //递归遍历左子树
        if(x.left!=null){
            midErgodic(x.left,keys);
        }
        //把当前x的key存入队列中
        keys.enqueue(x.key);
        //递归遍历右子树
        if(x.right!=null){
            midErgodic(x.right,keys);
        }
    }

    /**
     * 后序遍历
     * @return
     */
    public Queue<Key> afterErgodic(){
        Queue<Key> keys = new Queue<>();
        afterErgodic(root,keys);
        return keys;
    }

    /**
     * 后序遍历，把指定树x的所有键放入到keys队列中
     * @param x
     * @param keys
     */
    public void afterErgodic(Node x,Queue<Key> keys){
        if(x==null){
            return;
        }
        if(x.left!=null){
            afterErgodic(x.left,keys);
        }
        if(x.right!=null){
            afterErgodic(x.right,keys);
        }
        keys.enqueue(x.key);
    }

    /**
     * 层序遍历
     * @return
     */
    public Queue<Key> layerErgodic(){
        //定义两个队列，分别存储树中的键和结点
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();

        //默认先把根节点放入
        nodes.enqueue(root);
        while(!nodes.isEmpty()){
            //从队列中，弹出结点，把key放入到keys中
            Node n = nodes.dequeue();
            keys.enqueue(n.key);
            //判断当前结点还有没有左子节点，如果有，则放入到nodes中
            if(n.left!=null){
                nodes.enqueue(n.left);
            }
            //判断当前结点还有没有右子结点，如果有，则放入到nodes中
            if(n.right!=null){
                nodes.enqueue(n.right);
            }
        }
        return keys;
    }

    /**
     * 获取整个树的最大深度
     * @return
     */
    public int maxDepth(){
        return maxDepth(root);
    }

    /**
     * 计算指定树的最大深度
     * @param x
     * @return
     */
    public int maxDepth(Node x){
        if(x==null){
            return 0;
        }
        int max=0;
        int maxL=0;
        int maxR=0;
        //计算x结点左子树的最大深度
        if(x.left!=null){
            maxL = maxDepth(x.left);
        }
        //计算x结点右子树的最大深度
        if(x.right!=null){
            maxR = maxDepth(x.right);
        }
        //比较左子树的最大深度和右子树的最大深度，取较大值+1即可
        max = maxL > maxR ? maxL + 1 : maxR + 1;
        return max;
    }


    private class Node{
        private Node left;
        private Node right;
        private Key key;
        private Value value;

        public Node(Key key,Value value,Node left,Node right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
