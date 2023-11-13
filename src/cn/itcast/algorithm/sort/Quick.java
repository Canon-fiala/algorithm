package cn.itcast.algorithm.sort;

/**
 * 6.快速排序
 * 时间复杂度最优情况为O(nlogn)
 * 平均复杂度最优情况为O(nlogn)
 * 时间复杂度最坏情况为O(n^2)
 */
public class Quick {

    /**
     * 对数组内的元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a){
        int lo = 0;
        int hi = a.length-1;
        sort(a,lo,hi);
    }

    /**
     * 对数组a中从索引lo到索引hi之间的元素进行排序
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a,int lo,int hi){
        while(hi<=lo){
            return;
        }
        //需要对数组中lo索引到hi索引处的元素进行分组(左子组和又子组)
        int partition = partition(a,lo,hi);//返回的是分组的分解值所在的索引，分界值位置变换后的索引。
        //让左子组有序
        sort(a,lo,partition-1);
        //让右子组有序
        sort(a,partition+1,hi);
    }

    /**
     * 对数组a中，从索引lo到索引hi之间的元素进行分组，并返回分组界限对应的索引
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    public static int partition(Comparable[] a,int lo,int hi){
        //确定分解值
        Comparable key = a[lo];
        //定义一个左指针和右指针
        int left = lo;
        int right = hi+1;

        //切分
        while(true){
            //先从右往左扫描，移动right指针，找到一个比分解值小的元素
            while(less(key,a[--right])){
                //判断
                if(right==lo){
                    break;
                }
            }
            //再从左往右扫描，移动lift指针，找到一个比分解值大的元素
            while(less(a[++left],key)){
                if(left==hi){
                    break;
                }
            }
            //判断left>=right，如果是，则证明元素扫描完毕，结束循环，如果不是，则交换元素即可。
            if(left>=right){
                break;
            }else{
                exch(a,left,right);
            }
        }
        //交换分界值
        exch(a,lo,right);
        return right;

    }
    /**
     * 判断v是否大于w
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }

    /**
     * 交换a数组中，索引i和索引j中的值。
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
