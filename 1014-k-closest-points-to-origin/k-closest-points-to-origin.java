class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Create a max-heap based on the distance from the origin
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));

        // Add points to the heap, and remove the farthest point if heap size exceeds k
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Collect the k closest points from the heap
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }
}