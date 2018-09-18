struct ListNode* reverseBetween(struct ListNode* head, int m, int n)
{
    int len = n - m + 1;
    if (len == 1) {
        return head;
    }

    struct ListNode dummy;
    struct ListNode *p = head;
    struct ListNode *prev = &dummy;
    prev->next = p;
    while (--m > 0) {
        prev = p;
        p = p->next;
    }

    struct ListNode *q = p->next;
    while (--len > 0) {
        p->next = q->next;
        q->next = prev->next;
        prev->next = q;
        q = p->next;
    }
    return dummy.next;
}
