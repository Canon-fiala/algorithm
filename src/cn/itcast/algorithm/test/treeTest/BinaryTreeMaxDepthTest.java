package cn.itcast.algorithm.test.treeTest;

import cn.itcast.algorithm.tree.BinaryTree;

public class BinaryTreeMaxDepthTest {
    public static void main(String[] args) {
        BinaryTree<String, String> tree = new BinaryTree<>();

        tree.put("E","5");
        tree.put("B","2");
        tree.put("G","7");
        tree.put("A","1");
        tree.put("D","4");
        tree.put("F","6");
        tree.put("H","8");
        tree.put("C","3");

        int max = tree.maxDepth();
        System.out.println(max);
    }
}
