class Solution {
    // TC = O(n) SC = O(1)
    // At most hashmap will store 10 different vowel keys,so its auxiliary space is constant.
    public String sortVowels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        String vowels = "AEIOUaeiou";

        for(char c : s.toCharArray()) {
            if(vowels.indexOf(c) != -1) {
                map.put(c, map.getOrDefault(c,0)+1);
            }
        }
        StringBuilder sb = new StringBuilder();
        int j = 0;

        for(char c : s.toCharArray()) {
            if(vowels.indexOf(c) != -1) {
                
                while(j < vowels.length() && !map.containsKey(vowels.charAt(j))) {
                    j++;
                }
                char vowel = vowels.charAt(j);
                sb.append(vowel);
                map.put(vowel, map.get(vowel)-1);
                if(map.get(vowel) == 0) {
                    map.remove(vowel);
                }
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}








// class Solution {
// TC = O(nlogn) SC = O(n)
//     public String sortVowels(String s) {
        
//         // we can also take 
//         // String vowel = "aeiouAEIOU" as vowel string and compare vowel.indexOf(c)

//         char[] arr = s.toCharArray();
//         ArrayList<Character> list = new ArrayList<>();

//         // Store vowels in arrayList
//         for(char c : arr) {
//             if("aeiouAEIOU".indexOf(c) != -1) {
//                 list.add(c);
//             }
            
//         }
//         // Sort the vowels
//         Collections.sort(list);

//         // Replace the vowels 
//         int idx = 0;
//         for(int i=0; i<arr.length; i++) {
//             char c = arr[i];
//             if("aeiouAEIOU".indexOf(c) != -1) {
//                 arr[i] = list.get(idx++);
//             }
//         }
//         return new String(arr);

//     }
// }