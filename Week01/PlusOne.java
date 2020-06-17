public class PlusOne {

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        boolean flag = false;
        for (int i = length -1; i >= 0; i --) {

            int val = digits[i];
            if (val + 1 == 10) {
                digits[i] = 0;
                if (i > 0) {
                    processTen(i - 1, digits);
                }
            } else {
                digits[i] = val + 1;
                flag = true;
            }
            if (flag){
                break;
            }
        }
        if (!flag) {
            int[] newArr = new int[length + 1];
            newArr[0] = 1;
            return newArr;
        }
        return digits;
    }

    private void processTen(int currentIndex, int[] digits) {
        if ((9 == digits[currentIndex]) || (0 == digits[currentIndex])) {
            return;
        }
    }
}
