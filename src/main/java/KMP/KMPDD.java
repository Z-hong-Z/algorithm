package KMP;

public class KMPDD {
    public static void main(String[] args) {
        String str1 = "mississippi";
        String str2 = "issip";
        int kmp = KMP(str1, str2);
        System.out.println(kmp);
    }


    public static int KMP(String str1, String str2) {
        if (str1 == null || str2 == null || str2.length() > str1.length()) {
            return -1;
        }
        int i = 0;
        int j = 0;
        int[] next = getNext(str2);
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j];
            }
        }
        return j == str2.length() ? i - j  : -1;
    }


    public static int[] getNext(String str) {
        if (str.length() == 1) return new int[]{-1};
        int[] next = new int[str.length()];
        char[] chs = str.toCharArray();
        int i = 2;
        int index = 0;
        next[0] = -1;
        next[1] = 0;
        while (i < chs.length) {
            if (chs[i - 1] == chs[index]) {
                next[i++] = ++index;
            } else if (index > 0) {
                index = next[index];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }


}
