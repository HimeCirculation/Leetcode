import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static void main(String[] args){
        for(List<Integer> pair: threeSum(new int[]{2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10})){
            System.out.println(Arrays.toString(pair.toArray()));
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triples = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            List<List<Integer>> pairs = twoSum(nums, -nums[i], i + 1, nums.length - 1);
            for(List<Integer> pair: pairs){
                triples.add(Arrays.asList(nums[i], pair.get(0), pair.get(1)));
            }
        }
        
        return triples;
    }

    public static List<List<Integer>> twoSum(int[] nums, int target, int start, int end){
           int left = start;
           int right = end;
           Integer pleft = null;
           Integer pright = null;

           List<List<Integer>> pairs = new ArrayList<>();

            while(left < right){
                if(pleft != null && nums[left] == pleft){
                    left++;
                    continue;
                }
                if(pright != null && nums[right] == pright){
                    right--;
                    continue;
                }

                int sum = nums[left] + nums[right];
                if(sum > target){
                    pright = nums[right];
                    right--;
                }
                else if(sum < target){
                    pleft = nums[left];
                    left++;
                }
                else{
                    pairs.add(Arrays.asList(nums[left], nums[right]));
                    pleft = nums[left];
                    pright = nums[right];
                    left++;
                    right--;
                }
            }
            return pairs;
    }
}