struct ListNode* deleteDuplicates(struct ListNode* head) {
    struct ListNode dummy;
    struct ListNode *next, *prev, *p;
    prev = &dummy;
    dummy.next = head;
    p = next = head;
    while (p != NULL) {
        while (next != NULL && next->val == p->val) {
            next = next->next;
        }
        if (p->next == next) {
            prev = p;
        } else {
            prev->next = next;
        }
        p = next;
    }
    return dummy.next;
}
