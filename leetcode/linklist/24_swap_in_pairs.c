struct ListNode* swapPairs(struct ListNode* head) {
   struct ListNode* dummy = (struct ListNode*)malloc(sizeof(struct ListNode));
    dummy->next = head;
    temp = dummy;
    temp1 = head;
    temp2 = head->next;
    while (temp->next->next->next != NULL) {
        temp = temp->next->next;
    }
    while(temp1->next != NULL && temp2->next != NULL) {
        temp2 = temp->next;
        temp1 = temp2->next;
        
    }
    return dummy->next;
}
