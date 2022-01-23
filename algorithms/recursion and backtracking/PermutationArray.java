/*

*/

public class PermutationArray {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] isTaken = new boolean[nums.length];
        backtrack(nums, isTaken, new ArrayList<>(), permutations);
        return permutations;
    }

    private void backtrack(int[] nums, boolean[] isTaken, List<Integer> permutation, List<List<Integer>> permutations) {
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isTaken[i]) {
                isTaken[i] = true;
                permutation.add(nums[i]);
                backtrack(nums, isTaken, permutation, permutations);
                isTaken[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
