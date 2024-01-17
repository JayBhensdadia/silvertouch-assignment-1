Algorithm

* We first take an explicit stack data structure and set an infinite loop.
* In every iteration we check whether our current node is pointing to NULL or not.
* If it is not pointing to null, we simply push the current value to the stack and move the current node to its left child.
* If it is pointing to NULL, we first check whether the stack is empty or not. If the stack is empty, it means that we have traversed the tree and we break out of the loop.
* If the stack is not empty, we pop the top value of the stack, print it and move the current node to its right child.
     */