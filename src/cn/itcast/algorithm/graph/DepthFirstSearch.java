package cn.itcast.algorithm.graph;

/**
 * 深度优先搜索
 */
public class DepthFirstSearch {
    //索引代表顶点
    private boolean[] marked;
    //值代表当前顶点是否已经被搜索
    private int count;

    /**
     * 构造函数优先搜索对象，使用深度优先搜索找出G图中s顶点的所有相邻的顶点
     * @param G
     * @param s
     */
    public DepthFirstSearch(Graph G,int s){
        //初始化marked数组
        this.marked=new boolean[G.v()];
        //初始化顶点S相通的顶点的数量
        this.count=0;

        dfs(G,s);
    }

    /**
     * 使用深度优先搜索找出G图中v顶点的所有相通顶点
     * @param G
     * @param v
     */
    private void dfs(Graph G,int v){
        marked[v] = true;

        for (Integer w : G.adj(v)) {
            //判断当前w顶点有没有被搜索过，如果没有被搜索过则递归调用dfs方法进行深度搜索
            if(!marked[w]){
                dfs(G,w);
            }
        }
        //相通顶点数量+1
        count++;
    }

    /**
     * 判断w顶点与s顶点是否相同
     * @param w
     * @return
     */
    public boolean marked(int w){
        return marked[w];
    }

    /**
     * 获取与顶点相同的所有顶点的总数
     * @return
     */
    public int count(){
        return count;
    }
}
