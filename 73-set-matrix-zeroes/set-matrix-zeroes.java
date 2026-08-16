class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    map.putIfAbsent(i,new ArrayList<>());
                    map.get(i).add(j);
                }
            }
        }

        for(int num : map.keySet()) {
            for(int value : map.get(num)) {
                for(int i=0; i<n; i++) {
                matrix[num][i] = 0;
            }
            for(int i=0; i<m; i++) {
                matrix[i][value] = 0;
            }
            }
            
        }
        
     }
}