public class RomanToInt {
    public static int romanToInt(String s) {
    
        int i = s.length() - 1;
        int sum = 0;

        while (i >= 0)
        {
            char c = s.charAt(i);
            
            if (c == 'I')
                sum += 1 * ((sum >= 5) ? -1 : 1);
            else if (c == 'V')
                sum += 5;
            else if (c == 'X')
                sum += 10 * ((sum >= 10) ? -1 : 1);
            else if (c == 'L')
                sum += 50;
            else if (c == 'C')
                sum += 100 * ((sum >= 500) ? -1 : 1);
            else if (c == 'D')
                sum += 500;
            else 
                sum += 1000;

            i--;
        }   

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}