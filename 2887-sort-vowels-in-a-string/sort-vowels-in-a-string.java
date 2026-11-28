class Solution {
    public String sortVowels(String s) {
        
        // we can also take 
        // String vowel = "aeiouAEIOU" as vowel string and compare vowel.indexOf(c)

        char[] arr = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();

        // Store vowels in arrayList
        for(char c : arr) {
            if("aeiouAEIOU".indexOf(c) != -1) {
                list.add(c);
            }
            
        }
        // Sort the vowels
        Collections.sort(list);

        // Replace the vowels 
        int idx = 0;
        for(int i=0; i<arr.length; i++) {
            char c = arr[i];
            if("aeiouAEIOU".indexOf(c) != -1) {
                arr[i] = list.get(idx++);
            }
        }
        return new String(arr);

    }
}