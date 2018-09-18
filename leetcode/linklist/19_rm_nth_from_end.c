struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
	struct ListNode* dummy = (struct ListNode*)malloc(sizeof(struct ListNode));
	struct ListNode* temp = (struct ListNode*)malloc(sizeof(struct ListNode));
	int length = 0;
	dummy->next = head;
	temp = head;
	while (temp != NULL) {
		temp = temp->next;
		length++;
	}
	length -= n;
	temp = dummy;
	while (length != 0) {
		length--;
		temp = temp->next;
	}
	temp->next = temp->next->next;
	return dummy->next;    
}
