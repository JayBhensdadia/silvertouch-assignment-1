package JavaOne.Algorithms.HeapSort;

public class HeapSort {

    public static void upHeapify(int[] arr, int si) {

        // upHeapify from index si
        int childIndex = si;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0 && arr[childIndex] < arr[parentIndex]) {
            int temp = arr[childIndex];
            arr[childIndex] = arr[parentIndex];
            arr[parentIndex] = temp;

            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }

    }

    public static void downHeapify(int[] arr, int si, int ei) {

        int parentIndex = si;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        while (leftChildIndex < ei) {

            int minIndex = parentIndex;

            if (arr[leftChildIndex] < arr[minIndex]) {
                minIndex = leftChildIndex;
            }

            if (rightChildIndex < ei && arr[rightChildIndex] < arr[minIndex]) {
                minIndex = rightChildIndex;
            }

            if (minIndex == parentIndex) {
                break;
            }

            int t = arr[parentIndex];
            arr[parentIndex] = arr[minIndex];
            arr[minIndex] = t;

            parentIndex = minIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;

        }

    }


    public static void inplaceHeapSort(int arr[]) {

        int n = arr.length;

        // stage - 1 (building Heap) -O(nlogn)

        for (int i = 1; i < n; i++) {

            // upHeapify from index i
            upHeapify(arr, i);

        }

        // stage - 2 (deleting from heap) -O(nlogn)

        for (int i = n - 1; i >= 0; i--) {

            // swap a[i] with a[0]

            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // down Heapify untill i-1

            downHeapify(arr, 0, i);

        }

    }

    public static void inplaceHeapSort2(int[] arr) {

        int n = arr.length;

        // stage - 1 (building Heap) -O(n)

        for (int i = n / 2 - 1; i >= 0; i--) {

            // downHeapify from index i

            downHeapify(arr, i, n);

        }

        // stage - 2 (deleting from heap) -O(nlogn)

        for (int i = n - 1; i >= 0; i--) {

            // swap a[i] with a[0]

            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // down Heapify untill i-1

            downHeapify(arr, 0, i);

        }

    }

    public static void main(String[] args) {

        int[] a = { 11, 2, 3, 4, 55, 77 };

        System.out.println("decreasing Order:");
        inplaceHeapSort(a);

        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

}
