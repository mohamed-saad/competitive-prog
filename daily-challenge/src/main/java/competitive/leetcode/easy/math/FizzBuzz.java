package competitive.leetcode.easy.math;

import java.util.LinkedList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new LinkedList<>();
        for (int i=1; i<=n; i++) {
        	boolean div3 = i%3 == 0;
        	boolean div5 = i%5 == 0;
        	if (div3 && div5) result.add("FizzBuzz");
        	else if (div5) result.add("Buzz");
        	else if (div3) result.add("Fizz");
        	else result.add(String.valueOf(i));
        }
        return result;
    }
    
    public static void main(String[] args) {
		System.out.println(new FizzBuzz().fizzBuzz(15));
	}
}
