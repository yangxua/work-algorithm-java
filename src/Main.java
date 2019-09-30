import com.xuyang.algorithm.multi.PlianLock;

import java.util.PriorityQueue;

public class Main {

    private int i = 0;
    private PlianLock lock = new PlianLock();

    public void incr() {
        lock.lock();
        i++;
        lock.unlock();
    }

    public int getI() {
        return i;
    }

    public static void main(String[] args) {
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else if (minHeap.peek() < num){
                minHeap.poll();
                minHeap.add(num);
            }
        }

        return minHeap.peek();
    }

}
