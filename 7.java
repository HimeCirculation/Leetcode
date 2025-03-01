class Solution {
    public int reverse(int x) {
        int reversed = 0;
        while(Math.abs(x) > 0){
            short unit = (short)(x % 10);

            // Overflow occurs when MAX < 10*reversed + unit
            // Rearranging gives: (MAX - unit) / 10 < reversed
            // Made absolute to work for negative values too
            if((Integer.MAX_VALUE - Math.abs(unit)) / 10 < Math.abs(reversed)){
                return 0;
            }

            reversed *= 10;
            reversed += unit;
            x /= 10;
        }

        return reversed;
    }
}
