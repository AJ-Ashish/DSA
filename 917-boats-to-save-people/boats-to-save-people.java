class Solution {
        // Because the heaviest person always gets a boat, either:
        // - with the lightest person, or
        // - alone.
        // The only question is whether left also gets into that boat.
        // Sorting: O(n log n)
        // Two-pointer traversal: O(n)
        // Overall: O(n log n)
        // Extra space: O(1) apart from Java's sorting implementation.
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int i = 0;
        int j = people.length-1;
        int boat = 0;

        while(i <= j) {
            // Try to pair the heaviest person with the lightest
            if(people[i] + people[j] <= limit) {
                i++;
                j--;
            }
            // Heaviest person definitely gets a boat
            else {
                j--;
            }
            
            boat++;
            
        }
       
        return boat;
    }
}