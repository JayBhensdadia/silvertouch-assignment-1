package Hashing;

import java.util.HashSet;

public class IntersectionOfArrays {

    public static int[] findIntersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersectionSet = new HashSet<>();

        
        for (int num : nums1) {
            set.add(num);
        }

        
        for (int num : nums2) {
            if (set.contains(num)) {
                intersectionSet.add(num);
            }
        }

        
        int[] result = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            result[index++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2,3,4, 1,4,5,6,6};
        int[] nums2 = {2, 2,3,4,1,8,9};

        int[] intersection = findIntersection(nums1, nums2);

        System.out.print("Intersection of arrays: ");
        for (int num : intersection) {
            System.out.print(num + " ");
        }
    }
}

