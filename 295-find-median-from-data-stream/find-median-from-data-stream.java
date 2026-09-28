class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> (b-a));
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);

        if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
            int val = maxHeap.poll();
            minHeap.offer(num);
        }
        if(maxHeap.size() > minHeap.size()+1){
            int val = maxHeap.poll();
            minHeap.offer(val);
        }
        if(minHeap.size() > maxHeap.size()+1){
            int val = minHeap.poll();
            maxHeap.offer(val);
        }
    }
    
    public double findMedian() {
        if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }else if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }else{
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */