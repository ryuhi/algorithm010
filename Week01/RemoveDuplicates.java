public class RemoveDuplicates {


    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        if ((0 == size) || (1 == size)) {
            return size;
        }
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                if(q - p > 1){
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }
}
