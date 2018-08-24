import java.util.LinkedList;

public class Solution
{
    public List<String> letterCombinations(String digits)
    {
        String[] phonePad = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        LinkedList<String> answer = new LinkedList<>();

        if (digits == null || digits.length() == 0)
        {
            return answer; 
        }

        while (answer.peek().length() != digits.length())
        {
            String remove = answer.remove();
            String padLetters = phonePad[digits.charAt(remove.length()) - '0'];

            for (char c : padLetters.toCharArray())
            {
                answer.add(remove + c);
            }
        }

        return answer;
    }
}