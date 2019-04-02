#include <stdio.h>
#include <stdlib.h>
void swap(int num[], int i, int j) {
	int temp = num[i];
	num[i] = num[j];
	num[j] = temp;
}

void MIN_HEAPIFY(int num[], int i, int len){
	int left = 2 * i + 1;
	int right = 2 * i + 2;
	int smallest = i;
	if (left < len && num[left] < num[smallest])
		smallest = left;
	if (right < len && num[right] < num[smallest])
		smallest = right;
	if (smallest != i) {
		swap(num, i, smallest);
		MIN_HEAPIFY(num, smallest, len);
	}
}	


int main() {
	int i;
	int num[] = {98, 48, 777, 63, 57, 433, 23, 1112, 1};	
	printf("原始数据是：\n");
	for(i = 0; i < sizeof(num) / sizeof(int); i++)
	{
		printf("%d ", num[i]);
	}
	printf("\n请输入i:");
	
	scanf("%d", &i);
	MIN_HEAPIFY(num, i, sizeof(num) / sizeof(int));
	printf("MIN_HEAPIFY后的数据是：\n");
	for(i = 0; i < sizeof(num)/sizeof(int); i++)
	{
		printf("%d ", num[i]);
	}
	printf("\n");
	return 0;
}
