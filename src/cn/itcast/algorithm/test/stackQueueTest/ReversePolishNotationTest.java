package cn.itcast.algorithm.test.stackQueueTest;

import cn.itcast.algorithm.linear.Stack;

public class ReversePolishNotationTest {
    public static void main(String[] args) {
        //中缀表达式3*(17-15)+18/6=9的逆波兰表达式如下
        String[] notation = {"3","17","15","-","*","18","6","/","+"};
        int result = caculate(notation);
        System.out.println("逆波兰表达式的结果为："+result);
    }

    /**
     *
     * @param notation 逆波兰表达式的数组表示方法
     * @return 逆波兰表达式的返回结果
     */
    public static int caculate(String[] notation){
        //1.定义一个栈，存储操作数
        Stack<Integer> oprands = new Stack<>();
        //遍历逆波兰表达式，得到每个元素
        for(int i=0;i<notation.length;i++){
            String curr = notation[i];
            //判断当前元素是运算符还是操作符
            Integer o1;
            Integer o2;
            switch (curr){
                case "+":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    oprands.push(o2+o1);
                    break;
                case "-":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    oprands.push(o2-o1);
                    break;
                case "*":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    oprands.push(o2*o1);
                    break;
                case "/":
                    o1 = oprands.pop();
                    o2 = oprands.pop();
                    oprands.push(o2/o1);
                    break;
                default://操作数存入栈
                    oprands.push(Integer.parseInt(curr));
                    break;
            }
        }
        return oprands.pop();
    }
}
