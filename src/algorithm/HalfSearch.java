package algorithm;

/**
 * 二分查找 时间复杂度：O(logn)
 * @author lujiabin
 * @since 2014-11-10
 */
public class HalfSearch {
	//折半查找可以提高效率，但必须得保证是有序的数组
	public static int halfSearch(int[] arr, int key) {
		int min, max, mid;
		min = 0;
		max = arr.length - 1;
		mid = (min + max) / 2;

		while (arr[mid] != key) {
			if (key > arr[mid]) {
				min = mid + 1;
			} else if (key < arr[mid]) {
				max = mid - 1;
			}
			if (min > max) // 如果数组中没有所求的数，返回-1
				return -1;
			mid = (min + max) / 2; // 保证函数继续
		}
		return mid;
	}
	
	public static void main(String[] args) {
		int[] arr={6,13,25,33,56,67,89,99,123,387};//必须定义有序的数组
        int key=halfSearch(arr,89);
        System.out.println("key= "+key);
	}

}
