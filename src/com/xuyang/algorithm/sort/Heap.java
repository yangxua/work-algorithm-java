package com.xuyang.algorithm.sort;

/**
 * @Auther: allanyang
 * @Date: 2019/11/6 15:47
 * @Description:
 */
public class Heap<T extends Comparable<T>> {

    private T[] heap;
    private int n = 0;

    public Heap(int maxN) {
        this.heap = (T[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private void swap(int i, int j) {
        T t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j+1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private void insert(T v) {
        heap[++n] = v;
        swim(n);
    }

    private T delMax() {
        T max = heap[1];
        swap(1, n--);
        heap[n+1] = null;
        sink(1);
        return max;
    }

}