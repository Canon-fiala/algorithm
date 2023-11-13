package cn.itcast.algorithm.test.listTest;

import cn.itcast.algorithm.linear.LinkList;

public class LinkListTest2 {
    public static void main(String[] args) {
        //创建顺序表对象
        LinkList<String> seq = new LinkList<>();
        //测试插入
        seq.insert("姚明");
        seq.insert("科比");
        seq.insert("麦迪");
        seq.insert(1,"詹姆斯");

        for(String s:seq){
            System.out.println(s);
        }

        System.out.println("----------------------------------------------------");
        seq.reverse();
        for(String s:seq){
            System.out.println(s);
        }
    }
}
