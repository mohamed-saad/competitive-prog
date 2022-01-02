package competitive.leetcode.easy.misc;

public class ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
    	StringBuilder title = new StringBuilder();
    	while(columnNumber != 0) {
    		int index = columnNumber - 1;
    		title.append((char)(index%26 + 'A'));
    		columnNumber = index/26;
    	}
    	return title.reverse().toString();
    }
    
    
    public static void main(String[] args) {
    	for (int i=1; i<702; i++)
    		System.out.println(i + "\t" + new ExcelSheetColumnTitle().convertToTitle(i));
	}
}
