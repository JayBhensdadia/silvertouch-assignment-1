package Advanced_Data_Structures;

public class SegmentTree {

    private int[] segmentTree;
    private int[] originalArray;
    private int size;

    public SegmentTree(int[] array) {
        originalArray = array;
        size = array.length;
        
        segmentTree = new int[2 * nextPowerOfTwo(size) - 1];
        buildSegmentTree(0, 0, size - 1);
    }

    private int nextPowerOfTwo(int n) {
        int power = 1;
        while (power < n) {
            power <<= 1; 
        }
        return power;
    }

    private void buildSegmentTree(int index, int start, int end) {
        if (start == end) {
            segmentTree[index] = originalArray[start];
            return;
        }

        int mid = start + (end - start) / 2;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        buildSegmentTree(leftChild, start, mid);
        buildSegmentTree(rightChild, mid + 1, end);

        segmentTree[index] = segmentTree[leftChild] + segmentTree[rightChild];
    }

    public int rangeQuery(int queryStart, int queryEnd) {
        return rangeQuery(0, 0, size - 1, queryStart, queryEnd);
    }

    private int rangeQuery(int index, int start, int end, int queryStart, int queryEnd) {
        if (queryStart <= start && queryEnd >= end) {
           
            return segmentTree[index];
        } else if (queryEnd < start || queryStart > end) {
            
            return 0;
        }

        
        int mid = start + (end - start) / 2;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        int leftSum = rangeQuery(leftChild, start, mid, queryStart, queryEnd);
        int rightSum = rangeQuery(rightChild, mid + 1, end, queryStart, queryEnd);

        return leftSum + rightSum;
    }

    public void update(int arrayIndex, int newValue) {
        update(0, 0, size - 1, arrayIndex, newValue);
    }

    private void update(int index, int start, int end, int arrayIndex, int newValue) {
        if (start == end) {
            
            originalArray[arrayIndex] = newValue;
            segmentTree[index] = newValue;
        } else {
            int mid = start + (end - start) / 2;
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;

            if (arrayIndex <= mid) {
                
                update(leftChild, start, mid, arrayIndex, newValue);
            } else {
                
                update(rightChild, mid + 1, end, arrayIndex, newValue);
            }

            
            segmentTree[index] = segmentTree[leftChild] + segmentTree[rightChild];
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11};

        SegmentTree segmentTree = new SegmentTree(array);

        
        System.out.println("Sum in range [1, 4]: " + segmentTree.rangeQuery(1, 4));

        
        segmentTree.update(2, 6);

        
        System.out.println("Updated sum in range [1, 4]: " + segmentTree.rangeQuery(1, 4));
    }
}

