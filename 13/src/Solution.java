class Solution {    
    public int romanToInt(String roman){
        int[] nums = new int[]{1000, 500, 100, 50, 10, 5, 1};
        char[] numerals = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int num = 0;

        for(int i = 0; i < roman.length(); i++){
            // find index
            int index = 0;
            for(; index < numerals.length; index++){
                if(numerals[index] == roman.charAt(i)){
                    break;
                }
            }

            if(index > 1 && i < roman.length() - 1 && (roman.charAt(i + 1) == numerals[index - 1] || roman.charAt(i + 1) == numerals[index - 2])){
                num -= nums[index];
            }
            else{
                num += nums[index];
            }
        }

        return num;
    }
}
