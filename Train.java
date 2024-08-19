import java.util.*;

public class Train {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		PriorityQueue<Long> queue = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			queue.add((long) scanner.nextInt());
		}

		long totalTime = 0;
		while (queue.size() > 1) {
			long first = queue.poll();
			long second = queue.poll();
			long cost = first + second;
			totalTime += cost;
			queue.add(cost);
		}

		System.out.println(totalTime);
		scanner.close();
	}
}
