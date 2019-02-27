import java.util.Scanner;
import java.util.*;

public class MergeSort {

	public static void main(String[] args) {
		System.out.println("Please enter the length of array:");
		Scanner scanner = new Scanner(System.in); 
		int len = scanner.nextInt();
		int a[] = new int [len];
		for (int i = 0; i < len; i ++) {
			a[i] = scanner.nextInt();
		}
		mergeSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}
	public static void mergeSort(int[] a, int p, int r) {
		int q = (p + r)/2;
		if (p < r) {
			mergeSort(a, p, q);
			mergeSort(a, q + 1, r);
			merge(a, p, q, r);
			System.out.println(Arrays.toString(a));
		}
	}
	public static void merge(int[] a, int p, int q, int r) {
		int[] temp = new int[r - p + 1];
		int i = p;
		int j = q + 1;
		int k = 0;
		while (i <= q && j <= r) {
			if (a[i] < a[j]) {
				temp[k++] = a[i++];
			}
			else {
				temp[k++] = a[j++];
			}
		}
		while (i <= q) {
			temp[k++] = a[i++];
		}
		while (j <=r) {
			temp[k++] = a[j++];
		}
		for (int k2 = 0; k2 < temp.length; k2++) {
			a[k2 + p] = temp[k2];
		}	
	}
}
