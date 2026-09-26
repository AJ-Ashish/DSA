class Solution {
//      TC = O(nlogn) 
//      projects → O(n)
//      maxHeap  → O(n)
//      SC = O(n)
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int project[][] = new int[n][2];

        for(int i=0; i<n; i++) {
            project[i][0] = capital[i];
            project[i][1] = profits[i];
        }

        Arrays.sort(project, (a,b) -> Integer.compare(a[0],b[0]));

        int i = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int count = 0; count < k; count++) {
            while(i< n && project[i][0] <= w) {
                maxHeap.offer(project[i][1]);
                i++;
            }
            if(maxHeap.isEmpty()) {
                break;
            }

            int profit = maxHeap.poll();
            w += profit;
        }
        return w;
    }
}