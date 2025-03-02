public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(myAtoi("   -042"));
    }

    public static int myAtoi(String s){
        int o = 0;
        short i = 0;
        boolean negative = false;
        while(i < s.length()){
            if(s.charAt(i) == ' '){
                i++;
            }
            else{
                break;
            }
        }
        
        if(s.charAt(i) == '+'){
            i++;
        }
        else if(s.charAt(i) == '-'){
            negative = true;
            i++;
        }

        while(i < s.length()){
            if(Character.isDigit(s.charAt(i))){
                int digit = s.charAt(i) - '0';     // Converts digit chars to ints as the encoding of a digit is that many numbers above the encoding of '0'
                
                if(!negative){
                    if((Integer.MAX_VALUE - digit) / 10 < o){
                        return Integer.MAX_VALUE;
                    }
                }
                else{
                    if((Integer.MIN_VALUE + digit) / 10 > o){
                        return Integer.MIN_VALUE;
                    }
                }

                o *= 10;

                if(!negative){
                    o += digit;
                }
                else{
                    o -= digit;
                }
                i++;
            }
            else{
                break;
            }
        }
        
        return o;
    }
}
