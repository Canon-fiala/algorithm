package cn.itcast.algorithm.test.stackQueueTest;

import cn.itcast.algorithm.linear.Stack;

/**
 * 括号匹配问题(栈解决)
 */
public class BracketsMatchTest {
    public static void main(String[] args) {
        String str = "(上海(长安)()";
        boolean match = isMatch(str);
        System.out.println(str+"中的括号是否匹配:"+match);
    }

    /**
     * 判断str中的括号是否匹配
     * @param str
     * @return 如果匹配返回true，不匹配返回false
     */
    public static boolean isMatch(String str){
        Stack<String> stack = new Stack<>();

        for(int i=0;i<str.length();i++){
            String s = str.charAt(i)+"";
            if(s.equals("(")){
                stack.push("(");
            }else if(s.equals(")")){
                String pop = stack.pop();
                if (pop==null){
                    return false;
                }
            }else{
                continue;
            }
        }
        if(stack.size()==0){
            return true;
        }
        return false;
    }
}
