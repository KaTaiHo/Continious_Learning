public class IntegerToEnglishWords 
{
    private String[] underTwenty = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen" 
, "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Ninteen"};
    private String[] underHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Nintey"};

    public String numberToWords(int num)
    {
        if (num == 0)
        {
            return "Zero";
        }

        return helper(num);
    }

    public String helper(int num) 
    {
        String result = new String();

        if (num < 20)
        {
            result = underTwenty[num];
        }
        else if (num < 100)
        {
            result = underHundred[num/10] + " " + helper(num % 10);
        }
        else if (num < 1000)
        {
            result = helper(num/100) + " Hundred " + helper(num % 100);
        }
        else if (num < 1000000)
        {
            result = helper(num/1000) + " Thousand " + helper(num % 1000);
        }
        else if (num < 1000000000)
        {
            result = helper(num/1000000) + " Million " + helper(num % 1000000);
        }
        else
        {
            result = helper(num/1000000000) + " Billion " + helper(num % 1000000000);
        }

        return result.trim();
    }

    public static void main(String[] args) {
        IntegerToEnglishWords temp = new IntegerToEnglishWords();

        System.out.println(temp.numberToWords(5000));
        System.out.println(temp.numberToWords(5864));
        System.out.println(temp.numberToWords(586434534));
    }
}