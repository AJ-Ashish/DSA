class MedianFinder {
    PriorityQueue<Integer> leftMaxHeap ;
    PriorityQueue<Integer> rightMinHeap ;
    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {

        if(leftMaxHeap.isEmpty() || num <= leftMaxHeap.peek()) {
            leftMaxHeap.offer(num);
        }else {
            rightMinHeap.offer(num);
        }
        
        if(leftMaxHeap.size() > rightMinHeap.size() + 1) {
            rightMinHeap.offer(leftMaxHeap.poll());
        }else if(leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.offer(rightMinHeap.poll());
        }
    }
    
    public double findMedian() {
        if(leftMaxHeap.size() == rightMinHeap.size()) {
            double mean = (double) (leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
            return mean;
        }
        return leftMaxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */