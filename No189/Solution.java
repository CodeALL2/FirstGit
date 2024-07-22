package No189;

public class Solution {
    public static void rotate(int[] nums, int k) {
        if (nums == null){
            return;
        }

        int length = nums.length; //获取数组的长度
        int []copy = new int[length];

        for (int i = 0; i < length; i++){
            copy[(i + k) % length] = nums[i];
        }

        for (int i = 0; i < length; i++){
            nums[i] = copy[i];
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }
}
