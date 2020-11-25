package offer;

public class MinArray {
    public int minArray(int[] nums) {
        int res = nums[0];
        if(nums.length == 1)
            return nums[0];
        else{
            for(int i = 0; i <= nums.length - 2; i++){
                if(nums[i] > nums[i+1]){
                    res = nums[i+1];
                    break;
                }
            }
        }
        return res;
    }
}
