import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Avion {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] tickets = new int[n];

		for (int i = 0; i < n; i++) {
			tickets[i] = scanner.nextInt();
		}

		int maxPassengers = getMaxPassangers(tickets, n);

		System.out.println(maxPassengers);
		scanner.close();
	}

	public static int[] getPossibleFirstSums(int[] passengers, int n) {
		int[] possibleFirstSums = new int[4];
		possibleFirstSums[0] = passengers[0] + passengers[1]; // suma primilor 2 pasageri
		possibleFirstSums[1] = passengers[n - 1] + passengers[n - 2]; // suma ultimilor 2 pasageri
		possibleFirstSums[2] = passengers[0] + passengers[n - 1]; // suma dintre primul si ultimul pasager
		return possibleFirstSums;
	}

	public static int getMaxPassangers(int[] passengers, int n) {
		int[] possibleFirstSums = getPossibleFirstSums(passengers, n);
		ArrayList<Integer> maxPassengersList = new ArrayList<>();

		for (int cnt = 0; cnt < 3; cnt++) {
			int possiblePassengers = 0;
			int i = 0;
			int j = n - 1;
			while (i < j) {
				if (passengers[i] + passengers[i + 1] == possibleFirstSums[cnt]) {
					possiblePassengers += 2;
					i += 2;
					continue;
				}
				if (passengers[j] + passengers[j - 1] == possibleFirstSums[cnt]) {
					possiblePassengers += 2;
					j -= 2;
					continue;
				}
				if (passengers[i] + passengers[j] == possibleFirstSums[cnt]) {
					possiblePassengers += 2;
					i++;
					j--;
				} else {
					break;
				}
			}
			maxPassengersList.add(possiblePassengers);
		}
		maxPassengersList.sort(Collections.reverseOrder());
		return maxPassengersList.get(0);
	}

}
