import java.util.*;

public class Emu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String message = scanner.nextLine();
		scanner.close();

		String ans = findKey(message);

		if (ans.isEmpty()) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	private static String findKey(String message) {
		String key1, key2, prefix;
		int len;

		for (int i = 1; i <= message.length() / 2; i++) {
			len = i;
			if (2 * len > message.length()) {
				continue;
			}
			key1 = message.substring(0, len);
			key2 = message.substring(len, 2 * len);
			prefix = message.substring(2 * len);

			if (key1.equals(key2) && !prefix.equals(key1) && key1.startsWith(prefix)) {
				return key1;
			}
		}

		return "";
	}
}