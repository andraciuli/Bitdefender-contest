import java.util.Arrays;
import java.util.Scanner;

public class Potiuni {
	static final int MOD = 1000000007;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		int[] gandal = new int[n];
		for (int i = 0; i < n; i++) {
			gandal[i] = scanner.nextInt();
		}

		int[] merlin = new int[n];
		for (int i = 0; i < n; i++) {
			merlin[i] = scanner.nextInt();
		}
		int result = potiuni(n, gandal, merlin);
		System.out.println(result);
		scanner.close();

	}

	public static int potiuni(int n, int[] gandal, int[] merlin) {
		int[] difference = new int[n];
		for (int i = 0; i < n; i++) {
			difference[i] = gandal[i] - merlin[i];
		}

		Arrays.sort(difference);

		int left = 0;
		int right = n - 1;
		long result = 0;

		while (left < right) {
			if (difference[left] + difference[right] > 0) {
				result += (right - left);
				right--;
			} else {
				left++;
			}
		}

		return (int) (result % MOD);
	}
}
