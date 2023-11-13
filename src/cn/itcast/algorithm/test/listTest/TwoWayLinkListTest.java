package cn.itcast.algorithm.test.listTest;

import cn.itcast.algorithm.linear.LinkList;
import cn.itcast.algorithm.linear.TwoWayLinkList;

public class TwoWayLinkListTest {
    public static void main(String[] args) {
        //创建顺序表对象
        TwoWayLinkList<String> seq = new TwoWayLinkList<>();
        //测试插入
        seq.insert("姚明");
        seq.insert("科比");
        seq.insert("麦迪");
        seq.insert(1,"詹姆斯");

        for(String s:seq){
            System.out.println(s);
        }

        System.out.println("----------------------------------------------------");

        System.out.println("第一个元素是："+seq.getFirst());
        System.out.println("最后一个元素是:"+seq.getLast());
        System.out.println("-----------------------------------------------------");
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
