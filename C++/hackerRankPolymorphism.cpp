#include <iostream>
#include <vector>
#include <map>
#include <string>
#include <algorithm>
#include <set>
#include <cassert>
using namespace std;

struct Node{
   Node* next;
   Node* prev;
   int value;
   int key;
   Node(Node* p, Node* n, int k, int val):prev(p),next(n),key(k),value(val){};
   Node(int k, int val):prev(NULL),next(NULL),key(k),value(val){};
};

class Cache{
   
   protected: 
   map<int,Node*> mp; //map the key to the node in the linked list
   int cp;  //capacity
   Node* tail; // double linked list tail pointer
   Node* head; // double linked list head pointer
   virtual void set(int, int) = 0; //set function
   virtual int get(int) = 0; //get function

};

// SOLUTION
class LRUCache : public Cache{
    
    private:
    // Inserts at start adding to map and adjusting pointers as neccesary
    void insertStart(Node* toInsert){
        mp.insert({toInsert->key, toInsert});
        
        // Inserting at start next should be head and prev null
        toInsert->next = head;
        toInsert->prev = nullptr;

        // Head Present
        if(head != nullptr) head->prev = toInsert;
        else                tail = toInsert;   
        
        // Replace Head
        head = toInsert;    
    }
    void remove(Node* toRemove){
        
        mp.erase(toRemove->key);
        
        // Deal with next
        if(toRemove->next != nullptr) toRemove->next->prev = toRemove->prev;
        else if(toRemove->next == nullptr) tail = toRemove->prev;

        // Deal with prev
        if(toRemove->prev != nullptr) toRemove->prev->next = toRemove->next;
        else head = toRemove->prev;
    }
    
    public:
    LRUCache(int capacity){cp = capacity;}
    void set(int key, int value){
                
        // Key is already present -> update value move to start
        if(mp.count(key)){
            // Cache node ptr
            Node* toMove = mp[key];
            
            // Update Val
            toMove->value = value; 
            
            // Move to start
            remove(toMove);
            insertStart(toMove);
        }
        // Empty OR !Full -> Insert at start
        else if(mp.size() == 0 || mp.size() < cp) insertStart(new Node(nullptr, nullptr, key, value));
        // Full -> Delete last Element Insert at start
        else {
            // Remove and Delete Tail
            Node* oldTail = tail;
            remove(tail);
            delete oldTail;
            
            insertStart(new Node(nullptr, head, key, value));
        }
    }
    
    int get(int key) 
    { 
        return mp.count(key) == 0 ? -1 : mp[key]->value; 
        }
};
// END SOLUTION

int main() {
   int n, capacity,i;
   cin >> n >> capacity;
   LRUCache l(capacity);
   for(i=0;i<n;i++) {
      string command;
      cin >> command;
      if(command == "get") {
         int key;
         cin >> key;
         cout << l.get(key) << endl;
      } 
      else if(command == "set") {
         int key, value;
         cin >> key >> value;
         l.set(key,value);
      }
   }
   return 0;
}