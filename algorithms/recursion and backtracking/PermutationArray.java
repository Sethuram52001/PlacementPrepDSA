/*
Logic: backtracking and swaping

Time Complexity: O(N! X N)

Space Complexity: O(1)
*/

public class PermutationArray {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(nums, 0, permutations);
        return permutations;
    }
    
    private void backtrack(int[] nums, int idx, List<List<Integer>> permutations) {
        if(idx == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for(int i : nums) {
                permutation.add(i);
            }
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        
        for(int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            backtrack(nums, idx + 1, permutations);
            swap(nums, idx, i);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permuteExtraSpace(int[] nums) {
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
