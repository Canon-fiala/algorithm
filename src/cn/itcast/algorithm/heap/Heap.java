package cn.itcast.algorithm.heap;

public class Heap<T extends Comparable>{
    
    private T[] item;
    private int N;
    
    public Heap(int capacity){
        this.item = (T[]) new Comparable[capacity+1];
        this.N=0;
    }

    /**
     * 判断i索引处的值是否小于j索引处的值
     * @param i
     * @param j
     * @return
     */
    public boolean less(int i,int j){
        return item[i].compareTo(item[j])<0;
    }

    /**
     * 交换i堆中i索引处的值和j索引处的值
     * @param i
     * @param j
     */
    public void exch(int i,int j){
        T temp =item[j];
        item[j] = item[i];
        item[i] = temp;
    }

    /**
     * 删除堆中最大的元素，并返回这个最大的元素
     * @return
     */
    public T delMax(){
        T max = item[1];

        //交换索引1处的元素和最大索引处(最后面的元素)的元素，让完全二叉树中最右侧的元素变为临时根结点
        exch(1,N);
        //最大索引处的元素删除掉
        item[N] = null;
        //元素个数-1
        N--;
        //通过下沉调整堆，让堆重新有序
        sink(1);
        return max;
    }

    /**
     * 往堆中插入一个元素
     * @param t
     */
    public void insert(T t){
        item[++N] = t;
        swim(N);
    }

    /**
     * 使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
     * @param k
     */
    private void swim(int k){
        //通过循环，不断的比较当前结点的值和其父节点的值，如果发现父节点的值比当前结点的值小，则交换位置
        while(k>1){
            //运用上面写的less方法比较当前结点和父节点的值
            if(less(k/2,k)){
                exch(k/2,k);
            }
            k=k/2;
        }
    }

    /**
     * 使用下沉算法，是索引k处的元素能在堆中处于一个正确的位置
     * @param k
     * @return
     */
    private void sink(int k){
        //通过循环不断的对比当前k结点和其左子结点2*k以及其右子结点2k+1处中的较大值的元素大小，如果当前结点小，则需要交换位置
        while(2*k<=N){
            //获取当前结点的子节点中的较大结点
            int max;
            if(2*k+1<=N){
                if(less(2*k,2*k+1)){
                    max=2*k+1;
                }else{
                    max=2*k;
                }
            }else{
                max=2*k;
            }
            // 比较当前结点和较大结点的值
            if(!less(k,max)){
                break;
            }
            //交换k索引处的值和max索引处的值
            exch(k,max);
            //交换k的值
            k=max;
        }
    }
}
