class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while(right > left){
            int min;
            if(height[left] < height[right]){
                min = height[left];
                left++;
            }
            else{
                min = height[right];
                right--;
            }
            int vol = min * ((right - left ) + 1);
            if(vol > max){
                max = vol;
            }
        }
        return max;
    }
}
