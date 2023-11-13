package cn.itcast.algorithm.test.listTest;

import cn.itcast.algorithm.linear.SequenceList;

/**
 * 线性表测试
 * 测试线性表的插入删除，清空，判断为空
 * 测试线性表的遍历
 */
public class SequenceListTest {

    public static void main(String[] args) {
        //创建顺序表对象
        SequenceList<String> seq = new SequenceList<>(10);
        //测试插入
        seq.insert("姚明");
        seq.insert("科比");
        seq.insert("麦迪");
        seq.insert(1,"詹姆斯");

        for(String s:seq){
            System.out.println(s);
        }

        System.out.println("----------------------------------------------------");
        //测试获取
        String getResult = seq.get(1);
        System.out.println("获取索引1处的结果为："+getResult);
        //测试删除
        String removeResult = seq.remove(0);
        System.out.println("删除的元素是:"+removeResult);
        //测试清空
        seq.clear();
        boolean emptyResult = seq.isEmpty();
        System.out.println("判断是否为空："+emptyResult);
    }
}
