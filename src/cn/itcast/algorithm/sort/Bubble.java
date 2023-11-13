package cn.itcast.algorithm.sort;

/**
 * 1、冒泡排序(挨个交换，比较最大值，往后放.)
 * 时间复杂度O(n^2)
 * 比较次数 N^2/2-N/2
 * 交换次数 N^2/2-N/2          比较+交换=N^2-N
 */
public class Bubble {

//    public static void sort(int[] a){
//        int temp = 0;
//        for(int i=a.length-1;i>0;i--){
//            for(int j=0;j<i;j++){
//                if(a[j]>a[j+1]){
//                    temp = a[j];
//                    a[j] = a[j+1];
//                    a[j+1] = temp;
//                }
//            }
//        }
//    }

    /**
     * 对数组a进行排序
     * @param a
     */
    public static void sort(Comparable[] a){
        for(int i=a.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(greater(a[j],a[j+1])){
                    exch(a,j,j+1);
                }
            }
        }
    }

    /**
     * 比较元素v是否大于元素w
     * @param v
     * @param w
     * @return
     */
    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }

    /**
     * 数组元素i和j交换位置
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
