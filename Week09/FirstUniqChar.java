public class FirstUniqChar {

    public int firstUniqChar(String s) {
        if (null == s || s.length() == 0) {
            return -1;
        }
        int length = s.length();
        int[] arr = new int[26];
        char[] array = s.toCharArray();
        for (char c : array) {
            arr[c - 'a']++;
        }

        for (int i = 0; i < length; i++) {
            if (arr[array[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
