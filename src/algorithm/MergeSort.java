package algorithm;

import java.util.Arrays;

/**
 * 归并排序 时间复杂度：O(nlogn)
 * @author lujiabin
 * @since 2014-11-10
 */
public class MergeSort {
	public static int[] sort(int[] arrs){
        if(arrs.length < 2){
            return arrs;
        }
        int middle = arrs.length % 2 == 0 ? arrs.length / 2 : (arrs.length - 1) / 2;
        int[] left = Arrays.copyOfRange(arrs, 0, middle);
        int[] right = Arrays.copyOfRange(arrs, middle, arrs.length);
        int[] lres = sort(left);
        int[] rres = sort(right);
        return merge(lres, rres);
    }
 
    private static int[] merge(int[] lres, int[] rres) {
        int[]  res = new int[lres.length + rres.length];
        int l = 0;
        int r = 0;
        int c = 0;
        while(l < lres.length && r < rres.length){
            if(lres[l] < rres[r]){
                res[c++] = lres[l++];
            } else {
                res[c++] = rres[r++];
            }
        }
        if(l == lres.length){
            while(r < rres.length){
                res[c++] = rres[r++];
            }
            return res;
        }
        if(r == rres.length){
            while(l < lres.length){
                res[c++] = lres[l++];
            }
            return res;
        }
        return res;
    }

	public static void main(String[] args) {
		int[] data = { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
		System.out.println(Arrays.toString(data));
		System.out.println(Arrays.toString(sort(data)));
	}

}
