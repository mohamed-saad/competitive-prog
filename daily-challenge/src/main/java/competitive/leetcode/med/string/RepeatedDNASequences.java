package competitive.leetcode.med.string;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// 	Time Limit Exceeded
public class RepeatedDNASequences {
    
	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> repeated = new HashSet<>();
		for (int i=0; i<=s.length()-10; i++) {
			// search for the sub in the string
			for (int j=i+1; j<=s.length()-10; j++) {
				boolean same = true;
				for (int k=0; k<10; k++) {
					if (s.charAt(i+k) != s.charAt(j+k)) {
						same = false;
						break;
					}
				}
				if (same) {
					repeated.add(s.substring(i, i+10));
					break;
				}
			}
        }
		List<String> list = new LinkedList<>();
		list.addAll(repeated);
		return list;
    }
	
	public static void main(String[] args) throws IOException {
		String[] test = new String[] {
				"AAAAAAAAAAAAA",
				"AAAAAAAAAA",
				"AAAAAAAAAAA",
				"BAAAAAAAAAA",
				"BAAAAAAAAAAA",
				"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
				new String(Files.readAllBytes(Paths.get("src/main/resources/dna.txt"))),
		};
//		for (int i=0; i<14; i++) {
//			test[0] = test[0] + test[0];
//		}
		System.out.println(test[0].length());
		for (String s: test){
			long start = System.currentTimeMillis();
			System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences(s));
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		}
	}
	
}
