package com.xuyang.algorithm.sort;

/**
 * @Auther: allanyang
 * @Date: 2019/8/22 15:14
 * @Description:
 */
public class Sorts {

    public static void main(String[] args) {
        int[] arr = new int[]{2,0,2,1,1,0};
        quickSort(arr);
        for (int i = 0;i < arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 0;i < arr.length;i++) {
            for (int j = arr.length-2;j >= 0;j--) {
                if (arr[j] > arr[j+1]) {
                    swap(arr,j+1,j);
                }
            }
        }
    }

    /**
     * 选择排序
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int minIndex = 0;
        for (int i = 0;i < arr.length;i++) {
            minIndex = i;
            for (int j = i+1;j < arr.length;j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                swap(arr, minIndex, i);
            }
        }
    }

    /**
     * 插入
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return ;
        }

        for (int i = 1;i < arr.length;i++) {
            int j = i;
            int target = arr[i];

            while (j > 0 && arr[j-1] > target) {
                arr[j] = arr[j-1];
                j--;
            }

            arr[j] = target;
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return ;
        }

        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot-1);
        quickSort(arr, pivot+1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int target = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= target) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= target) {
                left++;
            }
            arr[right] = arr[left];
        }

        arr[left] = target;
        return left;
    }

    /**
     * 堆排序
     */
    public static void heapSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }

        //建立大顶堆
        for (int i = arr.length/2-1;i >= 0; i--) {
            heapAdjust(arr, i, arr.length);
        }

        //交换堆顶与末尾元素，重新调整大顶堆
        for (int i = arr.length-1; i >= 0;i--) {
            swap(arr, 0, i);
            heapAdjust(arr, 0, i);
        }
    }


    public static void heapAdjust(int[] arr, int left, int right) {
        int tmp = arr[left];

        for (int i = 2*left+1; i < right;i = 2*i+1) {
            if (i + 1 < right && arr[i] < arr[i+1] ) {
                i++;
            }
            if (tmp > arr[i]){
                break;
            }
            arr[left] = arr[i];
            left = i;
        }

        arr[left] = tmp;
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return ;
        }

        mergeSort(arr, 0, arr.length-1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return ;
        }

        int mid = left + right >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right-left+1];

        int i = left;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= right) {
            tmp[k++] = arr[j++];
        }

        for (int p = 0;p < tmp.length;p++) {
            arr[left+p] = tmp[p];
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}