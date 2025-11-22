/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * class ImmutableListNode {
 * public:
 *    void printValue(); // print the value of the node.
 *    ImmutableListNode* getNext(); // return the next node.
 * };
 */

class Solution {
public:
    void printLinkedListInReverse(ImmutableListNode* head) {
        stack<ImmutableListNode*> s;
        while (head) {
            s.push(head);
            head = head->getNext();
        }

        while (!s.empty()) {
            ImmutableListNode* node = s.top();
            s.pop();
            node->printValue();
        }
    }
};