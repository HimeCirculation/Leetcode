import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        String p = "a*";
        String s = "aa";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p){
        boolean[][] T = new boolean[s.length() + 1][p.length() + 1];
        T[0][0] = true;

        // Initialise top row to set patterns that match with the empty string to true
        for(int j = 1; j <= p.length(); j++){
            // If a token has a * and the previous token matched the empty string then set this value to true
            T[0][j] = (p.charAt(j-1) == '*') && T[0][j-2];
        }

        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){
                if(p.charAt(j-1) != '*'){
                    // If chars match then set the value to the value of the previous characters in the string and pattern
                    T[i][j] = (p.charAt(j-1) == '.' || s.charAt(i-1) == p.charAt(j-1))
                                && T[i-1][j-1];
                }
                else{
                    // Two cases make the * character match: 0 occurances or at least one occurance
                    // 0 occurances: Set the value to the value of two characters prior in the pattern (as this token doesnt matter due to 0 occurances)
                    // 1+: If the characters match, set the value to the value of the previous character in the string (not the pattern as this repeats)
                    T[i][j] = T[i][j-2] ||
                        ((p.charAt(j-2) == '.' || s.charAt(i-1) == p.charAt(j-2)) && T[i-1][j] );
                }
            }
        }
        
        // The final element in the array represents the full pattern matching the full string
        return T[s.length()][p.length()];
    }

}
