#include <stdio.h>
#include <stdlib.h>
typedef struct data {
	int info;
} DATA;

typedef struct Node {
    DATA data;
	struct Node* next;
};

struct Node* front = NULL;
struct Node* rear = NULL;

void Enqueue(int x) {
	struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
	temp->data.info = x;
	temp->next = NULL;
	//空
	if(front == NULL && rear == NULL) {
		front = rear = temp;
		return;
	}
	rear->next = temp;
	rear = temp;
}

void Dequeue () {
	struct Node* temp = front;
	if(front == NULL) {
		printf("Queue is empty\n");
		return;
	}
	if(front == rear) {
		front = rear = NULL;
	}
	else {
		front = front->next;
	}
	free(temp);
}

int Front() {
	if (front == NULL) {
		printf("Queue is empty\n");
		return -1;
	}
	return front->data.info;
}

void Print() {
	struct Node* temp = front;
	while(temp != NULL) {
		printf("%d", temp->data.info);
		temp = temp->next;
	}
	printf("\n");
}

int main() {
	Enqueue(2); Print();
	Enqueue(4); Print();
	Enqueue(6); Print();
	Dequeue(); Print();
	Enqueue(8); Print();
}
