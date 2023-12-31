package cn.itcast.algorithm.queue;

/**
 * 最大优先队列（堆的思想完成）
 * @param <T>
 */
public class MaxPriorityQueue<T extends Comparable<T>>{

    private T[] items;
    private int N;

    public MaxPriorityQueue(int capacity){
        this.items = (T[])new Comparable[capacity+1];
        this.N=0;
    }

    private boolean less(int i,int j){
        return items[i].compareTo(items[j])<0;
    }

    private void exch(int i,int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public T delMax(){
        T max = items[1];
        exch(1,N);
        N--;
        sink(1);
        return max;
    }

    public void insert(T t){
        items[++N]=t;
        swim(N);
    }

    private void swim(int k){
        while(k>1){
            if(less(k/2,k)){
                exch(k/2,k);
            }

            k=k/2;
        }
    }

    private void sink(int k){
        while(2*k<=N){
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
            if(!less(k,max)){
                break;
            }
            exch(k,max);
            k=max;

        }

    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }
}
