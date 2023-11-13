package cn.itcast.algorithm.graph;

import cn.itcast.algorithm.queue.Queue;

/**
 * 图_无向图实现
 */
public class Graph {
    //记录顶点数量
    private final int v;
    //记录边的数量
    private int E;
    //邻接表
    private Queue<Integer>[] adj;

    public Graph(int v){
        this.v=v;
        this.E=0;
        this.adj = new Queue[v];

        for(int i=0;i<adj.length;i++){
            adj[i]=new Queue<Integer>();
        }
    }

    /**
     * 获取图中的顶点数
     * @return
     */
    public int v(){
        return v;
    }

    /**
     * 获取图中的边的数量
     * @return
     */
    public int E(){
        return E;
    }

    /**
     * 向图中添加一条边v-w
     * @param v
     * @param w
     */
    public void addEdge(int v,int w){
        //在无向图中，边是没有方向的

        adj[v].enqueue(w);
        adj[w].enqueue(v);
        E++;
    }

    /**
     * 获取和顶点V相邻的所有顶点
     * @param v
     * @return
     */
    public Queue<Integer> adj(int v){
        return adj[v];
    }
}
