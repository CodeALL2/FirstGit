package No15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int k;
        Arrays.sort(nums);
        List <List<Integer>> res = new ArrayList<>();

        for (k = 0; k < nums.length - 2; k++){
            if (nums[k] > 0){
                break;
            }
            int i = k + 1;
            int j = nums.length - 1;

            if (k > 0 && nums[k] == nums[k - 1]){
                continue;
            }

            while (i < j){
                int num = nums[k] + nums[i] + nums[j];
                if (num < 0){
                    while (i < j && nums[i] == nums[i + 1]){
                        i++;
                    }
                    i++;
                }else if(num > 0){

                    while (i < j && nums[j] == nums[j - 1]){
                        j--;
                    }
                    j--;
                }else {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(i);
                    integers.add(j);
                    integers.add(k);
                    res.add(integers);

                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }

        }
        return res;
    }
}
