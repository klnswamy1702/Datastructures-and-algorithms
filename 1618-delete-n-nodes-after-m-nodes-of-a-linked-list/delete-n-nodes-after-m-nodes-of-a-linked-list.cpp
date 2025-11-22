/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* deleteNodes(ListNode* head, int m, int n) {
        ListNode* currentNode = head;
        ListNode* lastMNode = head;
        while (currentNode != nullptr) {
            // initialize mCount to m and nCount to n
            int mCount = m, nCount = n;
            // traverse m nodes
            while (currentNode != nullptr && mCount != 0) {
                lastMNode = currentNode;
                currentNode = currentNode->next;
                mCount--;
            }
            // traverse n nodes
            while (currentNode != nullptr && nCount != 0) {
                currentNode = currentNode->next;
                nCount--;
            }
            // delete n nodes
            lastMNode->next = currentNode;
        }
        return head;    
    }
};