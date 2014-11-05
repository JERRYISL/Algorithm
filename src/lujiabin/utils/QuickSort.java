package lujiabin.utils;

/**
 * 快速排序
 * @author lujiabin
 * @since 2014年11月5日
 */
public class QuickSort {
	public static void quickSort(int[] a,int left,int right){
		int i = left;
		int j = right;
		int temp = a[left];
		
		while(i<j){
			while(i<j && a[j] >= temp){
				j--;
			}
			if(i<j){
				a[i] = a[j];
			}
			while(i<j && a[i] <= temp){
				i++;
			}
			if(i<j){
				a[j] = a[i];
			}
		}
		a[i] = temp;
		if(i-left>1){
			quickSort(a, left, i-1);
		}
		if(right-j>1){
			quickSort(a, j+1, right);
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,3,5,7,9,2,4,6,8};
		quickSort(a, 0, 8);
		
		for(int i : a){
			System.out.println(i);
		}
	}

}
