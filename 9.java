class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        int xLen = len(x);
        int middle = xLen / 2;
        int[] stack = new int[middle];
        int i = 0;
        for(; i < middle; i++){
            stack[i] = x % 10;
            x /= 10;
        }

        if(xLen % 2 != 0){
            x /= 10;
        }
        
        for(; i > 0; i--){
            if(stack[i-1] != x % 10){
                return false;
            }
            x /= 10;
        }
        return true;
    }

    public static int len(int x){
        int count = 0;
        while(x > 0){
            x /= 10;
            count++;
        }
        return count;
    }
}