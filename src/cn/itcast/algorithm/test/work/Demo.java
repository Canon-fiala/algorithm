package cn.itcast.algorithm.test.work;

import java.util.*;

/**
 * @Author luojin
 * @Date 2022/8/22 8:40
 * @Description: TODO
 */
public class Demo {

    public static void main(String[] args) {
        // 开始时间
        long stime = System.currentTimeMillis();
        List<Integer> integers = new ArrayList<>();
        integers.add(new Integer(1));
        integers.add(new Integer(2));
        integers.add(new Integer(3));
        integers.add(new Integer(4));
        integers.add(new Integer(5));
        integers.add(new Integer(1));
        integers.add(new Integer(6));
        List<List<Integer>> arr = getAllArr(integers);
        HashMap<List<Integer>,Integer> back = back(arr, 10);
        Set<Map.Entry<List<Integer>,Integer>> sets = back.entrySet();		//获取HashMap键值对

        for(Map.Entry<List<Integer>,Integer> set:sets){				//遍历HashMap键值对
            System.out.println("Key:"+set.getKey()+"    value:"+set.getValue());
        }
        // 结束时间
        long etime = System.currentTimeMillis();
        // 计算执行时间
        System.out.printf("执行时长：%d 毫秒.", (etime - stime));
    }


    /**
     * 求出所有子集和
     * @param list
     * @return
     */
    public static List<List<Integer>> getAllArr(List<Integer> list) {
        if(list.size()>0){//当数组长度大于0时才进行子集获取
            List<List<Integer>> result = new ArrayList<>();
            long n = (long) Math.pow(2, list.size());//集合的子集数量  2的数组长度次方
            List<Integer> temp;
            for (long l = 0L; l < n; l++) {//遍历出的子集的个数
                temp = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    if ((l >>> i & 1) == 1) {
                        temp.add(list.get(i));//用一个List<Integer>来装每个子集中的元素
                    }
                }
                if (!temp.isEmpty()) result.add(temp);//当获取到的子集不为空时就放入返回结果中
            }
            return result;
        }
        return null;
    }

    /**
     * 对每个子集求和，并与目标值比较
     * @param list
     * @param target
     * @return
     */
    public static HashMap<List<Integer>, Integer> back(List<List<Integer>> list, Integer target){
        List<List<Integer>> lists = new ArrayList<>();
        HashMap<List<Integer>,Integer> objects = new HashMap<>();
        Integer sum=new Integer(0);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> integers = list.get(i);
            for (int i1 = 0; i1 < integers.size(); i1++) {
                sum+=integers.get(i1);
                if((sum-target)>0) {
                    objects.put(integers,sum);
                }
            }
            sum=0;
        }
        return objects;
    }


}
