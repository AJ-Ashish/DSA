class Solution {
    public int brokenCalc(int startValue, int target) {
        int operation = 0;

        while(target > startValue) {
            if(target%2==0 ) {
                target = target/2;
            }else {
                target+=1;
            }
            operation++;
        }
        return operation + (startValue - target);
    }
}