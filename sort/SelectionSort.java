import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
	public static void main(String[] args) {
		System.out.println("Please enter the length of array:");
		Scanner scanner = new Scanner(System.in); 
		int len = scanner.nextInt();
		int a[] = new int [len];
		System.out.println("Please enter the numbers you want to sort");
		for (int i = 0; i < len; i ++) {
			a[i] = scanner.nextInt();
		}
		selectionSort(a);
		System.out.println(Arrays.toString(a));
	}
	
	public static void selectionSort(int[] a) {
		int len = a.length;
		 for (int i = 0; i < len; i++) {
			 int smallest = i;
			 for (int j = i; j < len; j++) {
				 if (a[j] < a[smallest]) {
					 smallest = j;
				 }
			 }
			 if (smallest != i) {
				 int temp = a[smallest];
				 a[smallest] = a[i];
				 a[i] = temp;
			 }
		 }
	} 
}
