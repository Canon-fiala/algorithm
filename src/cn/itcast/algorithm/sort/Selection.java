package cn.itcast.algorithm.sort;

/**
 * 2.选择排序
 * 比较次数 N^2/2-N/2
 * 交换次数 N-1     和为N^2/2+N/2-1
 * 时间复杂度为 O(n^2)
 */
public class Selection {

//    public static void sort(Integer[] a){
//        int temp = 0;
//        for(int i=0;i< a.length-1;i++){
//            for(int j=i+1;j<a.length;j++){
//                if(a[i]>a[j]){
//                    temp = a[i];
//                    a[i] = a[j];
//                    a[j] = temp;
//                }
//            }
//        }
//    }

    /**
     *
     * @param a
     */
    public static void sort(Comparable[] a){
        for(int i=0;i<a.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<a.length;j++){
                if(greater(a[minIndex],a[j])){
                    minIndex = j;
                }
            }
            exch(a,i,minIndex);
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
