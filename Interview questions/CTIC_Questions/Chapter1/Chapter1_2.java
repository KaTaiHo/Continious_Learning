import java.util.HashMap;

// Question 1.2 Check Permutation Given two strings, write a method to decide if 
// one is a permutation of the other.

public class Chapter1_2 {
	public Chapter1_2() {

	}

	public boolean isPermutation(String str1, String str2) {
		int[] arr = new int[128];

		if (str1.length() != str2.length()) {
			return false;
		}

		for (int i = 0; i < str1.length(); i++) {
			arr[str1.charAt(i) - 'a']++;
		}

		for (int i = 0; i < str2.length(); i++) {
			arr[str2.charAt(i) - 'a']--;
		}

		for (int i = 0; i < str2.length(); i++) {
			if (arr[i] != 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Chapter1_2 temp = new Chapter1_2();
		System.out.println(temp.isPermutation("hello", "elloh"));
	}
}
