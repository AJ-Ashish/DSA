class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int steps = 0;
        int maxCapacity = capacity;

        int i = 0;
        while(i < plants.length) {
            if(plants[i] <= capacity) {
                capacity -= plants[i];
                steps++;
                i++;
           }else {
                steps += 2 * i;
                capacity = maxCapacity;
           }
        }
        return steps;
        
    }
}