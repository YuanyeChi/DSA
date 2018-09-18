struct ListNode* rotateRight(struct ListNode* head, int k) {
    if (head == NULL) {
        return NULL;
    }
    struct ListNode dummy;
    dummy.next = head;
    int length = 1;
    struct ListNode *first = head;
    struct ListNode *second = head;
    while (first->next != NULL) {
        first = first->next;
        length++;
    }
    k = k % length;
    first->next = head;
    length -= k;
    while(length-- != 1) {
        second = second->next;
    }
    first = second->next;
    second->next = NULL;
    return first;
}
