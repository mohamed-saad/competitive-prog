package competitive.leetcode.easy.string;

public class LengthOfLastWord {
	
	public int lengthOfLastWord(String s) {
		int count = 0;
		boolean letterFound = false;
		for (int i = s.length() - 1; i >= 0; i--) {
			boolean currentIsLetter = (s.charAt(i) != ' ');
			if (currentIsLetter) {
				letterFound = true;
			}
			if (letterFound) {
				if (currentIsLetter)
					count++;
				else 
					break;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello Worlds"));
		System.out.println(new LengthOfLastWord().lengthOfLastWord("   fly me   to   the moon  "));
		System.out.println(new LengthOfLastWord().lengthOfLastWord("   "));
		System.out.println(new LengthOfLastWord().lengthOfLastWord("a "));
		System.out.println(new LengthOfLastWord().lengthOfLastWord("a"));
		System.out.println(new LengthOfLastWord().lengthOfLastWord(" a"));
		System.out.println(new LengthOfLastWord().lengthOfLastWord("luffy is still joyboy"));
	}
}
