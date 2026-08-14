class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int key = i+j;

                map.putIfAbsent(key,new ArrayList<>());
                map.get(key).add(mat[i][j]);
            }
        }

        int result[] = new int[m*n];
        int index = 0;

        for(int diagnol = 0; diagnol < m + n-1; diagnol++) {
            List<Integer> list = map.get(diagnol);

            if(diagnol % 2 == 0) {
                Collections.reverse(list);
            }
            for(int num : list) {
                result[index++] = num;
            }
        }
        return result;
    }
}