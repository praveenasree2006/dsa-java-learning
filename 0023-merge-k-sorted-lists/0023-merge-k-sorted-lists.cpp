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
    ListNode* mergeKLists(vector<ListNode*>& lists) { 
        // a minheap of pair {node->val,node->adress}
        priority_queue< pair<int ,ListNode*> , vector<pair<int,ListNode*>> , greater<pair<int,ListNode*>>>  minHeap;

        // store first k element in Minheap
        for(int i = 0 ; i < lists.size() ; i++){
            if( lists[i] ){
                minHeap.push( {lists[i]->val,lists[i]} );
            }   
        }

        // using tail pointer to attach node one by one 
        ListNode dummy(-1);
        ListNode* tail = &dummy;
        while(minHeap.size() > 0){
            auto top = minHeap.top();
            minHeap.pop();
            
            tail->next = top.second;
            tail = tail->next;

            if(top.second->next){
                minHeap.push({top.second->next->val , top.second->next});
            }
        }
        tail->next = nullptr;

        return dummy.next;
    }
};