package cn.itcast.algorithm.test;

import cn.itcast.algorithm.symbol.OrderSymbolTable;

public class OrderSymbolTest {
    public static void main(String[] args) {
        OrderSymbolTable<Integer, Object> table = new OrderSymbolTable<>();

        table.put(1,"张三");
        table.put(2,"李四");
        table.put(4,"赵六");
        table.put(7,"田七");
        //断点查看debug测试
        table.put(3,"王五");
    }
}
