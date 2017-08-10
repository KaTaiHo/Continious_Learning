import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
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

	public List<Integer> spiralOrder(int[][] matrix) {
        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = matrix.length;
        int colEnd = matrix[0].length;
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while (rowBegin < rowEnd && colBegin < colEnd) {
            //print left to right
            for (int i = colBegin; i < colEnd; i++) {
                result.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            
            //print top to bottom
            for (int i = rowBegin; i < rowEnd; i++) {
                result.add(matrix[i][colEnd - 1]);
            }
            colEnd--;
            
            //print right to left
            for (int i = colEnd; i > colBegin; i--) {
                result.add(matrix[rowEnd - 1][i]);
            }
            rowEnd--;
            
            //bottom to top
            for (int i = rowEnd; i > rowBegin; i--) {
                result.add(matrix[i][colBegin]);
            }
            colBegin++;
        }
        return result;
    }

	public static void main(String[] args) {
		Chapter1_2 temp = new Chapter1_2();
		System.out.println(temp.isPermutation("hello", "elloh"));
		System.out.println(temp.spiralOrder(new int [][]{{1,2,3},{4,5,6},{7,8,9}}));
	}
}
