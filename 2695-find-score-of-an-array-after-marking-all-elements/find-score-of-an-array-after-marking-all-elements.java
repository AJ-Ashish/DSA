// Approach 1 . SOrting 
// Approach 2 minHeap

// TC = O(nlogn) SC = O(n)

// class Solution {
//     public long findScore(int[] nums) {
//         int n = nums.length; 
//         long score = 0;

//         int arr[][] = new int[n][2];
//         for(int i=0; i<n; i++) {
//             arr[i][0] = nums[i];
//             arr[i][1] = i;
//         }

//         Arrays.sort(arr, (a,b) -> {
//             if(a[0] != b[0]) {
//                 return Integer.compare(a[0],b[0]);
//             }
//             return Integer.compare(a[1], b[1]);
//         });
//         boolean visited[] = new boolean[nums.length];

//         for(int i=0; i<n; i++) {
//             int smallest = arr[i][0];
//             int idx = arr[i][1];

//             if(visited[idx] == true) continue;

//             score += smallest;
//             visited[idx] = true;
//             if(idx - 1 >= 0) {
//                 visited[idx - 1] = true;
//             }
//             if(idx + 1 < nums.length) {
//                 visited[idx + 1 ] = true;
//             }
//         }
//         return score;
//     }
// }



class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        long score = 0;

        // {value, index}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{nums[i], i});
        }

        boolean[] marked = new boolean[n];

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();

            int value = current[0];
            int index = current[1];

            if (marked[index]) {
                continue;
            }

            score += value;

            marked[index] = true;

            if (index > 0) {
                marked[index - 1] = true;
            }

            if (index < n - 1) {
                marked[index + 1] = true;
            }
        }

        return score;
    }
}