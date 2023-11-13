package cn.itcast.algorithm.sort;

/**
 * 3.插入排序
 * 比较次数 N^2/2-N/2
 * 交换次数 N^2/2-N/2    和为 N^2-N
 * 时间复杂度   O(n^2)
 */
public class Insertion {

    public static void sort(Comparable[] a){
        for(int i=1;i<a.length;i++){
            for(int j =i;j>0;j--) {
                //比较索引j处的值和索引j-1处的值，如果索引j-1处的值比索引j处的值大，则交换数据，如果不大，则跳出循环。
                if (greater(a[j - 1], a[j])) {
                    exch(a, j - 1, j);
                }else{
                    break;
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
