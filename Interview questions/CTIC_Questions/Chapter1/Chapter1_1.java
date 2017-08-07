import java.util.Arrays;
import java.util.HashSet;

// Question 1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters. 
// What if you cannot use additional data structures?

public class Chapter1_1{

	public Chapter1_1() {

	}

	public boolean isUnique(String str) {
		HashSet<Character> mySet = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			if (mySet.contains(str.charAt(i))) {
				return false;
			}
			mySet.add(str.charAt(i));
		}
		return true;
	}

	public static void main(String[] args) {
		Chapter1_1 temp = new Chapter1_1();
		System.out.println(temp.isUnique("abccccc"));
		System.out.println(temp.isUnique("abc"));

	}
}
