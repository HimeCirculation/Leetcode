public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(intToRoman(3749));
    }

    public static String intToRoman(int num){
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}; 
        int cur = 0;
        StringBuilder roman = new StringBuilder();

        while(num > 0){
            int amount = num / nums[cur];
            for(; amount > 0; amount--){
                roman.append(numerals[cur]);
            }
            num %= nums[cur];
            cur++;
        }
        return roman.toString();
    }
}
