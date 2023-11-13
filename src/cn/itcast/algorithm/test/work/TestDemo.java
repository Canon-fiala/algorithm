package cn.itcast.algorithm.test.work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @Author luojin
 * @Date 2022/8/22 8:41
 * @Description: TODO
 */
public class TestDemo {
//
//    public static void main(String[] args){
//        Random r = new Random();
//        ArrayList<Double> nums =  new ArrayList<>();
//        nums.add(8.05);nums.add(6.98);nums.add(6.19);nums.add(5.0);nums.add(22.96);nums.add(4.71);nums.add(4.74);nums.add(4.25);
//        nums.add(6.34);nums.add(2.77);nums.add(7.31);nums.add(3.59);nums.add(19.55);
//        TestDemo m = new TestDemo();
//        ArrayList<Double> res = m.MC_combination(nums,84.01);
//        double sum = 0;
//        for (int i=0;i<res.size();i++) {
//            System.out.println(res.get(i));
//            sum = sum + res.get(i);
//        }
//        System.out.println(sum);
//        System.out.println(Math.abs(sum - 84.01));
//    }
//
//    public ArrayList<List<Double>> MC_combination(ArrayList<Double> nums, double target)
//    {
////        ArrayList<List<>>
//        ArrayList<Double> res = new ArrayList<>();
//        double lapse = 10000;
//        Random random = new Random();
//
//        for (int i=0;i<1000000;i++)
//        {
//            if(i%10000==0)
//                System.out.println(i);
//            int numsize = random.nextInt(nums.size()  + 1);
//            ArrayList<Double> ares = new ArrayList<>();
//            HashMap<Integer,Integer> map = new HashMap<>();
//            double thissum = 0;
//            for (int j=0 ;j<numsize;j++)
//            {
//                int anumberindex = random.nextInt(nums.size());
//                while (map.containsKey(anumberindex))
//                {
//                    anumberindex = random.nextInt(nums.size());
//                }
//                map.put(anumberindex,1);
//                ares.add(nums.get(anumberindex));
//                thissum += nums.get(anumberindex);
//            }
//            if(Math.abs(thissum - target)<lapse)
//            {
//                lapse = Math.abs(thissum - target);
//                res = (ArrayList<Double>) ares.clone();
//            }
//            if(lapse<0.000001)
//                break;
//        }
//        return res;
//    }
}
