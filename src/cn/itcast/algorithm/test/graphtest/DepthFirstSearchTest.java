package cn.itcast.algorithm.test.graphtest;

import cn.itcast.algorithm.graph.DepthFirstSearch;
import cn.itcast.algorithm.graph.Graph;

public class DepthFirstSearchTest {
    public static void main(String[] args) {
        //准备Graph对象
        Graph graph = new Graph(13);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,6);
        graph.addEdge(6,4);
        graph.addEdge(4,3);
        graph.addEdge(4,5);
        graph.addEdge(3,5);
        graph.addEdge(0,5);

        graph.addEdge(7,8);

        graph.addEdge(9,10);
        graph.addEdge(9,12);
        graph.addEdge(9,11);
        graph.addEdge(11,12);

        DepthFirstSearch search = new DepthFirstSearch(graph, 0);
        int count = search.count();
        System.out.println("与起点0相通的顶点的数量为:"+count);

        boolean marked1 = search.marked(5);
        System.out.println("顶点5和顶点0是否相通:"+marked1);
        boolean marked2 = search.marked(7);
        System.out.println("顶点5和顶点0是否相通:"+marked2);

    }
}
