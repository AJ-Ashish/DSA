class Solution {
    public int maxDiff(int num) {
        char[] arr = String.valueOf(num).toCharArray();


        if(arr.length == 1) {
            return 8;
        }
        int i =0;
        while(i < arr.length && arr[i] == '9') {
            i++;
        }
        char a1 = arr[i];
        int num1 = 0;

        for(int j=0; j<arr.length; j++) {
            char c = arr[j];
            if(j >= i) {
                num1 = (c == a1) ? num1 * 10 + 9 : num1 * 10 + (c-'0');
            }else {
                num1 = num1 * 10 + (c -'0');
            }
            
        }

        i = 0;
        
        while(i < arr.length && (arr[i] == '1' || arr[i] == '0')) {
            i++;
        }

        if(i == arr.length) {
            return num1 - num;
        }
        char a2 = arr[i];
        int makeMin = (i != 0) ? 0 : 1;
        int num2 = 0;

        for(int j=0; j<arr.length; j++) {
            char c = arr[j];
            if(j >= i) {
                num2 = (c == a2) ? num2 * 10 + makeMin : num2 * 10 + (c-'0');
            }else {
                num2 = num2 * 10 + (c-'0');
            }
        }

        return num1 - num2;
    }
}