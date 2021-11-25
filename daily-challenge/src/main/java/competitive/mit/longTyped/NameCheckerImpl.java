package competitive.mit.longTyped;

public class NameCheckerImpl {
	boolean isLongTyped(String name, String typed) {
		char[] n = name.toCharArray();
		char[] t = typed.toCharArray();
		if (t.length < n.length)
			return false; // long typed must be longer
		int c = 0;
		for (int i = 0; i < t.length; i++) {
			if (n[c] == t[i]) {
				c++; // advance to next char
			} else {
				if (c == 0 || t[i] != n[c - 1])
					return false;
			}
		}
		if (c == n.length)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		NameCheckerImpl ch = new NameCheckerImpl();
		String[][] names = new String[][] {
			{"alex", "aaleex"},
			{"saeed", "ssaaedd"},
			{"leelee", "lleeelee"},
			{"laiden", "laiden"},
		};
		for (String[] test: names) {
			System.out.println(test[0] + " " + ch.isLongTyped(test[0], test[1]));
		}
	}
}
