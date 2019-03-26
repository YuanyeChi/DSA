import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;

import javax.sound.sampled.LineListener;

import org.omg.CORBA.PUBLIC_MEMBER;
//堆说白了就是完全二叉树，每个节点的值大于等于其左右节点的值，称为大顶堆；每个结点的值小于或等于其左右节点的值，称为小顶堆;
//堆就是完全二叉树的节点实现了comparable接口，也就是说，一个可以自我调整的完全二叉树。
//其实堆排序的核心就在于建堆(heapify)
public class HeapSort {
	static int len;
	public static void main(String[] args) {
		System.out.println("Please enter the length of array:");
		Scanner scanner = new Scanner(System.in); 
		int len = scanner.nextInt();
		int a[] = new int [len];
		System.out.println("Please enter the numbers you want to sort");
		for (int i = 0; i < len; i ++) {
			a[i] = scanner.nextInt();
		}
		heapSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}
	
	public static void heapSort(int[] a, int left, int right) {
		biuldMaxHeap(a);
		
		for (int i = a.length - 1; i > 0; i--) {
	        swap(a, 0, i);
	        len--;
	        heapify(a, 0);
	    }
	}

	public static void biuldMaxHeap(int[] a) {
	    len = a.length;
		for (int i = len / 2; i >= 0; i--) {
			heapify(a, i);
		}
	}
	
	public static void heapify(int[] a, int i) {
		int left = i * 2 + 1;
		int right = left + 1;
		int largest = i;
		if (left < len && a[left] > a[largest]) {
			largest = left; // 注意是交换节点
		}
		
		if (right < len ) {
			if (a[right] > a[largest]) {
			largest = right; // 注意是交换节点
		}
		}
		
		if (largest != i) {
			swap(a, i, largest);
			heapify(a, largest);
		}
	}
	
	private static void swap(int[] a, int i, int j) {
		 int temp = a[i];
		 a[i] = a[j];
		 a[j] = temp;
	}
}
