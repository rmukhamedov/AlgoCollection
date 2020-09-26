class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        ListNode *node = head;
        ListNode *prev = NULL;
        
        while (node)
        {
            if (node->val == val)
            {
                if (!prev)
                {
                    head = node->next;
                }
                else
                {
                    prev->next = node->next;
                }
            }
            else
            {
                prev = node;
            }
            
            node = node->next;
        }
        
        return head;
    }
};