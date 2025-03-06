import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        String p = "a*";
        String s = "aa";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p){
        // Only need to store the two most recent rows
        boolean[] prev = new boolean[p.length() + 1];
        boolean[] curr = new boolean[p.length() + 1];
        prev[0] = true;

        // Each iteration relies on propogating a true value from the previous row
        // If a row has no true values, a match is not possible
        // Hence we can exit early if we build a row with no trues
        boolean possible = false;

        // Initialise top row to set patterns that match with the empty string to true
        for(int j = 1; j <= p.length(); j++){
            // If a token has a * and the previous token matched the empty string then set this value to true
            prev[j] = (p.charAt(j-1) == '*') && prev[j-2];
        }

        for(int i = 1; i <= s.length(); i++){
            curr = new boolean[p.length() + 1];
            for(int j = 1; j <= p.length(); j++){
                if(p.charAt(j-1) != '*'){
                    // If chars match then set the value to the value of the previous characters in the string and pattern
                    curr[j] = (p.charAt(j-1) == '.' || s.charAt(i-1) == p.charAt(j-1))
                                && prev[j-1];
                }
                else{
                    // Two cases make the * character match: 0 occurances or at least one occurance
                    // 0 occurances: Set the value to the value of two characters prior in the pattern (as this token doesnt matter due to 0 occurances)
                    // 1+: If the characters match, set the value to the value of the previous character in the string (not the pattern as this repeats)
                    curr[j] = curr[j-2] ||
                        ((p.charAt(j-2) == '.' || s.charAt(i-1) == p.charAt(j-2)) && prev[j] );
                }
                // If there is at least one true then a match is possible
                possible |= curr[j];
            }
            if(!possible){ return false; }
            else { possible = false; }
            
            prev = curr;
        }
        
        // The final element in the array represents the full pattern matching the full string
        return curr[p.length()];
    }
}
