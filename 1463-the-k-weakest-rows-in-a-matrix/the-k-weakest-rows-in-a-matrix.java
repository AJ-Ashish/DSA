class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                                        (a,b) -> {
                                            if(a[0] == b[0]) {
                                                return a[1] - b[1];
                                            }
                                            return Integer.compare(a[0], b[0]);
                                        }
                                 );


        for(int i=0; i<mat.length; i++){ 
            int row[] = mat[i];
            int count = 0;
            for(int num : row) {
                if(num == 0) break;
                count++;
            }
            minHeap.offer(new int[] {count, i});
        }
        int result[] = new int[k];
        for(int i=0; i<k; i++) {
            result[i] = minHeap.poll()[1];
        }   
        return result;
    }
}