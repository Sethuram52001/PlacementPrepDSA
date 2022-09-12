/*
Problem:
You have an initial power of power, an initial score of 0, and a bag of tokens where tokens[i] is the value of the ith token (0-indexed).

Your goal is to maximize your total score by potentially playing each token in one of two ways:

If your current power is at least tokens[i], you may play the ith token face up, losing tokens[i] power and gaining 1 score.
If your current score is at least 1, you may play the ith token face down, gaining tokens[i] power and losing 1 score.
Each token may be played at most once and in any order. You do not have to play all the tokens.

Return the largest possible score you can achieve after playing any number of tokens.

Link: https://leetcode.com/problems/bag-of-tokens/

Solution:
Greedy - 2 pointer: If we play a token face up, we might as well play the one with the smallest value. Similarly, if we play a token face down, 
we might as well play the one with the largest value.
*/

public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        if (tokens.length == 0) {
            return 0;
        }
        if (tokens.length == 1) {
            return power >= tokens[0] ? 1 : 0;
        }

        Arrays.sort(tokens);
        int leftPtr = 0, rightPtr = tokens.length - 1, score = 0;
        int res = 0;
        while (leftPtr <= rightPtr) {
            if (power >= tokens[leftPtr]) {
                score++;
                power -= tokens[leftPtr++];
                res = Math.max(res, score);
            } else if (rightPtr > leftPtr && score > 0) {
                score--;
                power += tokens[rightPtr--];
            } else {
                break;
            }
        }

        return score;
    }
}
