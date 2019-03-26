#include <stdio.h>
#include <stdlib.h>
#include <time.h>

typedef struct {
    int info;
} DATA;

typedef struct node {
    DATA data;
    struct node *next;
    struct node *pre;
} NODE;

void init(NODE** head) {
    *head = NULL;//head = NULL
}

void print_list(NODE* head) {
    NODE* temp;
    for (temp = head; temp; temp = temp->next)
        printf("%5d", temp->data.info);
}

NODE* add(NODE* node, DATA data) {
    NODE* temp = (NODE*) malloc(sizeof (NODE));
    if (temp == NULL) {
        exit(0);
    }
    temp->data = data;
    temp->next = node;
	temp->pre = NULL;
	if (node != NULL) {
		node->pre = temp;
	}
	node = temp;
    return node;
}

void add_at(NODE* node, DATA data) {
    NODE* temp = (NODE*) malloc(sizeof (NODE));
    if (temp == NULL) {
        exit(EXIT_FAILURE);
    }
    temp->data = data;
	temp->next = node;
	temp->pre = node->pre;
	node->pre->next = temp;
	node->pre = temp;
	
	
}

void remove_node(NODE* node) {
    NODE* temp = (NODE*) malloc(sizeof (NODE));
    temp = node;//内存泄漏
	node->pre->next = node->next;
	node->next->pre = node->pre;
	free(temp); 
}

NODE* reverse(NODE* node) {
    NODE* temp;
    NODE* previous = NULL;
    while (node != NULL) {
        temp = node->next;
        node->pre = node->next;
        node->next = previous;
        previous = node;
        node = temp;
    }
    return previous;
}

NODE* free_list(NODE* head) {
    NODE* temp = head;
    NODE* follow;
    while (temp != NULL) {
        follow = temp;
        temp = temp->next;
        free(follow);
    }
    return NULL;
}

NODE *sort_list(NODE* head) {
    NODE* tmpPtr = head, *tmpNxt = head->next;
    DATA tmp;
    while (tmpNxt != NULL) {
        while (tmpNxt != tmpPtr) {
            if (tmpNxt->data.info < tmpPtr->data.info) {
                tmp = tmpPtr->data;
                tmpPtr->data = tmpNxt->data;
                tmpNxt->data = tmp;
            }
            tmpPtr = tmpPtr->next;
        }
        tmpPtr = head;
        tmpNxt = tmpNxt->next;
    }
    return tmpPtr;
}

int main(int argc, char* argv[]) {
   int i, j;
   NODE* head;
   NODE* node;
   DATA element;
   printf("Add 10 random elements to the linklist:\n");
   init(&head);
   srand((unsigned)time(NULL));
   //add_elements
   for(i = 0; i < 10; i++) {
       element.info = rand() % 10;
       printf("Add Element %2d To The List.\n", element.info);
       head = add(head, element);
   }
   printf("\nPrint the list:\n");
   print_list(head);
   //remove
   printf("\nWhich element do you want to remove?\n");
   scanf("%d", &i);
   node = head;
   while (node->data.info != i) {    
       node = node->next;
   }
   if (node != head)
	   remove_node(node);
   else {
	   NODE *temp = head;
	   head = head->next;
	   free(temp);
   }
   print_list(head);
   //add
   printf("\nWhich place do you want to add a number?\n");
   printf("Please enter a place:");
   scanf("%d", &j);
   printf("please enter a number:");
   scanf("%d", &(element.info));
   node = head;
   while ((j-1) != 0) {
       node = node->next;
       j--;
   }
   if (node == head) {
	   head = add(head,element);
   }
   else{
	   add_at(node, element);
   }
   print_list(head);
   printf("\n");
   head = sort_list(head);
   print_list(head);
   head = reverse(head);
   printf("\n");
   print_list(head);
   head = free_list(head);
   return (EXIT_SUCCESS);
}

