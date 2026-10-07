class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        
        int n = tokens.length;
        int i = 0;
        int j = n-1;
        int maxScore = 0;
        int score = 0;

        Arrays.sort(tokens);

        while(i <= j) {
            if(power >= tokens[i]) {
                power -= tokens[i];
                score++;
                maxScore = Math.max(maxScore,score);
                i++;
            }else if(score >= 1) {
                    power += tokens[j];
                    score--;
                    j--;
            }else {
                return maxScore;
            }
        }
        return maxScore;
    }
}