

public class PriorityQueueUsingHeap {

    private int[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public PriorityQueueUsingHeap() {
        heap = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public void insert(int value) {
        if (size == heap.length - 1) {
            resizeHeap();
        }

        size++;
        heap[size] = value;
        int currentIndex = size;

        
        while (currentIndex > 1 && heap[currentIndex] < heap[currentIndex / 2]) {
            swap(currentIndex, currentIndex / 2);
            currentIndex = currentIndex / 2;
        }
    }

    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Priority queue is empty");
        }

        int min = heap[1];
        heap[1] = heap[size];
        size--;

        
        int currentIndex = 1;
        while (2 * currentIndex <= size) {
            int leftChild = 2 * currentIndex;
            int rightChild = 2 * currentIndex + 1;
            int smallerChildIndex = (rightChild > size || heap[leftChild] < heap[rightChild]) ? leftChild : rightChild;

            if (heap[currentIndex] > heap[smallerChildIndex]) {
                swap(currentIndex, smallerChildIndex);
                currentIndex = smallerChildIndex;
            } else {
                break;
            }
        }

        return min;
    }

    private void resizeHeap() {
        int[] newHeap = new int[heap.length * 2];
        System.arraycopy(heap, 1, newHeap, 1, size);
        heap = newHeap;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public static void main(String[] args) {
        PriorityQueueUsingHeap priorityQueue = new PriorityQueueUsingHeap();

        priorityQueue.insert(10);
        priorityQueue.insert(5);
        priorityQueue.insert(20);
        priorityQueue.insert(2);

        System.out.println("Extracted Min: " + priorityQueue.extractMin()); // Should print 2
        System.out.println("Extracted Min: " + priorityQueue.extractMin()); // Should print 5

        priorityQueue.insert(8);

        System.out.println("Extracted Min: " + priorityQueue.extractMin()); // Should print 8
    }
}
