package Advanced_Data_Structures;
public class SegmentTreeRangeUpdate {

    private int[] segmentTree;
    private int[] lazy;
    private int[] originalArray;
    private int size;

    public SegmentTreeRangeUpdate(int[] array) {
        originalArray = array;
        size = array.length;
        
        segmentTree = new int[2 * nextPowerOfTwo(size) - 1];
        lazy = new int[2 * nextPowerOfTwo(size) - 1];
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

    public void rangeUpdate(int updateStart, int updateEnd, int delta) {
        rangeUpdate(0, 0, size - 1, updateStart, updateEnd, delta);
    }

    private void rangeUpdate(int index, int start, int end, int updateStart, int updateEnd, int delta) {
        
        if (lazy[index] != 0) {
            segmentTree[index] += lazy[index] * (end - start + 1);

            if (start != end) {
                
                lazy[2 * index + 1] += lazy[index];
                lazy[2 * index + 2] += lazy[index];
            }

            lazy[index] = 0; 
        }

        
        if (updateEnd < start || updateStart > end) {
            return;
        }

        
        if (updateStart <= start && updateEnd >= end) {
            segmentTree[index] += delta * (end - start + 1);

            if (start != end) {
                lazy[2 * index + 1] += delta;
                lazy[2 * index + 2] += delta;
            }

            return;
        }

        
        int mid = start + (end - start) / 2;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        rangeUpdate(leftChild, start, mid, updateStart, updateEnd, delta);
        rangeUpdate(rightChild, mid + 1, end, updateStart, updateEnd, delta);

        segmentTree[index] = segmentTree[leftChild] + segmentTree[rightChild];
    }

    public int rangeQuery(int queryStart, int queryEnd) {
        return rangeQuery(0, 0, size - 1, queryStart, queryEnd);
    }

    private int rangeQuery(int index, int start, int end, int queryStart, int queryEnd) {
        
        if (lazy[index] != 0) {
            segmentTree[index] += lazy[index] * (end - start + 1);

            if (start != end) {
                
                lazy[2 * index + 1] += lazy[index];
                lazy[2 * index + 2] += lazy[index];
            }

            lazy[index] = 0; 
        }

        
        if (queryEnd < start || queryStart > end) {
            return 0;
        }

        
        if (queryStart <= start && queryEnd >= end) {
            return segmentTree[index];
        }

        
        int mid = start + (end - start) / 2;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        int leftSum = rangeQuery(leftChild, start, mid, queryStart, queryEnd);
        int rightSum = rangeQuery(rightChild, mid + 1, end, queryStart, queryEnd);

        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11};

        SegmentTreeRangeUpdate segmentTree = new SegmentTreeRangeUpdate(array);

        
        System.out.println("Sum in range [1, 4]: " + segmentTree.rangeQuery(1, 4));

        
        segmentTree.rangeUpdate(2, 4, 2);

        
        System.out.println("Updated sum in range [1, 4]: " + segmentTree.rangeQuery(1, 4));
    }
}

