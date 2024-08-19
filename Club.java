import java.util.*;

public class Club {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int start = scanner.nextInt();
		int end = scanner.nextInt();

		int[] cost = new int[N + 1];
		for (int i = 1; i < N + 1; i ++) {
			cost[i] = scanner.nextInt();
		}

		Graph graph = new Graph(cost, N);

		for (int i = 1; i < M + 1; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			graph.addEdge(u, v);
		}

		scanner.close();

		int res = graph.bfs(start, end);
		System.out.println(res);
	}
}

class Graph{
	int vertices;
	ArrayList<Integer>[] adjList;
	int[] cost;
	int[] d;

	public Graph(int[] cost, int vertices) {
		this.cost = cost;
		this.vertices = vertices;

		this.d = new int[vertices + 1];
		for (int i = 1; i < vertices + 1; i++) {
			d[i] = Integer.MAX_VALUE;
		}

		adjList = new ArrayList[vertices + 1];
		for (int i = 1; i < vertices + 1; i++) {
			adjList[i] = new ArrayList<>();
		}
	}

	public void addEdge(int u, int v) {
		adjList[u].add(v);
		adjList[v].add(u);
	}

	public int bfs(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		d[start] = cost[start];

		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int neighbor : adjList[node]) {
				int maxi = d[node];
				if (cost[neighbor] > maxi) {
					maxi = cost[neighbor];
				}
				if (d[neighbor] > maxi) {
					d[neighbor] = maxi;
					queue.add(neighbor);
				}

			}
		}

		if (d[end] == Integer.MAX_VALUE) {
			return -1;
		}

		return d[end];
	}
}