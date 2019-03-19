import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
	public static void main(String[] args) {
		//System.out.println("Please enter the length of array:");
		//Scanner scanner = new Scanner(System.in); 
		int len = 100;
		int a[] = new int [len];
		//System.out.println("Please enter the numbers you want to sort");
		for (int i = 0; i < len; i ++) {
			a[i] = (int)(Math.random() * 100) + 1;
		}
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}
	
	public static int partition(int[] a, int left, int right) {
		int i = left, j = right;
		int tmp = a[left];
		while (i < j) {
			while (i < j && a[j] > tmp) {
				j--;
			}
			if (i < j) {
				a[i] = a[j];
				i++;
			}
			while (i < j && a[i] < tmp) {
				i++;
			}
			if (i < j) {
				a[j] = a[i];
				j--;
			}
		}
		a[i] = tmp;
		return i;
	}
	
	public static void quickSort(int[] a, int left, int right) {
		if (left > right)
			return;
		int j = partition(a, left, right);
		quickSort(a, left, j - 1);
		quickSort(a, j + 1, right);
	}

}
