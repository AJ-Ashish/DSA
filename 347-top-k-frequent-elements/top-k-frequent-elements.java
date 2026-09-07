// With comparable inside element logic of compare based on frequency 

// class Solution {
//     class Element implements Comparable<Element> {
//         int num;
//         int frequency;

//         public Element(int num, int frequency) {
//             this.num = num;
//             this.frequency = frequency;
//         }

//         @Override
//         public int compareTo(Element e2) {
//             return Integer.compare(this.frequency, e2.frequency);
//         }
//     }
//     public int[] topKFrequent(int[] nums, int k) {
//         HashMap<Integer,Integer> map = new HashMap<>();

//         for(int num : nums) {
//             map.put(num, map.getOrDefault(num,0)+1);
//         }

//         PriorityQueue<Element> pq = new PriorityQueue<>();
//         for(int num : map.keySet()) {
//             pq.offer(new Element(num, map.get(num)));
//             if(pq.size() > k) {
//                 pq.poll();
//             }
//         }
//         int result[] = new int[pq.size()];
//         int idx = 0;
//         while(!pq.isEmpty()) {
//             result[idx] = pq.poll().num;
//             idx++;
//         } 
//         return result;  
//     }
// }

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(map.get(a), map.get(b)));

        for(int num : map.keySet()) {
            pq.offer(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int result[] = new int[k];
        for(int i=0; i<k; i++) {
            result[i] = pq.poll();
        } 
        return result;  

    }
}