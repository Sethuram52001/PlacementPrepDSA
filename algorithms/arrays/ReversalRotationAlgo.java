import java.util.Arrays;

public class ReversalRotationAlgo {
    private static void reverse(int[] arr, int l, int r) {
        while(l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    private static void rotateLeft(int[] arr, int n, int k) {
        reverse(arr, 0, n - 1);
        reverse(arr, 0, n - k - 1);
        reverse(arr, n - k, n - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void rotateRight(int[] arr, int n, int k) {
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k = 7;
        rotateLeft(arr.clone(), arr.length, k);
        rotateRight(arr.clone(), arr.length, k);
    }
}
