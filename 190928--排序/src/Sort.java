public class Sort {
    public static void mergeSort(int[] array) {
        mergeSortInter(array, 0, array.length);
    }
    // 待排区间[low, high)
    private static void mergeSortInter(int[] a, int low, int high) {
        if (low >= high - 1) {
            return;
        }
        int mid = (low + high) / 2;//没有考虑溢出
        // [low, mid)
        // [mid, high)
        mergeSortInter(a, low, mid);
        mergeSortInter(a, mid, high);
        merge(a, low, mid, high);
    }
    private static void merge(int[] a, int low, int mid, int high) {
        int length = high - low;
        int[] extra = new int[length];

        int i = low;
        int j = mid;
        int k = 0;

        while (i < mid && j < high) {
            if (a[i] <= a[j]) {
                extra[k++] = a[i++];
            } else {
                extra[k++] = a[j++];
            }
        }
        while (i < mid) {
            extra[k++] = a[i++];
        }
        while (j < high) {
            extra[k++] = a[j++];
        }
        for (int x = 0; x < length; x++) {
            a[low + x] = extra[x];
        }
    }

    ////////////////////////////////////////////////////////////////

    public static void mergeSort2(int[] array) {
        int[] extra = new int[array.length];
        mergeSortInter2(array, 0, array.length, extra);
    }
    private static void mergeSortInter2(int[] array, int low, int high, int[] extra) {
        if (low >= high - 1) {
            return;
        }

        int mid = (low + high) / 2;
        mergeSortInter2(array, low, mid, extra);
        mergeSortInter2(array, mid, high, extra);
        merge2(array, low, mid, high, extra);
    }
    private static void merge2(int[] a, int low, int mid, int high, int[] extra) {
        int length = high - low;
        int i = low;
        int j = mid;
        int k = 0;

        while (i < mid && j < high) {
            if (a[i] <= a[j]) {
                extra[k++] = a[i++];
            } else {
                extra[k++] = a[j++];
            }
        }
        while (i < mid) {
            extra[k++] = a[i++];
        }
        while (j < high) {
            extra[k++] = a[j++];
        }
        for (int x = 0; x < length; x++) {
            a[low + x] = extra[x];
        }
    }

    //非递归方法
    public static void mergeSort3(int[] array) {
        for (int i = 1; i < array.length; i = i * 2) {
            for (int j = 0; j < array.length; j = j + 2 * i) {
                int low = j;
                int mid = j + i;
                if (mid >= array.length) {
                    continue;
                }
                int high = mid + i;
                if (high > array.length) {
                    high = array.length;
                }

                merge(array, low, mid, high);
            }
        }
    }
}
