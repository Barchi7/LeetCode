/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = searchPeak(mountainArr);

        // Search in the first half
        int index = binarySearchAscending(mountainArr, target, 0, peak);
        if (index != -1) return index;

        // Search in the second half
        index = binarySearchDescending(mountainArr, target, peak, mountainArr.length() - 1);
        return index;
    }

    private int searchPeak(MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private int binarySearchAscending(MountainArray mountainArr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midElement = mountainArr.get(mid);
            if (midElement == target) {
                return mid;
            } else if (midElement < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private int binarySearchDescending(MountainArray mountainArr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midElement = mountainArr.get(mid);
            if (midElement == target) {
                return mid;
            } else if (midElement < target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
