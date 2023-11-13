package cn.itcast.algorithm.test.treeTest;

import cn.itcast.algorithm.queue.Queue;
import cn.itcast.algorithm.tree.BinaryTree;

public class BinaryTreeErgodicTest {
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

        //前序遍历
        System.out.println("前序遍历--------------------------");
        Queue<String> keys1 = tree.preErgodic();
        for (String key:keys1){
            String value = tree.get(key);
            System.out.println(key+"----"+value);
        }

        //中序遍历
        System.out.println("中序遍历--------------------------");
        Queue<String> keys2 = tree.midErgodic();
        for (String key:keys2){
            String value = tree.get(key);
            System.out.println(key+"----"+value);
        }

        //前序遍历
        System.out.println("后序遍历--------------------------");
        Queue<String> keys3 = tree.afterErgodic();
        for (String key:keys3){
            String value = tree.get(key);
            System.out.println(key+"----"+value);
        }

        //层序遍历
        System.out.println("层序遍历--------------------------");
        Queue<String> keys4 = tree.layerErgodic();
        for (String key:keys4){
            String value = tree.get(key);
            System.out.println(key+"----"+value);
        }
    }
}
